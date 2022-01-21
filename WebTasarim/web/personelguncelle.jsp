<%-- 
    Document   : personelguncelle
    Created on : 18.Oca.2022, 01:58:25
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
         <link rel="stylesheet" type="text/css" href="styles/personelguncelle.css"/>
    <title>JSP Page</title>
</head>
<body>
    <h1>PERSONEL GÜNCELLE</h1>
<div class="dt">
    <form action="">
        <label>Ad:</label>  <input type="text" placeholder="ad" name="ad"/>
       <label>Soyad:</label>   <input type="text" placeholder="soyad" name="soyad"/>
        <label>TC:</label>  <input type="text" placeholder="tc" name="tc"/>
       <label>Email:</label>   <input type="text" placeholder="email" name="email"/>
       <div class="tablo2">
        <label>Kullanıcı Adı:</label>  <input type="text" placeholder="kullanıcı adı" name="kullaniciadi"/>
        <label>Telefon No:</label>  <input type="text" placeholder="telefon numarası" name="telefonno"/>
       <label>Adres:</label>   <input type="text" placeholder="adres" name="adres"/>
        <label>Şifre:</label>  <input type="text" placeholder="şifre" name="sifre"/>
        </div>  
        <button style="background-color: orange; border-radius: 15px; position: relative; left: 40%; top: -230px;" name="guncelle" type="submit">güncelle</button>
        <button style="background-color: orange; border-radius: 15px; position: relative; left: 40%; top: -230px;" name="iptal" type="submit">iptal</button>
    </form>
</div>
   
    
    <%
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
    %>
    
</body>
</html>
