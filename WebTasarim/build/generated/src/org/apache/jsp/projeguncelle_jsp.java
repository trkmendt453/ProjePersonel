package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBase.dataBase;
import Java.*;
import java.sql.*;

public final class projeguncelle_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/projeguncelle.css\"/>\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>PROJE GÜNCELLE</h1>\n");
      out.write("<div class=\"dt\">\n");
      out.write("    <form action=\"\">\n");
      out.write("        <input type=\"text\" placeholder=\"konu\" name=\"konu\"/>\n");
      out.write("        <input type=\"text\" placeholder=\"projeadi\" name=\"projeadi\"/>\n");
      out.write("        <input type=\"text\" placeholder=\"projesahibi\" name=\"projesahibi\"/>\n");
      out.write("        <input type=\"date\" placeholder=\"baslangictarih\" name=\"baslangictarih\"/>\n");
      out.write("        <input type=\"date\" placeholder=\"bitistarih\" name=\"bitistarih\"/>\n");
      out.write("        <button name=\"guncelle\" type=\"submit\">güncelle</button>\n");
      out.write("        <button name=\"iptal\" type=\"submit\">iptal</button>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("    ");

        dataBase database = new dataBase();
        String konu =request.getParameter("konu");
        String projeadi =request.getParameter("projeadi");
        String projesahibi =request.getParameter("projesahibi");
        String baslangictarih =request.getParameter("baslangictarih");
        String bitistarih =request.getParameter("bitistarih");
        String guncelle = request.getParameter("guncelle");
        String iptal = request.getParameter("iptal");
        
        HttpSession oturum = request.getSession();
        String edit;
        if (guncelle != null) {
            edit=oturum.getAttribute("editt").toString();
                if (!konu.equals("")&&!projeadi.equals("")&&!projesahibi.equals("")&&!baslangictarih.equals("")&&!bitistarih.equals("")&& edit != null) {
                    database.projeGuncelle(Integer.valueOf(edit), konu, projeadi, baslangictarih, bitistarih, projesahibi);
                    response.sendRedirect("projeislemleri.jsp");
                }
            }
        else if (iptal != null) {
                response.sendRedirect("projeislemleri.jsp");
            }
    
      out.write("\n");
      out.write("</body>\n");
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
