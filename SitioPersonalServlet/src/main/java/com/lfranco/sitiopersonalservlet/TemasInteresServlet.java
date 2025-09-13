package com.lfranco.sitiopersonalservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/temas")
public class TemasInteresServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Temas de Interés</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Orbitron&family=Poppins&display=swap' rel='stylesheet'>");
        out.println("<style>");
        out.println("body { font-family: 'Poppins', sans-serif; background: url('fondoprincipal.jpg') no-repeat center center fixed; background-size: cover; margin: 0; padding: 0; position: relative; min-height: 100vh; }");
        out.println("body::before { content: ''; position: absolute; top: 0; left: 0; height: 100%; width: 100%; background-color: rgba(0,0,0,0.6); backdrop-filter: blur(5px); z-index: 0; }");
        out.println(".content { position: relative; z-index: 1; max-width: 900px; margin: 40px auto; padding: 30px; background: rgba(255,255,255,0.08); border-radius: 20px; box-shadow: 0 0 15px rgba(0,255,255,0.2); color: #e0f7fa; }");
        out.println("h1, h2 { font-family: 'Orbitron', sans-serif; color: #00e6e6; text-shadow: 0 0 10px #00ffff; }");
        out.println("p { line-height: 1.8; font-size: 16px; }");
        out.println("a { color: #00e6e6; text-decoration: none; }");
        out.println("a:hover { text-decoration: underline; }");
        out.println("img { width: 240px; height: 160px; object-fit: cover; border-radius: 12px; margin: 10px; box-shadow: 0 0 10px rgba(0,255,255,0.3); }");
        out.println("iframe { width: 100%; max-width: 560px; height: 315px; margin-top: 20px; border-radius: 12px; box-shadow: 0 0 10px rgba(0,255,255,0.3); }");
        out.println(".center { text-align: center; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='content'>");

        out.println("<h1>Temas de Interés: Familia, Cultura y Música</h1>");

        out.println("<h2>Tiempo con mi familia</h2>");
        out.println("<p>Una de las actividades que más valoro en mi vida es pasar tiempo con mi familia. Para mí, esos momentos representan una fuente de alegría, aprendizaje y conexión emocional.</p>");
        out.println("<p>Últimamente he tenido la oportunidad de compartir mucho con mi primo, quien actualmente forma parte de una banda de guerra. Lo he acompañado a cada presentación y actividad relacionada, lo cual ha sido una experiencia muy enriquecedora. No solo he aprendido más sobre el mundo de las bandas de guerra —como sus historias y las actividades realizadas en el Día de la Independencia—, sino que también he fortalecido el vínculo con él.</p>");
        out.println("<p>Ver su dedicación y pasión me ha inspirado a valorar más el compromiso y la disciplina en cualquier proyecto que uno emprenda. Además, estos encuentros han sido una oportunidad para conocer nuevas personas, ambientes y formas de expresión artística que antes no había explorado.</p>");
        out.println("<div class='center'>");
        out.println("<img src='Img/bandas.jpg' alt='Banda'>");
        out.println("<img src='Img/bandas2.jpg' alt='Lice Banda'>");
        out.println("</div>");

        out.println("<h2>Una experiencia inolvidable: Viaje a Petén</h2>");
        out.println("<p>Hace unos meses viví una experiencia inolvidable al viajar por primera vez a <strong>Petén</strong>, un lugar que siempre había querido conocer. El viaje fue especial no solo por los paisajes impresionantes y la riqueza cultural de la región, sino porque lo compartí con mi familia.</p>");
        out.println("<p>Recorrimos sitios arqueológicos, probamos platillos típicos y escuchamos historias locales que nos conectaron con las raíces de nuestra identidad. Me sorprendió la calidez de la gente y la diversidad de tradiciones que aún se conservan con orgullo.</p>");
        out.println("<p>Esa aventura me hizo reflexionar sobre la importancia de conocer nuestro país y valorar la historia que nos rodea. Desde entonces, he sentido un deseo más profundo de seguir explorando Guatemala, no solo como turista, sino como alguien que quiere entender y apreciar cada rincón de su tierra.</p>");
        out.println("<div class='center'>");
        out.println("<img src='Img/viajepeten1.jpg' alt='Avion'>");
        out.println("<img src='Img/viajepeten2.jpg' alt='Avion ventanilla'>");
        out.println("<img src='Img/viajepeten3.jpg' alt='Monumento'>");
        out.println("<img src='Img/viajepeten4.jpg' alt='Monumento dos'>");
        out.println("</div>");

        out.println("<h2>Música favorita</h2>");
        out.println("<p>La música es una parte esencial de mi vida, y una de mis canciones favoritas es:</p>");
        out.println("<p><a href='https://www.youtube.com/watch?v=2zNSgSzhBfM&list=RD2zNSgSzhBfM&start_radio=1' target='_blank'>\"Imagine Dragons - Radioactive\"</a></p>");
        out.println("<div class='center'>");
        out.println("<iframe src='https://www.youtube.com/embed/2zNSgSzhBfM' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>");
        out.println("</div>");

        out.println("<p>Esta canción me transmite una energía muy especial. La mezcla de sonidos y la intensidad de la letra me inspiran a mantenerme firme y resiliente en mis metas.</p>");

        out.println("<br><a href='index.html'>Volver al inicio</a>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}