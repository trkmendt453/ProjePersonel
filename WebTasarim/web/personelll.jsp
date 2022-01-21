<%-- 
    Document   : personelll
    Created on : 16.Oca.2022, 14:14:00
    Author     : TÜRKMEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataBase.dataBase"%>
<%@page import="java.sql.*"%>
<%@page import="Java.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="styles/personelll.css"/>
    <title>JSP Page</title>
</head>
<body>
    <div id="dt">
    <h1>PROJE PANELİ</h1>
</div>
<div class="panel">
    <table>
        <tr>
          <th>Konusu</th>
          <th>proje adı</th> 
          <th>Proje Sahibi</th>    
          <th>Başlangıç Tarihi</th>
          <th>Bitiş Tarihi</th>
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
                        
                        out.print("<tr>");

                    }
    %>
    </table>
    </div>
    <form action="index.jsp">
        <button style="position: relative; left: 45%; top: 300px; background-color: orange; border-radius: 8px;"> ANASAYFA/ÇIKIŞ</button>
    </form>
</body>
</html>
