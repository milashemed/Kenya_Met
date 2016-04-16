package org.apache.jsp.Desktop.Management;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.meteo.models.User;
import com.meteo.controllers.UserController;

public final class landing_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Desktop/Management/../includes/left_side_bar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write(" \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../../Assets/lib/bootstrap/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../../Assets/Style/sidebar.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"../../Assets/lib/mdl/material.min.css\">\n");
      out.write("<script src=\"../../Assets/lib/mdl/material.min.js\"></script>\n");
      out.write("        <script src=\"../../Assets/lib/jquery/jquery.js\"></script>\n");
      out.write("        <script src=\"../../Assets/lib/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"../../Assets/lib/bootbox.min.js\"></script>\n");
      out.write("        <script src=\"../../js/initial.min.js\"></script>\n");
      out.write("        <script src=\"../../js/websockets/websocket.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style/main.css\" />\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $('.profile').initial({height:100,width:100})\n");
      out.write("               setInterval(function(){\n");
      out.write("                   $('#dte').html(\"<code>\" + new Date() + \"</code>\")\n");
      out.write("               },1000)\n");
      out.write("            })\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        <title>Kenya Meteorological Department Management Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            ");
      out.write('\n');
 
User user = (User)session.getAttribute("user");


      out.write("\n");
      out.write("\n");
      out.write(" <div id=\"sidebar-wrapper\">\n");
      out.write("            <ul class=\"sidebar-nav\">\n");
      out.write("                <li class=\"sidebar-brand\">\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                        Management Subsystem\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a id=\"prof\">\n");
      out.write("                        <img data-name=");
      out.print(user.getFname() + " " + user.getLname() );
      out.write(" class=\"profile\" />\n");
      out.write("                        <span>");
      out.print(user.getFname() + " " + user.getLname() );
      out.write("</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a id=\"prof\">\n");
      out.write("                        ");

                            java.util.Date date = new java.util.Date(); 
                            out.print(date.toString());
                        
      out.write("\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">Dashboard</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">Reports</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">Alerts(Pill)</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">Locations</a>\n");
      out.write("                </li>\n");
      out.write("                \n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">Contact</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">Log Out</a>\n");
      out.write("                </li>\n");
      out.write("<!--                <li>\n");
      out.write("                                            <a href=\"#menu-toggle\" class=\"btn btn-default btn-block\" id=\"menu-toggle\">Toggle Menu</a>\n");
      out.write("\n");
      out.write("                </li>-->\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("            <div id=\"page-content-wrapper\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                      \n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <h1>Dashboard</h1>\n");
      out.write("                        <h5>Average Weather Conditions As Of <span id=\"dte\"></span></h5>\n");
      out.write("                        <ul class=\"nav nav-tabs\">\n");
      out.write("                            <li class=\"active\"><a data-target=\"#summary\" data-toggle=\"tab\">Summary View</a></li>\n");
      out.write("                            <li><a data-target=\"#graphical\" data-toggle=\"tab\">Graphical View</a></li>\n");
      out.write("                            <li><a data-target=\"#log\" data-toggle=\"tab\">Log View</a></li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                        <div class=\"tab-content\">\n");
      out.write("                            <div class=\"tab-pane active\" id=\"summary\">\n");
      out.write("                                <div class=\"container\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3 col-md-2 col-lg-4\"><img src=\"Images/temperature.png\" /></div>\n");
      out.write("                                        <div class=\"col-sm-9 col-md-10 col-lg-8 reading\">0&degC</div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3 col-md-2 col-lg-4\"><img src=\"Images/night_rain.png\" /></div>\n");
      out.write("                                        <div class=\"col-sm-9 col-md-10 col-lg-8 reading\">0mm</div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3 col-md-2 col-lg-4\"><img src=\"Images/pressure.png\" /></div>\n");
      out.write("                                        <div class=\"col-sm-9 col-md-10 col-lg-8 reading\">0mb</div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3 col-md-2 col-lg-4\"><img src=\"Images/evaporation.png\" /></div>\n");
      out.write("                                        <div class=\"col-sm-9 col-md-10 col-lg-8 reading\">0%</div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3 col-md-2 col-lg-4\"><img src=\"Images/wind_turbine.png\" /></div>\n");
      out.write("                                        <div class=\"col-sm-9 col-md-10 col-lg-8 reading\">0%</div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-sm-3 col-md-2 col-lg-4\"><img src=\"Images/wind_flag_storm.png\" /></div>\n");
      out.write("                                        <div class=\"col-sm-9 col-md-10 col-lg-8 reading\">0%</div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("        <div class=\"tab-pane\" id=\"graphical\">Graphical</div>\n");
      out.write("<div class=\"tab-pane\" id=\"log\">Log View</div>\n");
      out.write("    </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        </body>\n");
      out.write("</html>\n");
      out.write("<script>\n");
      out.write("    $(\"#menu-toggle\").click(function(e) {\n");
      out.write("        e.preventDefault();\n");
      out.write("        $(\"#wrapper\").toggleClass(\"toggled\");\n");
      out.write("    });\n");
      out.write("    </script>\n");
      out.write("    ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
