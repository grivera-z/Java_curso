/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SJ_7_CodigosEstado;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RedireccionamientoServlet", urlPatterns = {"/RedireccionamientoServlet"})
public class RedireccionamientoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Ya no Utilizamos el objecto printwriter para mandar la respuesta
        //Utilizamos el redireccionamiento
            String url= null;
            String tipoNavegador = request.getHeader("User-Agent");
            System.out.println("Tipo Navegador: " + tipoNavegador);
        //Verificamos el tipo de navegador y personalizamos el mensaje a enviar
            if(tipoNavegador != null && tipoNavegador.contains("Trident")){
               url="http://www.microsoft.com";
            }else if (tipoNavegador != null && tipoNavegador.contains("Firefox")){
               url="http://www.firefox.com";
            }else if (tipoNavegador != null && tipoNavegador.contains("Chrome")){
               url="http://www.google.com";
            }
        ///Redireccionamiento al URL Seleccionado
            response.sendRedirect(url);
    }


}
