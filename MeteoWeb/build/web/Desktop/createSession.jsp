<%@page import="com.meteo.models.User,com.meteo.controllers.UserController" %>
<%
    String username = request.getParameter("username");
    UserController usc = new UserController();
    User user = usc.getByUsername(username);
    session.setAttribute("user", user);
  %>