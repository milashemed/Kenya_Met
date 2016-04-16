 <% 
                           User user = (User)session.getAttribute("user");
                       
                       %>
<%@page import="com.meteo.models.User,com.meteo.controllers.UserController" %>
<%@page import="com.meteo.controllers.UserStationController" %>
<%@page import="com.meteo.models.Station" %>

 <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Data Entry Subsystem
                    </a>
                </li>
                <li>
                    <a id="prof">
                      
                        <img data-name=<%=user.getFname() + " " + user.getLname() %> class="profile" />
                        <span><%=user.getFname() + " " + user.getLname() %></span>
                        <%
                        UserStationController usc = new UserStationController(); 
                        Station station = usc.getItemByUser(user);
                        %>
                        <h4>Station : <%=station.getLocation() %> </h4>
                    </a>
                </li>
                <li>
                    <a id="prof">
                        <%
                            java.util.Date date = new java.util.Date(); 
                            out.print(date.toString());
                        %>
                    </a>
                </li>
                <li>
                    <a href="#">Dashboard</a>
                </li>
                
                <li>
                    <a href="#" data-toggle="modal" data-target="#readingModal">New Record</a>
                </li>
                <li>
                    <a href="#">My Location</a>
                </li>
                
                <li>
                    <a href="#">Contact</a>
                </li>
                <li>
                    <a href="../logout.jsp">Log Out</a>
                </li>
<!--                <li>
                                            <a href="#menu-toggle" class="btn btn-default btn-block" id="menu-toggle">Toggle Menu</a>

                </li>-->
            </ul>
        </div>