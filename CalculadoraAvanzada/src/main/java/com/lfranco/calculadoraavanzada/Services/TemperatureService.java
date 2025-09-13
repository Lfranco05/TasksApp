package com.lfranco.calculadoraavanzada.Services;

public class TemperatureService {
    public static double celsiusToFahrenheit(double c) { return (c * 9.0/5.0) + 32.0; }
    public static double fahrenheitToCelsius(double f) { return (f - 32.0) * 5.0/9.0; }
    public static double celsiusToKelvin(double c) { return c + 273.15; }
    public static double kelvinToCelsius(double k) { return k - 273.15; }
}