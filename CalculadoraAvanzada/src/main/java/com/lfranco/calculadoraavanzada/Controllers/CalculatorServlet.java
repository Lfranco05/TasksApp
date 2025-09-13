package com.lfranco.calculadoraavanzada.Controllers;

import com.lfranco.calculadoraavanzada.Models.OperationLog;
import com.lfranco.calculadoraavanzada.Services.ArithmeticService;
import com.lfranco.calculadoraavanzada.Services.HistoryService;
import com.lfranco.calculadoraavanzada.Services.TemperatureService;
import com.lfranco.calculadoraavanzada.Services.TrigService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calc")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String category = req.getParameter("category");
        String op = req.getParameter("operation");
        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");
        String angleMode = req.getParameter("angleMode");
        String tempValueStr = req.getParameter("tvalue");

        String error = null;
        Double result = null;
        String description = "";

        try {
            switch (category) {
                case "arit" -> {
                    double a = parseNumber(aStr, "Primer número");
                    double b = parseNumber(bStr, "Segundo número");
                    switch (op) {
                        case "suma" -> { result = ArithmeticService.suma(a, b); description = a + " + " + b; }
                        case "resta" -> { result = ArithmeticService.resta(a, b); description = a + " - " + b; }
                        case "multi" -> { result = ArithmeticService.multiplicacion(a, b); description = a + " × " + b; }
                        case "div" -> {
                            if (b == 0.0) throw new IllegalArgumentException("División por cero no permitida");
                            result = ArithmeticService.division(a, b); description = a + " ÷ " + b;
                        }
                        default -> throw new IllegalArgumentException("Operación aritmética inválida");
                    }
                }
                case "trig" -> {
                    double x = parseNumber(aStr, "Valor");
                    boolean inDegrees = "degrees".equals(angleMode);
                    switch (op) {
                        case "sin" -> { result = TrigService.sin(x, inDegrees); description = "sin(" + x + (inDegrees?"°":"") + ")"; }
                        case "cos" -> { result = TrigService.cos(x, inDegrees); description = "cos(" + x + (inDegrees?"°":"") + ")"; }
                        case "tan" -> { result = TrigService.tan(x, inDegrees); description = "tan(" + x + (inDegrees?"°":"") + ")"; }
                        case "cot" -> { result = TrigService.cot(x, inDegrees); description = "cot(" + x + (inDegrees?"°":"") + ")"; }
                        default -> throw new IllegalArgumentException("Operación trigonométrica inválida");
                    }
                }
                case "temp" -> {
                    double v = parseNumber(tempValueStr, "Temperatura");
                    switch (op) {
                        case "c2f" -> { result = TemperatureService.celsiusToFahrenheit(v); description = v + " °C → °F"; }
                        case "f2c" -> { result = TemperatureService.fahrenheitToCelsius(v); description = v + " °F → °C"; }
                        case "c2k" -> { result = TemperatureService.celsiusToKelvin(v); description = v + " °C → K"; }
                        case "k2c" -> { result = TemperatureService.kelvinToCelsius(v); description = v + " K → °C"; }
                        default -> throw new IllegalArgumentException("Conversión de temperatura inválida");
                    }
                }
                default -> throw new IllegalArgumentException("Categoría inválida");
            }
        } catch (NumberFormatException nfe) {
            error = "Ingresa solo números válidos";
        } catch (IllegalArgumentException iae) {
            error = iae.getMessage();
        }

        if (error == null && result != null) {
            HistoryService.add(new OperationLog(description, result));
        }

        req.setAttribute("error", error);
        req.setAttribute("result", result);
        req.setAttribute("description", description);
        List<OperationLog> history = HistoryService.getLast(10);
        req.setAttribute("history", history);

        req.getRequestDispatcher("/resultados.jsp").forward(req, resp);
    }

    private double parseNumber(String s, String fieldName) {
        if (s == null || s.isBlank()) throw new IllegalArgumentException(fieldName + " es requerido");
        return Double.parseDouble(s.trim());
    }
}