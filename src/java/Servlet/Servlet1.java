package Servlet;

import Clases.ClassDocente;
import Clases.ClassEstudiante;
import Clases.ClassHistoria;
import Clases.ClassUsuario;
import Clases.ClassVictima;
import Interface.InDocente;
import Interface.InEstudiante;
import Interface.InHistoria;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.InUsuario;
import Interface.InVictima;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yeisson Lopez
 */
public class Servlet1 extends HttpServlet {

    ClassUsuario usuario;
    InUsuario InUsuario = new ClassUsuario();

    ClassVictima victima;
    InVictima inVictima = new ClassVictima();

    ClassHistoria historia;
    InHistoria inHistoria = new ClassHistoria();

    ClassEstudiante estudiante;
    InEstudiante InEstudiante = new ClassEstudiante();

    ClassDocente docente;
    InDocente InDocente = new ClassDocente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        Date d = new Date(0);
        //inicio de sesion 
        HttpSession sesion;
        sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");

        usuario = InUsuario.IniciarSesion(usu, pass);

        if (usuario != null && sesion.getAttribute("usuario") == null) {

            if (inVictima.ConsultarVictima(usuario.getId_usuario()) != null) {
                sesion.setAttribute("usuario", usu);

                request.getSession().setAttribute("UsuarioNombre", usuario.getAlias());
                request.getSession().setAttribute("UsuarioCompleto", usuario.getId_usuario());

                int Num = usuario.getId_usuario();
                String cadena = Num + "";
                request.getSession().setAttribute("IdUsuario", cadena);
                response.sendRedirect("victima.jsp");
            }
            if (InEstudiante.ConsultarEstudiante(usuario.getId_usuario()) != null) {
                sesion.setAttribute("usuario", usu);

                request.getSession().setAttribute("UsuarioNombre", usuario.getAlias());
                request.getSession().setAttribute("UsuarioCompleto", usuario.getId_usuario());

                int Num = usuario.getId_usuario();
                String cadena = Num + "";
                request.getSession().setAttribute("IdUsuario", cadena);
                response.sendRedirect("Estudiante.jsp");
            }
            if (InDocente.ConsultarDocente(usuario.getId_usuario()) != null) {
                sesion.setAttribute("usuario", usu);

                request.getSession().setAttribute("UsuarioNombre", usuario.getAlias());
                request.getSession().setAttribute("UsuarioCompleto", usuario.getId_usuario());

                int Num = usuario.getId_usuario();
                String cadena = Num + "";
                request.getSession().setAttribute("IdUsuario", cadena);
                response.sendRedirect("docente.jsp");
            }

        } else {
            response.sendRedirect("index.jsp");

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (NamingException ex) {
            Logger.getLogger(Servlet1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (NamingException ex) {
            Logger.getLogger(Servlet1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void processRequestGET(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //me llega la url "proyecto/login/out"
        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        HttpSession sesion = request.getSession();
        if (action.equals("/out")) {
            sesion.invalidate();
            response.sendRedirect("/index.jsp");
        } else {

        }

    }

    @Override
    public String getServletInfo() {

        return "Short description";
    }

}
