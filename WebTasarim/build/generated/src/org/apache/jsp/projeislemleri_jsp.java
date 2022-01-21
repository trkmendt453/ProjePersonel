package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Java.*;
import java.sql.*;
import DataBase.dataBase;

public final class projeislemleri_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/projeislemleri.css\"/>\n");
      out.write("    <title>JSP Page</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"dt\">\n");
      out.write("        <h1>Proje Yönetimi PROJE İŞLEMLERİ</h1>\n");
      out.write("    </div>\n");
      out.write("<form action=\"personelislemleri.jsp\">\n");
      out.write("    <button  class=\"proje\"> PERSONEL İŞLEMLERİ </button>\n");
      out.write("</form>\n");
      out.write("    <button  class=\"proje\"> PROJE İŞLEMLERİ</button>\n");
      out.write("    <form action=\"yoneticiislemleri.jsp\">\n");
      out.write("        <button  class=\"proje\">YÖNETİCİ İŞLEMLERİ</button>\n");
      out.write("    </form>\n");
      out.write("    <form action=\"index.jsp\">\n");
      out.write("        <button class=\"proje\">ANASAYFA/ÇIKIŞ</button>\n");
      out.write("    </form>\n");
      out.write("    \n");
      out.write("\n");
      out.write("    <div id=\"sayfa\" class=\"dt1\">\n");
      out.write("        <h2>yeni kayıt</h2>\n");
      out.write("        <form action=\"\">\n");
      out.write("            <label>KONUSU:</label>    <input type=\"text\" name=\"konu\" id=\"ad\"/>\n");
      out.write("            <label>PROJE ADI:</label> <input type=\"text\" name=\"projeadi\" id=\"soyad\"/>\n");
      out.write("            <label>PROJE SAHİBİ:</label> <input name=\"projesahibi\" type=\"text\" id=\"bit\"/>\n");
      out.write("            <label>Başlangıç Tarihi:</label> <input name=\"baslangic\" type=\"date\" id=\"bas\"/>\n");
      out.write("            <label>Bitiş Tarihi:</label> <input name=\"bitis\" type=\"date\" id=\"bit\"/>\n");
      out.write("            \n");
      out.write("            <button id=\"ekle\" name=\"ekle\" type=\"submit\" style=\"background-color: orange; border-radius: 15px;\" >Yeni proje Ekleme</button>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("      <table id=\"liste\">\n");
      out.write("          <tr>\n");
      out.write("            <th>Konusu</th>\n");
      out.write("            <th>PROJE ADI</th> \n");
      out.write("            <th>PROJE SAHİBİ</th> \n");
      out.write("            <th>Başlangıç Tarihi</th>\n");
      out.write("            <th>Bitiş Tarihi</th>\n");
      out.write("            <th>sil</th>\n");
      out.write("            <th>güncelle</th>\n");
      out.write("          </tr>\n");
      out.write("          \n");
      out.write("    ");

        
                dataBase database =  new dataBase();
                ResultSet result = database.islemTablo();

                while (result.next()) {
                        out.print("<tr>");
                        out.print("<td>" + result.getString("konu")+"</td>" );
                        out.print("<td>" + result.getString("projeadi")+"</td>");
                        out.print("<td>" + result.getString("projesahibi")+"</td>");
                        out.print("<td>" + result.getString("baslangictarih")+"</td>");
                        out.print("<td>" + result.getString("bitistarih")+"</td>");
                        
      out.write("\n");
      out.write("                         <td><a href=\"projeislemleri.jsp?id=");
      out.print( result.getString("id"));
      out.write("\"> Sil</a></td>\n");
      out.write("                         <td><a href=\"projeislemleri.jsp?edit=");
      out.print( result.getString("id"));
      out.write("\">güncelle</a></td>\n");
      out.write("                         ");
out.print("<tr>");

                    }
                        HttpSession oturum = request.getSession(true);
                        String sil = request.getParameter("id");
                        String guncelle = request.getParameter("edit");
                        oturum.setAttribute("editt", guncelle);
                        if(sil != null){
                            database.islemkayitsil(Integer.valueOf(sil));
                            response.sendRedirect("projeislemleri.jsp");
                        }
                        if(guncelle != null){
                           response.sendRedirect("projeguncelle.jsp");
                        }
    
      out.write("\n");
      out.write("    \n");
      out.write("      </table>\n");
      out.write("   \n");
      out.write("    ");

        String konu = request.getParameter("konu");
        String projeadi = request.getParameter("projeadi");
        String baslangic = request.getParameter("baslangic");
        String bitis = request.getParameter("bitis");
        String projesahibi = request.getParameter("projesahibi");
            
        String ekle = request.getParameter("ekle");
        
        if(ekle != null){
                    islemler islem = new islemler(konu, projeadi, baslangic, bitis,projesahibi);
                    database.islemKaydet(islem);
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
