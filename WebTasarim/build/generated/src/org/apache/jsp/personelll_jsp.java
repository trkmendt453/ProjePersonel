package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBase.dataBase;
import java.sql.*;
import Java.*;

public final class personelll_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/personelll.css\"/>\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"dt\">\n");
      out.write("    <h1>PROJE PANELİ</h1>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("          <th>Konusu</th>\n");
      out.write("          <th>proje adı</th> \n");
      out.write("          <th>Proje Sahibi</th>    \n");
      out.write("          <th>Başlangıç Tarihi</th>\n");
      out.write("          <th>Bitiş Tarihi</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

        
                dataBase database =  new dataBase();
                ResultSet result = database.islemTablo();

                while (result.next()) {
                        out.print("<tr>");
                        out.print("<td>" + result.getString("konu")+"</td>" );
                        out.print("<td>" + result.getString("projeadi")+"</td>");
                        out.print("<td>" + result.getString("projesahibi")+"</td>");
                        out.print("<td>" + result.getString("baslangictarih")+"</td>");
                        out.print("<td>" + result.getString("bitistarih")+"</td>");
                        
                        out.print("<tr>");

                    }
    
      out.write("\n");
      out.write("    </table>\n");
      out.write("    <form action=\"index.jsp\">\n");
      out.write("        <button> ANASAYFA/ÇIKIŞ</button>\n");
      out.write("    </form>\n");
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
