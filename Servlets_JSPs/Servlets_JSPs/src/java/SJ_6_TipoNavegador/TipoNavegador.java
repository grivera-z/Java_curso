/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SJ_6_TipoNavegador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabri
 */
@WebServlet(name = "TipoNavegador", urlPatterns = {"/TipoNavegador"})
public class TipoNavegador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Creamos las variables para procesar el titullo y el mensaje de nuestra pagina
            String titulo = null;
            String mensaje = null;
            String tipoNavegador = request.getHeader("User-Agent");
        //Verificamos el tipo de navegador y personalizamos el mensaje a enviar
            if(tipoNavegador != null && tipoNavegador.contains("Gecko")){
                titulo = "Navegador Internet Explorer";
                mensaje = "Estas Navegando con internet Explorer";
            }else if (tipoNavegador != null && tipoNavegador.contains("Firefox")){
                titulo = "Navegador FireFox";
                mensaje = "Estas Navegando con Mozilla Firefox";
            }else if (tipoNavegador != null && tipoNavegador.contains("Chrome")){
                titulo = "Navegador Chrome";
                mensaje = "Estas Navegando con Google Chrome";
            }else{
                titulo = "Navegador Otro";
                mensaje = "Estas Navegando con Otro Navegador";
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+titulo+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Tipo de Navegador: "+ tipoNavegador);
            out.println("<br>");
            out.println(mensaje);
            out.println("</body>");
            out.println("</html>");
        }
    }


}
