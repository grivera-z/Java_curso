package SJ_3_ManejoParametros;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ManejoParametros", urlPatterns = {"/ManejoParametros"})
public class ManejoParametros extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Metodo doGet No soportado en el Servlet");
        out.println("</body>");
        out.println("</html>");
        out.close();        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        System.out.println("Usuario: "+usuario);
        System.out.println("Password: "+password);
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Usuario: "+usuario);
        out.println("Password: "+password);
        out.println("</body>");
        out.println("</html>");
        out.close(); 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
