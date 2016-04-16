<%@page import="com.meteo.models.User,com.meteo.controllers.UserController" %>
<% 
User user = (User)session.getAttribute("user");

%>

 <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Management Subsystem
                    </a>
                </li>
                <li>
                    <a id="prof">
                        <img data-name=<%=user.getFname() + " " + user.getLname() %> class="profile" />
                        <span><%=user.getFname() + " " + user.getLname() %></span>
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
                    <a href="#">Reports</a>
                </li>
                <li>
                    <a href="#">Alerts(Pill)</a>
                </li>
                <li>
                    <a href="#">Locations</a>
                </li>
                
                <li>
                    <a href=javascript:openWin('../contacts.jsp',400,400)>Contact</a>
                </li>
                <li>
                    <a href="../logout.jsp">Log Out</a>
                </li>
<!--                <li>
                                            <a href="#menu-toggle" class="btn btn-default btn-block" id="menu-toggle">Toggle Menu</a>

                </li>-->
            </ul>
        </div>
