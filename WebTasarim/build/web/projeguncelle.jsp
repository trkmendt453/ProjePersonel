<%-- 
    Document   : projeguncelle
    Created on : 18.Oca.2022, 01:15:31
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
        <link rel="stylesheet" type="text/css" href="styles/projeguncelle.css"/>
    <title>JSP Page</title>
</head>
<body>
    <h1>PROJE GÜNCELLE</h1>
<div class="dt">
    <form action="">
       <label>Konu:</label>  <input type="text" placeholder="konu" name="konu"/>
         <label>Proje Adı:</label><input type="text" placeholder="projeadi" name="projeadi"/>
        <label>Proje Sahibi:</label> <input type="text" placeholder="projesahibi" name="projesahibi"/>
        <div class="tablo2">
        <label>Başlangıç Tarih:</label> <input type="date" placeholder="baslangictarih" name="baslangictarih"/>
        <label>Bitiş Tarih:</label> <input type="date" placeholder="bitistarih" name="bitistarih"/>
        </div>
    
        <button style="background-color: orange; border-radius: 15px; position: relative; left: 45%; top: -70px;" name="guncelle" type="submit">güncelle</button>
        <button style="background-color: orange; border-radius: 15px; position: relative; left: 45%; top: -70px;" name="iptal" type="submit">iptal</button>
    </form>
</div>
    
    <%
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
    %>
</body>
</html>
