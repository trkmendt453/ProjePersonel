package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBase.dataBase;
import Java.*;
import java.sql.*;

public final class personelguncelle_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/personelguncelle.css\"/>\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>PERSONEL GÜNCELLE</h1>\n");
      out.write("<div class=\"dt\">\n");
      out.write("    <form action=\"\">\n");
      out.write("        <label>Ad:</label>  <input type=\"text\" placeholder=\"isim\" name=\"ad\"/>\n");
      out.write("       <label>Ad:</label>   <input type=\"text\" placeholder=\"soyad\" name=\"soyad\"/>\n");
      out.write("        <label>Ad:</label>  <input type=\"text\" placeholder=\"tc\" name=\"tc\"/>\n");
      out.write("       <label>Ad:</label>   <input type=\"text\" placeholder=\"email\" name=\"email\"/>\n");
      out.write("        <label>Ad:</label>  <input type=\"text\" placeholder=\"kullanıcı adı\" name=\"kullaniciadi\"/>\n");
      out.write("        <label>Ad:</label>  <input type=\"text\" placeholder=\"telefon numarası\" name=\"telefonno\"/>\n");
      out.write("       <label>Ad:</label>   <input type=\"text\" placeholder=\"adres\" name=\"adres\"/>\n");
      out.write("        <label>Ad:</label>  <input type=\"text\" placeholder=\"şifre\" name=\"sifre\"/>\n");
      out.write("        <button name=\"guncelle\" type=\"submit\">güncelle</button>\n");
      out.write("        <button name=\"iptal\" type=\"submit\">iptal</button>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("   \n");
      out.write("    \n");
      out.write("    ");

        dataBase database = new dataBase();
        String ad =request.getParameter("ad");
        String soyad =request.getParameter("soyad");
        String tc =request.getParameter("tc");
        String email =request.getParameter("email");
        String kullaniciadi =request.getParameter("kullaniciadi");
        String telefonno =request.getParameter("telefonno");
        String adres =request.getParameter("adres");
        String sifre =request.getParameter("sifre");
        String iptal =request.getParameter("iptal");
        
        String guncelle = request.getParameter("guncelle");
        HttpSession oturum = request.getSession();
        
        String edit;
        if (guncelle != null) {
            edit=oturum.getAttribute("editt").toString();
                if (!ad.equals("")&&!soyad.equals("")&&!tc.equals("")&&!email.equals("")&&!kullaniciadi.equals("")&&
                    !telefonno.equals("")&&!adres.equals("")&&!sifre.equals("") && edit != null) {
                    database.personelGuncelle(Integer.valueOf(edit), ad, soyad, tc, adres, email, telefonno, kullaniciadi, sifre);
                    response.sendRedirect("personelislemleri.jsp");
                    
                }
            }
        else if(iptal != null){
            response.sendRedirect("personelislemleri.jsp");
        }
    
      out.write("\n");
      out.write("    \n");
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
