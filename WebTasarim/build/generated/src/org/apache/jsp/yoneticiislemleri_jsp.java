package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataBase.dataBase;
import Java.*;
import java.sql.*;

public final class yoneticiislemleri_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/yoneticiislemleri.css\"/>\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("      <div id=\"dt\">\n");
      out.write("        <h1>Proje Yönetimi YÖNETİCİ İŞLEMLERİ</h1>\n");
      out.write("    </div>\n");
      out.write("<form action=\"personelislemleri.jsp\">\n");
      out.write("     <button id=\"btn4\" class=\"personel\"> PERSONEL İŞLEMLERİ </button>\n");
      out.write("</form>\n");
      out.write("<form action=\"projeislemleri.jsp\">\n");
      out.write("     <button id=\"btn3\" class=\"proje\"> PROJE İŞLEMLERİ</button>\n");
      out.write("</form>\n");
      out.write("    <button id=\"btn2\" class=\"yonetici\">YÖNETİCİ İŞLEMLERİ</button>\n");
      out.write("    <form action=\"index.jsp\">\n");
      out.write("         <button>ANASAYFA/ÇIKIŞ</button>\n");
      out.write("    </form>\n");
      out.write("   \n");
      out.write("\n");
      out.write("    <div id=\"sayfa\" class=\"dt1\">\n");
      out.write("        <h2>yeni kayıt</h2>\n");
      out.write("        <form action=\"\">\n");
      out.write("            <label>AD:</label>    <input type=\"text\" name=\"ad\" id=\"ad\"/>\n");
      out.write("            <label>SOYAD:</label> <input type=\"text\" name=\"soyad\" id=\"soyad\"/>\n");
      out.write("            <label>TC:</label> <input  type=\"text\" name=\"tc\" id=\"bas\"/>\n");
      out.write("            <label>EMAİL:</label> <input name=\"email\" type=\"email\"/>\n");
      out.write("            <div class=\"tablo2\">\n");
      out.write("            <label>KULLANICI ADI:</label> <input name=\"kullaniciadi\" type=\"text\"/>   \n");
      out.write("            <label>TELEFON NO:</label> <input name=\"telefonno\" type=\"number\"/>\n");
      out.write("            <label>ADRES:</label> <input name=\"adres\" type=\"text\"/>\n");
      out.write("            <label>ŞİFRE:</label> <input name=\"sifre\" type=\"password\" id=\"bit\"/>\n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\" name=\"ekle\" id=\"ekle\">Yeni Yönetici Ekleme</button> \n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("      <table id=\"liste\">\n");
      out.write("          <tr>\n");
      out.write("            <th>AD</th>\n");
      out.write("            <th>SOYAD</th> \n");
      out.write("            <th>TC</th>\n");
      out.write("            <th>EMAİL</th>\n");
      out.write("            <th>KULLANICI ADI: </th>\n");
      out.write("            <th>TELEFON NO</th>\n");
      out.write("            <th>ADRES</th>\n");
      out.write("            <th>ŞİFRE</th>\n");
      out.write("            <th>SİL</th>\n");
      out.write("            <th>Düzenle</th> \n");
      out.write("          </tr>\n");
      out.write("          ");

        
                dataBase database =  new dataBase();
                ResultSet result = database.yoneticiTablo();

                while (result.next()) {
                        out.print("<tr>");
                        out.print("<td>" + result.getString("ad")+"</td>" );
                        out.print("<td>" + result.getString("soyad")+"</td>");
                        out.print("<td>" + result.getString("tc")+"</td>");
                        out.print("<td>" + result.getString("email")+"</td>");
                        out.print("<td>" + result.getString("kullaniciadi")+"</td>");
                        out.print("<td>" + result.getString("telefonno")+"</td>");
                        out.print("<td>" + result.getString("adres")+"</td>");
                        out.print("<td>" + result.getString("sifre")+"</td>");
                        
                        
      out.write("\n");
      out.write("                        <td><a href=\"yoneticiislemleri.jsp?id=");
      out.print( result.getString("id"));
      out.write("\">Sil</a></td>\n");
      out.write("                        <td><a href=\"yoneticiislemleri.jsp?edit=");
      out.print( result.getString("id"));
      out.write("\">güncelle</a></td>\n");
      out.write("                        ");

                        out.print("<tr>");
                    }
                           HttpSession oturum = request.getSession(true);
                        String sil = request.getParameter("id");
                        String guncelle = request.getParameter("edit");
                        oturum.setAttribute("editt", guncelle);
                        if(sil != null){
                            database.yoneticikayitsil(Integer.valueOf(sil));
                            response.sendRedirect("yoneticiislemleri.jsp");
                        }

                        if(guncelle != null){
                           response.sendRedirect("yoneticiguncelle.jsp");
                        }
                                                   
    
      out.write("\n");
      out.write("    \n");
      out.write("      </table>\n");
      out.write("      \n");
      out.write("      ");

        dataBase dt = new dataBase();
        String ad = request.getParameter("ad");
        String soyad = request.getParameter("soyad");
        String tc = request.getParameter("tc");
        String kullaniciadi = request.getParameter("kullaniciadi");
        String sifre = request.getParameter("sifre");
        String adres = request.getParameter("adres");
        String telefonno = request.getParameter("telefonno");
        String email = request.getParameter("email");
        String ekle = request.getParameter("ekle");
        
        if(ekle != null){    
                    yonetici yonetici = new yonetici(ad, soyad, kullaniciadi, tc, telefonno, adres, sifre, email);
                    dt.yoneticikaydet(yonetici);
                    response.sendRedirect("yoneticiislemleri.jsp");
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
