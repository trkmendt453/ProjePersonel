package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Java.*;
import java.sql.*;
import DataBase.dataBase;

public final class personelislemleri_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/personelİslemleri.css\"/>\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"dt\">\n");
      out.write("        <h1>Proje Yönetimi PERSONEL İŞLEMLERİ</h1>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <button class=\"personel\">PERSONEL İŞLEMLERİ</button>\n");
      out.write("    <form action=\"projeislemleri.jsp\">\n");
      out.write("    <button  class=\"proje\"> PROJE İŞLEMLERİ </button>\n");
      out.write("    </form>\n");
      out.write("    <form action=\"yoneticiislemleri.jsp\">\n");
      out.write("        <button class=\"yonetici\">YÖNETİCİ İŞLEMLERİ</button>\n");
      out.write("    </form>\n");
      out.write("    <form action=\"index.jsp\">\n");
      out.write("        <button> ANASAYFA/ÇIKIŞ </button>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <div id=\"sayfa\" class=\"dt1\">\n");
      out.write("        <h3>yeni kayıt</h3>\n");
      out.write("        <form action=\"\">\n");
      out.write("            <label>Ad:</label>    <input type=\"text\" name=\"ad\" id=\"ad\"/>\n");
      out.write("            <label>Soyad:</label> <input type=\"text\"  name=\"soyad\" id=\"soyad\"/>\n");
      out.write("            <label>tc:</label> <input type=\"text\" name=\"tc\" id=\"tc\"/>\n");
      out.write("            <label>kullanici adı:</label> <input type=\"text\" name=\"kullaniciadi\" id=\"kullaniciadi\"/>\n");
      out.write("            <label>şifre:</label> <input type=\"text\" name=\"sifre\" id=\"sifre\"/>\n");
      out.write("            <label>adres:</label> <input type=\"text\" name=\"adres\" id=\"adres\"/>\n");
      out.write("            <label>telefon no:</label> <input type=\"text\" name=\"telefonno\" id=\"telefonno\"/>\n");
      out.write("            <label>Email:</label> <input type=\"email\" name=\"email\" id=\"email\"/>\n");
      out.write("            <button type=\"submit\" name=\"ekle\">Yeni Personel Ekleme</button>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("      <table id=\"liste\">\n");
      out.write("          <tr>\n");
      out.write("            <th>Ad</th>\n");
      out.write("            <th>Soyad</th> \n");
      out.write("            <th>tc</th>\n");
      out.write("            <th>kullanıcı adı</th>\n");
      out.write("            <th>şifre</th>\n");
      out.write("            <th>adres</th>\n");
      out.write("            <th>telefonno</th>\n");
      out.write("            <th>email</th>\n");
      out.write("            <th>sil</th>\n");
      out.write("            <th>güncelle</th>\n");
      out.write("          </tr>\n");
      out.write("     \n");
      out.write("    \n");
      out.write("    ");

        
                dataBase database =  new dataBase();
                ResultSet result = database.personelTablo();

                while (result.next()) {
                        out.print("<tr>");
                        out.print("<td>" + result.getString("ad")+"</td>" );
                        out.print("<td>" + result.getString("soyad")+"</td>");
                        out.print("<td>" + result.getString("tc")+"</td>");
                        out.print("<td>" + result.getString("kullaniciadi")+"</td>");
                        out.print("<td>" + result.getString("sifre")+"</td>");
                        out.print("<td>" + result.getString("adres")+"</td>");
                        out.print("<td>" + result.getString("telefonno")+"</td>");
                        out.print("<td>" + result.getString("email")+"</td>");
                        
      out.write("\n");
      out.write("                        <td><a href=\"personelislemleri.jsp?id=");
      out.print( result.getString("id"));
      out.write("\"> Sil</a></td>\n");
      out.write("                        <td><a href=\"personelislemleri.jsp?edit=");
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
                            response.sendRedirect("personelislemleri.jsp");
                        }

                        if(guncelle != null){
                           response.sendRedirect("personelguncelle.jsp");
                        }
    
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("     </table>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");

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
                    personel calisan = new personel(ad, soyad, tc, kullaniciadi, sifre, adres, telefonno, email);
                    dt.PersonelKaydet(calisan);
                    response.sendRedirect("personelislemleri.jsp");
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
