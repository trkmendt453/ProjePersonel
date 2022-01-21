<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataBase.dataBase"%>
<%@page import="java.sql.*"%>
<%@page import="Java.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="styles/Personel.css"/>
    <title>JSP Page</title>
</head>
<body>
    <h1>PERSONEL GİRİŞİ</h1>
    
	<form action="">
            <input class="giris-yap" type="text" name="kullaniciadi" placeholder="Kullanıcı adı"/>
            <input class="giris-yap" type="password" name="parola" placeholder="Şifreniz"/>
            <button type="submit" name="giris">GİRİŞ YAP</button>
            <h3>Şifremi Unuttum</h3>
            <input class="radio-button" name="" value="" type="checkbox"/><h2>Beni Hatırla</h2>
        </form>
    <%
            dataBase db = new dataBase();
            String kullaniciadi = request.getParameter("kullaniciadi");
            String password = request.getParameter("parola");
            String giris = request.getParameter("giris");

                  if(giris != null){
                      if (db.personelkontrol(kullaniciadi, password)) {
                                response.sendRedirect("personelll.jsp");
                                System.out.println("personel GELDİ");
                            }
                      else{
                          System.out.println("GİRİŞ BİLGİLERİ SIKINTILI");
                      }
                  }
    %>
</body>
</html>
