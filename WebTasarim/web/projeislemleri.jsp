<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Java.*"%>
<%@page import="java.sql.*"%>
<%@page import="DataBase.dataBase"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/projeislemleri.css"/>
    <title>JSP Page</title>
</head>
<body>
    <div id="dt">
        <h1>Proje Yönetimi PROJE İŞLEMLERİ</h1>
    </div>
<form action="personelislemleri.jsp">
    <button  class="proje"> PERSONEL İŞLEMLERİ </button>
</form>
    <button  class="proje"> PROJE İŞLEMLERİ</button>
    <form action="yoneticiislemleri.jsp">
        <button  class="proje">YÖNETİCİ İŞLEMLERİ</button>
    </form>
    <form action="index.jsp">
        <button class="proje">ANASAYFA/ÇIKIŞ</button>
    </form>
    

    <div id="sayfa" class="dt1">
        <h2>yeni kayıt</h2>
        <form action="">
            <label>KONUSU:</label>    <input type="text" name="konu" id="ad"/>
            <label>PROJE ADI:</label> <input type="text" name="projeadi" id="soyad"/>
            <label>PROJE SAHİBİ:</label> <input name="projesahibi" type="text" id="bit"/>
            <label>Başlangıç Tarihi:</label> <input name="baslangic" type="date" id="bas"/>
            <label>Bitiş Tarihi:</label> <input name="bitis" type="date" id="bit"/>
            
            <button id="ekle" name="ekle" type="submit" style="background-color: orange; border-radius: 15px;" >Yeni proje Ekleme</button>
        </form>
        
    </div>
      <table id="liste">
          <tr>
            <th>Konusu</th>
            <th>PROJE ADI</th> 
            <th>PROJE SAHİBİ</th> 
            <th>Başlangıç Tarihi</th>
            <th>Bitiş Tarihi</th>
            <th>sil</th>
            <th>güncelle</th>
          </tr>
          
    <%
        
                dataBase database =  new dataBase();
                ResultSet result = database.islemTablo();

                while (result.next()) {
                        out.print("<tr>");
                        out.print("<td>" + result.getString("konu")+"</td>" );
                        out.print("<td>" + result.getString("projeadi")+"</td>");
                        out.print("<td>" + result.getString("projesahibi")+"</td>");
                        out.print("<td>" + result.getString("baslangictarih")+"</td>");
                        out.print("<td>" + result.getString("bitistarih")+"</td>");
                        %>
                         <td><a href="projeislemleri.jsp?id=<%= result.getString("id")%>"> Sil</a></td>
                         <td><a href="projeislemleri.jsp?edit=<%= result.getString("id")%>">güncelle</a></td>
                         <%out.print("<tr>");

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
    %>
    
      </table>
   
    <%
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
    %>
</body>
</html>
