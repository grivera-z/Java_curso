package SJ_7_CodigosEstado;

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
@WebServlet(name = "CodigoFormularioServlet", urlPatterns = {"/CodigoFormularioServlet"})
public class CodigoFormularioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CodigoFormularioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CodigoFormularioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //Simulamos algunos valores
        String usuarioCorrecto = "Juan";
        String passCorrecto = "123";
        String pUsuario = request.getParameter("usuario");
        String pPassword = request.getParameter("password");
        if (usuarioCorrecto.equals(pUsuario) && passCorrecto.equals(pPassword)){
            out.println("<h3>Datos correctos</h3>");
            out.println("Usuario: "+pUsuario);
            out.println("<br/>Password: "+pPassword);
        }else{
            //Respondemos al navegador con un codigo de estado de No Autorizado
             response.sendError(response.SC_UNAUTHORIZED,"Las credenciales son Incorrectas");
        }
        //Listado de codigos de error
        //https://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml
        out.close();
    }


}
