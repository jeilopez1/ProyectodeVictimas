package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Nutricion</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <br>\n");
      out.write("        <blockquote class=\"blockquote text-center\">\n");
      out.write("            <p class=\"mb-0\">Registro del Proceso Victima</p>\n");
      out.write("        </blockquote><br>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("            <form name=\"Form1\" action=\"Servlet1\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col\">\n");
      out.write("                            <input type=\"text\" name=\"nombreEstudiante\"  class=\"form-control\" placeholder=\"Nombre del Estudiante\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col\">\n");
      out.write("                            <input type=\"text\" name=\"nombreVictima\"  class=\"form-control\" placeholder=\"Nombre de la Victima\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col\">\n");
      out.write("                            <input type=\"text\" name=\"historia\"  class=\"form-control\" placeholder=\"Historia\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col\">\n");
      out.write("                            <input type=\"text\" name=\"proceso\"  class=\"form-control\" placeholder=\"Proceso\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                     \n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary float-right\" value=\"Guardar\" name=\"BotonGuardar\">Registrar</button>\n");
      out.write("            </form>\n");
      out.write("            <br>\n");
      out.write("            <form name=\"Form1\" action=\"Servlet1\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                        <div class=\"col\">\n");
      out.write("                            <input type=\"text\" name=\"TextoConsultar\"  class=\"form-control\" placeholder=\"TextoConsultar\">\n");
      out.write("                        </div>\n");
      out.write("                 \n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary float-right\" value=\"Consultar\" name=\"Consultar\">Consultar</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("            </form>\n");
      out.write("           \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
