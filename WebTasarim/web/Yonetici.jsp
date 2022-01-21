<%@page import="javax.websocket.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataBase.dataBase"%>
<%@page import="java.sql.*"%>
<%@page import="Java.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/Yonetici.css"/>
    <title>JSP Page</title>
</head>
<body>
    <h1>YÖNETİCİ GİRİŞİ</h1>
    <form action="" method="post">
		<input class="giris-yap" type="text" name="kullaniciadi" placeholder="Kullanıcı adı"/>
                <input class="giris-yap" type="password" name="parola" placeholder="Şifreniz"/>
		<button type="submit" name="giris"> GİRİŞ YAP </button>
              
		<input class="radio-button" name="hatirla" value="" type="checkbox"/><h2>Beni Hatırla</h2>
    </form>
<%
            dataBase db = new dataBase();
            String kullaniciadi = request.getParameter("kullaniciadi");
            String password = request.getParameter("parola");
            String giris = request.getParameter("giris");
            HttpSession oturum = request.getSession(true);
            
        Cookie ckUsername = null;
        Cookie ckPassword = null;
        Cookie durum = null;
        String passWordd = "";
        String userName = "";
            boolean hatirla = request.getParameter("hatirla") != null;
            
            
            if(kullaniciadi != null && password != null && giris != null){
                  ckUsername = new Cookie("username", kullaniciadi);
                  ckPassword = new Cookie("password", password);
                  durum = new Cookie("durum", "false");
                  oturum.setAttribute("ad", kullaniciadi);
                  
             }
            Cookie[] allCookies = request.getCookies();
         if (allCookies != null) {
             System.out.println("cookiler");
                 for(Cookie cook: allCookies){
                     System.out.println(cook.getValue());
                     if(cook.getName().equalsIgnoreCase("username")){
                         userName = cook.getValue();
                         
                     }
                     else if(cook.getName().equalsIgnoreCase("password")){
                         passWordd = cook.getValue();
                       
                     }
                     
                 }
             }
         
         if(allCookies != null){
             for(int i = 0; i < allCookies.length; i++){
                
             if(allCookies[i].getValue().contains(db.yoneticikontrol(userName, passWordd))){
                      response.sendRedirect(request.getContextPath() + "/personelislemleri.jsp");
                      break;
                  }
             else{
                 System.out.println("bulunamadi");
             }
         }
         }     
         
if (kullaniciadi != null && password != null && giris != null) {
                if (db.yoneticikontrol(kullaniciadi, password).equals("admin")) {
                    if(hatirla){
                         ckUsername.setMaxAge(3000);
                         response.addCookie(ckUsername);
                         ckPassword.setMaxAge(3000);
                         response.addCookie(ckPassword);
                         durum.setMaxAge(0);
                         response.addCookie(durum);
        }else{          
                            durum.setMaxAge(3000);
                         response.addCookie(durum);
                           
                        }
                        
                         
                         
                        response.sendRedirect("personelislemleri.jsp");
                   }       
else{
                out.println("\t Bilgiler yanlış");
            }
                }

%>		
</body>
</html>
