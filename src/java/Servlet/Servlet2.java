/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.ClassDocente;
import Clases.ClassEstudiante;
import Clases.ClassHistoria;
import Clases.ClassUsuario;
import Clases.ClassVictima;
import Interface.InDocente;
import Interface.InEstudiante;
import Interface.InHistoria;
import Interface.InUsuario;
import Interface.InVictima;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeisson Lopez
 */
@WebServlet(name = "Servlet2", urlPatterns = {"/Servlet2"})
public class Servlet2 extends HttpServlet {

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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Date d = new Date(0);
        try {

            if (request.getParameter("BotonGuardar") != null&&request.getParameter("BotonGuardar").equals("GuardarV1")) {
                
//            InUsuario.RegistrarUsuario("hola", "hola", "hola", "hola", "hola", d, 1, 1110, "hola", "hola", "hola", 1110);
                inVictima.RegistrarVictima(request.getParameter("PrimerNombre"), request.getParameter("SegundoNombre"), request.getParameter("PrimerApellido"), request.getParameter("SegundoApellido"), request.getParameter("Correo"), d, 1, Integer.parseInt((request.getParameter("NumeroIdentificacion"))), (String)request.getParameter("Orientacion"), request.getParameter("Alias"), request.getParameter("Contrasena"), Integer.parseInt((request.getParameter("NumeroCelular"))), request.getParameter("Actividad"));
                response.sendRedirect("index.jsp");

            }
        } catch (Exception e) {
        }

        try {
            if (request.getParameter("BotonGuardar") != null&&request.getParameter("BotonGuardar").equals("GuardarD")) {
                InEstudiante.RegistrarEstudiante(request.getParameter("PrimerNombre"), request.getParameter("SegundoNombre"), request.getParameter("PrimerApellido"), request.getParameter("SegundoApellido"), request.getParameter("Correo"), d, 1, Integer.parseInt((request.getParameter("NumeroIdentificacion"))), request.getParameter("Orientacion"), request.getParameter("Alias"), request.getParameter("Contrasena"), Integer.parseInt((request.getParameter("NumeroCelular"))), Integer.parseInt(request.getParameter("UbicacionSemestral")),request.getParameter("Especialidad"));
                response.sendRedirect("docente.jsp");
            }
        } catch (Exception e) {
        }
        try {
            if (!request.getParameter("hola").equals(null)) {
               inHistoria.RegistrarHistoria(request.getParameter("hola"), d,Integer.parseInt(request.getParameter("idusuario")) );
                response.sendRedirect("victima.jsp");
            }
        } catch (Exception e) {
        }
        
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
