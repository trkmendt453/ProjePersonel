<%-- 
    Document   : personelislemleri
    Created on : 13.Oca.2022, 23:15:39
    Author     : TÜRKMEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Java.*"%>
<%@page import="java.sql.*"%>
<%@page import="DataBase.dataBase"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/personelİslemleri.css"/>
    <title>JSP Page</title>
</head>
<body><%
        HttpSession oturumm = request.getSession(true);
        String add = oturumm.getAttribute("ad").toString();
    %>
    <div id="dt">
        <h1>Proje Yönetimi PERSONEL İŞLEMLERİ           Hoşgeldiniz <%=add%> </h1>
    </div>

    <button class="proje">PERSONEL İŞLEMLERİ</button>
    <form action="projeislemleri.jsp">
    <button  class="proje"> PROJE İŞLEMLERİ </button>
    </form>
    <form action="yoneticiislemleri.jsp">
        <button class="proje">YÖNETİCİ İŞLEMLERİ</button>
    </form>
    <form action="index.jsp">
        <button class="proje"> ANASAYFA/ÇIKIŞ </button>
    </form>

    <div id="sayfa" class="dt1">
        <h3>yeni kayıt</h3>
        <form action="">
            <label>Ad:</label>    <input type="text" name="ad" id="ad"/> <br>
            <label>Soyad:</label> <input type="text"  name="soyad" id="soyad"/><br>
            <label>tc:</label> <input type="text" name="tc" id="tc"/><br>
            <label>kullanici adı:</label> <input type="text" name="kullaniciadi" id="kullaniciadi"/><br>
            <div class="tablo2">
            <label>şifre:</label> <input type="text" name="sifre" id="sifre"/><br>
            <label>adres:</label> <input type="text" name="adres" id="adres"/><br>
            <label>telefon no:</label> <input type="text" name="telefonno" id="telefonno"/><br>
            <label>Email:</label> <input type="email" name="email" id="email"/><br>
            </div>
            <button style="background-color: orange; border-radius: 15px; position: relative; left: 40%; top: -200px;" type="submit" name="ekle">Yeni Personel Ekleme</button>  
        </form>
        
    </div>
      <table id="liste">
          <tr>
            <th>Ad</th>
            <th>Soyad</th> 
            <th>tc</th>
            <th>kullanıcı adı</th>
            <th>şifre</th>
            <th>adres</th>
            <th>telefonno</th>
            <th>email</th>
            <th>sil</th>
            <th>güncelle</th>
          </tr>
     
    
    <%
        
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
                        %>
                        <td><a href="personelislemleri.jsp?id=<%= result.getString("id")%>"> Sil</a></td>
                        <td><a href="personelislemleri.jsp?edit=<%= result.getString("id")%>">güncelle</a></td>
                        <%
                        out.print("<tr>");
                    }  
                        HttpSession oturum = request.getSession(true);
                        String sil = request.getParameter("id");
                        String guncelle = request.getParameter("edit");
                        oturum.setAttribute("editt", guncelle);
                        if(sil != null){
                            database.personelkayitsil(Integer.valueOf(sil));
                            response.sendRedirect("personelislemleri.jsp");
                        }

                        if(guncelle != null){
                           response.sendRedirect("personelguncelle.jsp");
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
                    personel calisan = new personel(ad, soyad, tc, kullaniciadi, sifre, adres, telefonno, email);
                    dt.PersonelKaydet(calisan);
                    response.sendRedirect("personelislemleri.jsp");
                }
    %>
</body>
</html>
