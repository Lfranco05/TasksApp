package com.lfranco.sitiopersonalservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/biografia")
public class BiografiaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Biografía de Luis Angel Franco</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins&family=Orbitron&display=swap' rel='stylesheet'>");
        out.println("<style>");
        out.println("body { font-family: 'Poppins', sans-serif; background: url('fondoprincipal.jpg') no-repeat center center fixed; background-size: cover; min-height: 100vh; display: flex; flex-direction: column; align-items: center; padding: 40px 20px; position: relative; }");
        out.println("body::before { content: ''; position: absolute; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0, 0, 0, 0.6); backdrop-filter: blur(4px); z-index: 0; }");
        out.println("h1 { font-family: 'Orbitron', sans-serif; font-size: 36px; color: #00e6e6; text-shadow: 0 0 10px #00ffff; z-index: 1; margin-bottom: 20px; }");
        out.println(".card { background: rgba(255,255,255,0.08); border: 1px solid rgba(255,255,255,0.2); border-radius: 15px; padding: 30px; width: 90%; max-width: 600px; box-shadow: 0 0 15px rgba(0,255,255,0.15); backdrop-filter: blur(10px); z-index: 1; text-align: center; }");
        out.println(".card img { width: 150px; height: 150px; object-fit: cover; border-radius: 10px; margin-bottom: 20px; }");
        out.println(".card p { color: #e0f7fa; font-size: 16px; line-height: 1.6; }");
        out.println("a { color: #00e6e6; text-decoration: none; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Mi Biografía</h1>");
        out.println("<div class='card'>");
        out.println("<img src='Img/fotoluis.jpg' alt='Foto de Luis Angel Franco'>");
        out.println("<p><strong>Nombre:</strong> Luis Angel Franco</p>");
        out.println("<p><strong>Fecha de Nacimiento:</strong> 05/01/2005</p>");
        out.println("<p><strong>Edad:</strong> 20 años</p>");
        out.println("<p><strong>Nacionalidad:</strong> Guatemalteco</p>");
        out.println("<p><strong>Pasatiempos:</strong> Escuchar música, practicar natación, compartir con amigos y familia</p>");
        out.println("<p><strong>Logros Académicos:</strong> Graduarme como Ingeniero en Sistemas de la Universidad San Pablo de Guatemala</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}