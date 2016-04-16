package org.apache.jsp.Desktop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Desktop/modals/loginfrm.jsp");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <title>Kenya Meteorological Department - System Login</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../Assets/lib/bootstrap/css/bootstrap.min.css\" />\n");
      out.write("        <script src=\"../Assets/lib/jquery/jquery.js\"></script>\n");
      out.write("        <script src=\"../Assets/lib/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"jumbotron\">\n");
      out.write("            <h1>Kenya Meteorological Department</h1>\n");
      out.write("            <h2>Weather Data Collection And Reporting System</h2>\n");
      out.write("             <button type=\"button\" class=\"btn btn-primary btn-block btn-lg\" data-toggle=\"modal\" data-target=\"#loginModal\"><span class=\"glyphicon glyphicon-Login\"></span>System Login</button>\n");
      out.write("             <div class=\"alert alert-warning\" style=\"margin-top : 5%\">\n");
      out.write("                 <p class=\"text-warning lead\"><strong>Notice :</strong> You need to be an Employee of The Kenya Meteorological Department and a Registered User of the System in Order to Login</p>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <p style=\"text-align: center\">&copy Kenya Meteorological Department ");
      out.print( Calendar.getInstance().get(Calendar.YEAR) );
      out.write("</p>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("<div id=\"loginModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("  <div class=\"modal-dialog\">  \n");
      out.write("<div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("        <h4 class=\"modal-title\">System Login</h4>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("          <form class=\"form-horizontal\" role=\"form\">\n");
      out.write("              \n");
      out.write("              <div class=\"form-group\" style=\"margin: 2%;\">\n");
      out.write("                  <label class=\"control-label col-sm-1\" for=\"txtuname\">Username </label>\n");
      out.write("                  <input type=\"text\" id=\"txtuname\" class=\"form-control\" placeholder=\"Enter Username\" />\n");
      out.write("              </div>\n");
      out.write("              <div class=\"form-group\" style=\"margin: 2%;\">\n");
      out.write("                  <label class=\"control-label col-sm-1\" for=\"txtpasswd\">Password </label>\n");
      out.write("                  <input type=\"password\" id=\"txtpasswd\" class=\"form-control\" placeholder=\"Enter Password\" />\n");
      out.write("              </div>\n");
      out.write("               \n");
      out.write("          </form>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary btn-block btn-lg\" data-dismiss=\"modal\">Login</button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("  \n");
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
