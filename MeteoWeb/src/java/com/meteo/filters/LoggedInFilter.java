/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.filters;

import com.meteo.models.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SALIM
 */

public class LoggedInFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
HttpServletRequest req = (HttpServletRequest) request; 
        HttpServletResponse resp = (HttpServletResponse)response;
        HttpSession session = req.getSession(false);
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
resp.setDateHeader("Expires", 0); // Proxies.
        boolean loggedin = session != null && session.getAttribute("user") != null;
        boolean loginrequest = req.getRequestURI().equals(req.getContextPath() + "/Desktop/index.jsp");
        if (!loggedin){
            System.out.println("Not Logged In");
        chain.doFilter(request, response);
        
        }
        else  {
            System.out.println("Logged In");
        User user = (User)session.getAttribute("user");
        if ("Management".equals(user.getType())){
        resp.sendRedirect(req.getContextPath() + "/Desktop/Management/landing.jsp");
        }
        else {
                resp.sendRedirect(req.getContextPath() + "/Desktop/Volunteer/landing.jsp");

        }
        }    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
