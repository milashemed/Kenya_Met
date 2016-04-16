/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.servlets;

import com.google.gson.Gson;
import com.meteo.controllers.UserController;
import com.meteo.models.User;
import com.meteo.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SALIM
 */
@WebServlet(name = "Authenticate", urlPatterns = {"/Authenticate"})
public class Authenticate extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Authenticate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Authenticate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
      PrintWriter out = response.getWriter();
        String username = request.getParameter("Username");
       String password = request.getParameter("Password");
       UserController usc = new UserController();
       Map<String,String> responseMap = new HashMap<>();
       if (usc.userEmpty(username)){
       responseMap.put("results", "Empty");
       responseMap.put("username", username);
       
       }
       else {
           User user = usc.getByUsername(username);
       if (usc.authenticate(user, password)){
       responseMap.put("results", "Success");
       responseMap.put("username", user.getUsername());
       responseMap.put("status", ""+user.getStatus());
       responseMap.put("passChange", ""+user.getPasschange());
       responseMap.put("Fullname", user.getFname() + " " + user.getLname());
       responseMap.put("Email", ""+user.getEmail());
       responseMap.put("phone", ""+user.getPhone());
       responseMap.put("type", ""+user.getType());
       responseMap.put("id", ""+user.getId());
       }
       else {
       responseMap.put("results", "Fail");
       responseMap.put("username", username);
       }
       }
    out.println(Utils.JSONify(responseMap));
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
     PrintWriter out = response.getWriter();
        String username = request.getParameter("Username");
       String password = request.getParameter("Password");
       UserController usc = new UserController();
       Map<String,String> responseMap = new HashMap<>();
       if (usc.userEmpty(username)){
       responseMap.put("results", "Empty");
       responseMap.put("username", username);
       
       }
       else {
           User user = usc.getByUsername(username);
       if (usc.authenticate(user, password)){
       responseMap.put("results", "Success");
       responseMap.put("username", user.getUsername());
       responseMap.put("status", ""+user.getStatus());
       responseMap.put("passChange", ""+user.getPasschange());
       responseMap.put("Fullname", user.getFname() + " " + user.getLname());
       responseMap.put("Email", ""+user.getEmail());
       responseMap.put("phone", ""+user.getPhone());
       responseMap.put("type", ""+user.getType());
       responseMap.put("id", ""+user.getId());
       }
       else {
       responseMap.put("results", "Fail");
       responseMap.put("username", username);
       }
       }
     
         out.println(Utils.JSONify(responseMap));

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
