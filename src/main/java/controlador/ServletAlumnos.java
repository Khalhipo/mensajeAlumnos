/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Utilidades;

/**
 *
 * @author Bueno
 */
public class ServletAlumnos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private ArrayList<Alumno> alumnos;
    private ArrayList<String> grupos;
    private String rutaFicheros;

    public void init(ServletConfig config) throws ServletException {
        grupos = new ArrayList<String>();
        grupos.add("2daw_a");
        grupos.add("2daw_b");

        rutaFicheros = config.getServletContext().getRealPath("").concat(File.separator).concat("ficheros");
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

        String grupoSel = (String) request.getParameter("grupo")!=null?
                (String) request.getParameter("grupo")
                :"2daw_a";
        alumnos = Utilidades.getAlumnos(rutaFicheros.concat(File.separator).concat(grupoSel).concat(".txt"));
        
        request.setAttribute("alumnos", alumnos);
        request.setAttribute("grupos", grupos);
        request.setAttribute("grupoSel", grupoSel);
        request.getRequestDispatcher("alumnos.jsp").forward(request, response);
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
        
        String grupo = (String) request.getParameter("grupoSeleccionado");
        String[] checkboxes = request.getParameterValues("checkbox");
        ArrayList<Alumno> alumnosSeleccionados = new ArrayList<Alumno>();
        alumnos = Utilidades.getAlumnos(rutaFicheros.concat(File.separator).concat(grupo).concat(".txt"));
                
        
        for(Alumno alumno: alumnos) {
            for(String checkbox: checkboxes){
                if(alumno.getId() == Integer.parseInt(checkbox)){
                    alumnosSeleccionados.add(alumno);
                }
            }
        }
        
        request.setAttribute("grupoSel", grupo);
        request.setAttribute("alumnosSel", alumnosSeleccionados);
        request.getRequestDispatcher("alumnos2.jsp").forward(request, response);
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
