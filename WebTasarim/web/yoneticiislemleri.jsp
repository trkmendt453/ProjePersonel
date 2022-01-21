<%-- 
    Document   : yoneticiislemleri
    Created on : 16.Oca.2022, 15:26:15
    Author     : TÜRKMEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataBase.dataBase"%>
<%@page import="Java.*"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="styles/yoneticiislemleri.css"/>
    <title>JSP Page</title>
</head>
<body>
      <div id="dt">
        <h1>Proje Yönetimi YÖNETİCİ İŞLEMLERİ</h1>
    </div>
<form action="personelislemleri.jsp">
     <button id="btn4" class="proje"> PERSONEL İŞLEMLERİ </button>
</form>
<form action="projeislemleri.jsp">
     <button id="btn3" class="proje"> PROJE İŞLEMLERİ</button>
</form>
    <button id="btn2" class="proje">YÖNETİCİ İŞLEMLERİ</button>
    <form action="index.jsp">
         <button class="proje" >ANASAYFA/ÇIKIŞ</button>
    </form>
   

    <div id="sayfa" class="dt1">
        <h2>yeni kayıt</h2>
        <form action="">
            <label>AD:</label>    <input type="text" name="ad" id="ad"/>
            <label>SOYAD:</label> <input type="text" name="soyad" id="soyad"/>
            <label>TC:</label> <input  type="text" name="tc" id="bas"/>
            <label>EMAİL:</label> <input name="email" type="email"/>
            <div class="tablo2">
            <label>KULLANICI ADI:</label> <input name="kullaniciadi" type="text"/>   
            <label>TELEFON NO:</label> <input name="telefonno" type="number"/>
            <label>ADRES:</label> <input name="adres" type="text"/>
            <label>ŞİFRE:</label> <input name="sifre" type="password" id="bit"/>
            </div>
            <button style="background-color: orange; border-radius: 15px; position: relative; left: 38%; top: -200px;" type="submit" name="ekle" id="ekle">Yeni Yönetici Ekleme</button> 
            
        </form>
        
    </div>
      <table id="liste">
          <tr>
            <th>AD</th>
            <th>SOYAD</th> 
            <th>TC</th>
            <th>EMAİL</th>
            <th>KULLANICI ADI: </th>
            <th>TELEFON NO</th>
            <th>ADRES</th>
            <th>ŞİFRE</th>
            <th>SİL</th>
            <th>Düzenle</th> 
          </tr>
          <%
        
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
                        
                        %>
                        <td><a href="yoneticiislemleri.jsp?id=<%= result.getString("id")%>">Sil</a></td>
                        <td><a href="yoneticiislemleri.jsp?edit=<%= result.getString("id")%>">güncelle</a></td>
                        <%
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
                                                   
    %>
    
      </table>
      
      <%
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
    %>
</body>
</html>
