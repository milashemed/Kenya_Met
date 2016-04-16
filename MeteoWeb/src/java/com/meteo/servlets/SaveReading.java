/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.servlets;

import com.meteo.controllers.ReadingController;
import com.meteo.controllers.UserStationController;
import com.meteo.models.Reading;
import com.meteo.models.Station;
import com.meteo.models.User;
import com.meteo.utils.Utils;
import com.meteo.websocket.ClientEndPoint;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.DeploymentException;
import javax.websocket.MessageHandler;

/**
 *
 * @author SALIM
 */
@WebServlet(name = "SaveReading", urlPatterns = {"/SaveReading"})
public class SaveReading extends HttpServlet {

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
            out.println("<title>Servlet SaveReading</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveReading at " + request.getContextPath() + "</h1>");
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
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
         Map<String,String> responsemap = new HashMap<>();
        double temp = Double.parseDouble(request.getParameter("temp"));
        double rain = Double.parseDouble(request.getParameter("rain"));
        Double humidity = Double.parseDouble(request.getParameter("humidity"));
        Double evaporation = Double.parseDouble(request.getParameter("evaporation"));
        double speed = Double.parseDouble(request.getParameter("speed"));
        double pressure = Double.parseDouble(request.getParameter("pressure"));
        String direction = request.getParameter("direction");
        Reading reading = new Reading();
        reading.setTemperature(temp);
        reading.setRainfall(rain);
        reading.setHumidity(humidity);
        reading.setEvaporation(evaporation);
        reading.setWindSpeed(speed);
        reading.setWindDirection(direction);
        reading.setPressure(pressure);
        reading.setTime(new Date());
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("user");
        reading.setUser(user);
        UserStationController usc = new UserStationController();
        Station station = usc.getItemByUser(user);
        reading.setStation(station);
        ReadingController rc = new ReadingController();
        try {
        rc.persist(reading);
       
        responsemap.put("Status", "OK");
        responsemap.put("Temperature", reading.getTemperature()+"");
        responsemap.put("Rainfall", reading.getRainfall()+"");
        responsemap.put("Humidity", reading.getHumidity()+"");
        responsemap.put("Evaporation", reading.getEvaporation()+"");
        responsemap.put("Speed", reading.getWindSpeed()+"");
        responsemap.put("Direction", reading.getWindDirection());
        responsemap.put("Station",station.getLocation());
        responsemap.put("User", user.getUsername());
        responsemap.put("date", df.format(reading.getTime()));
        
        
        }
        catch(Exception ex){
        responsemap.put("Status", "Error");
        responsemap.put("Description", ex.getMessage());
        }
        finally {
        String resp = Utils.JSONify(responsemap);
        response.getWriter().print(resp);
             try {
                 final ClientEndPoint endpoint = new ClientEndPoint(new URI("ws://localhost:8080/MeteoWeb/endpoint"));
                 
                 endpoint.sendMessage(resp);
             } catch (RuntimeException ex) {
                 Logger.getLogger(SaveReading.class.getName()).log(Level.SEVERE, null, ex);
             } catch (DeploymentException ex) {
                 Logger.getLogger(SaveReading.class.getName()).log(Level.SEVERE, null, ex);
             } catch (URISyntaxException ex) {
                 Logger.getLogger(SaveReading.class.getName()).log(Level.SEVERE, null, ex);
             }

        }
        
        
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
