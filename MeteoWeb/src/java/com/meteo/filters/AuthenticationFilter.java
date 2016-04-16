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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SALIM
 */
public class AuthenticationFilter implements Filter {
User user;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request; 
        HttpServletResponse resp = (HttpServletResponse)response;
        HttpSession session = req.getSession(false);
        boolean loggedin = session != null && session.getAttribute("user") != null;
        boolean loginrequest = req.getRequestURI().equals(req.getContextPath() + "/Desktop/index.jsp");
        if (loggedin || loginrequest){
        chain.doFilter(request, response);
        }
        else  {
        resp.sendRedirect(req.getContextPath() + "/Desktop/index.jsp");
        }
        
       
        
    }

    @Override
    public void destroy() {
    }
    
}
