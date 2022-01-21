package DataBase;

import java.sql.*;
import Java.*;

public class dataBase {
    static final String DB_URL = "jdbc:mysql://localhost:3306/projepersonel";
    static final String USER="root";
    static final String PASSWORD="root";
   
    public static void PersonelKaydet(personel personel) {

        Connection con =null;
        PreparedStatement psnt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String sql ="INSERT INTO calisanlar(ad,soyad,kullaniciadi,tc,telefonno,adres,sifre,email) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            psnt = con.prepareStatement(sql);
            
            psnt.setString(1,personel.getAd());//1
            psnt.setString(2,personel.getSoyad());//2
            psnt.setString(3,personel.getTc());
            psnt.setString(4,personel.getKullaniciadi());//4
            psnt.setString(5,personel.getSifre());//5
            psnt.setString(6,personel.getAdres());//6
            psnt.setString(7,personel.getTelefonno());//7
            psnt.setString(8,personel.getEmail());//8
           
            psnt.executeUpdate();
           // veri tabanı kullanıldıktan sonra kapatılıyor

            psnt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("HATA :  "+ e);
        }
    }
    public String yoneticikontrol(String kullaniciadi, String sifre){
        Connection con =null;
        Statement st = null;
        ResultSet rst=null;
        boolean durum = false;
        try {
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            st = con.createStatement();
            String sql ="SELECT * FROM yonetici";
            rst = st.executeQuery(sql);

            while(rst.next()){
                if(rst.getString("kullaniciadi").equals(kullaniciadi) && rst.getString("sifre").equals(sifre)){
                    return "admin";
                 
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" HATA : " );

        }
        return "hesap yok";
    }

    public boolean personelkontrol(String kullaniciadi, String sifre){
        Connection con =null;
        Statement st = null;
        ResultSet rst=null;
        boolean durum = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            st = con.createStatement();
            String sql ="SELECT * FROM calisanlar";
            rst = st.executeQuery(sql);

            while(rst.next()){
                if(rst.getString("kullaniciadi").equals(kullaniciadi) && rst.getString("sifre").equals(sifre)){
                    System.out.println("personel BULDU");
                    durum = true;
                    break;
                }else{
                    durum = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" HATA : " );

        }
        return durum;
    }

    public ResultSet personelTablo(){
        Connection con =null;
        Statement st = null;
        ResultSet rst=null;

        try {
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            st = con.createStatement();
            String sql ="SELECT * FROM calisanlar";
            rst = st.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" HATA : " );
        }
        return rst;
    }
    public ResultSet yoneticiTablo(){
        Connection con =null;
        Statement st = null;
        ResultSet rst=null;

        try {
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            st = con.createStatement();
            String sql ="SELECT * FROM yonetici";
            rst = st.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" HATA : "+e );
        }
        return rst;
    }
    
    public ResultSet islemTablo(){
        Connection con =null;
        Statement st = null;
        ResultSet rst=null;

        try {
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            st = con.createStatement();
            String sql ="SELECT * FROM islemler";
            rst = st.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" HATA : " );
        }
        return rst;
    }
    
    public static void islemKaydet(islemler islem) {

        Connection con =null;
        PreparedStatement psnt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String sql ="INSERT INTO islemler(konu,projeadi,baslangictarih,bitistarih,projesahibi) VALUES(?, ?, ?, ?, ?)";
            psnt = con.prepareStatement(sql);
            
            psnt.setString(1,islem.getKonu());
            psnt.setString(2,islem.getProjeadi());
            psnt.setString(3,islem.getBaslangictarih());
            psnt.setString(4,islem.getBitistarih());
            psnt.setString(5,islem.getProjesahibi());
           
            psnt.executeUpdate();
           // veri tabanı kullanıldıktan sonra kapatılıyor

            psnt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("HATA :  "+ e);
        }
    }
    public static void yoneticikaydet(yonetici yonetici) {

        Connection con =null;
        PreparedStatement psnt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String sql ="INSERT INTO yonetici(ad,soyad,tc,adres,email,telefonno,kullaniciadi,sifre) VALUES(?, ?, ?, ?,?, ?, ?, ?)";
            psnt = con.prepareStatement(sql);
            
            psnt.setString(1,yonetici.getAd());
            psnt.setString(2,yonetici.getSoyad());
            psnt.setString(3,yonetici.getTc());
            psnt.setString(4,yonetici.getAdres());
            psnt.setString(5,yonetici.getEmail());
            psnt.setString(6,yonetici.getTelefonno());
            psnt.setString(7,yonetici.getKullaniciadi());
            psnt.setString(8,yonetici.getSifre());
           
            psnt.executeUpdate();
           // veri tabanı kullanıldıktan sonra kapatılıyor

            psnt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("HATA :  "+ e);
        }
    }
    public  void personelkayitsil(int id){
     Connection conn = null;
         PreparedStatement sorgu = null;


          try {
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

             sorgu = conn.prepareStatement("DELETE   FROM calisanlar WHERE ID='" + id + "'");
             sorgu.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
    
    public  void islemkayitsil(int id){
     Connection conn = null;
         PreparedStatement sorgu = null;


          try {
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

             sorgu = conn.prepareStatement("DELETE   FROM islemler WHERE ID='" + id + "'");
             sorgu.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
    public  void yoneticikayitsil(int id){
     Connection conn = null;
         PreparedStatement sorgu = null;


          try {
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

             sorgu = conn.prepareStatement("DELETE   FROM yonetici WHERE ID='" + id + "'");
             sorgu.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
     public static void yoneticiGuncelle(int ID, String ad, String soyad, String tc, String adres, String email, String telefonno, String kullaniciadi, String sifre){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement sorgu = conn.prepareStatement("UPDATE yonetici SET ad ='" + ad + "', soyad='" + soyad + "', tc='" + tc + "', adres='" +
                    adres +  "', telefonno='" + telefonno +  "', email='" + email+ "', kullaniciadi='" + kullaniciadi + "', sifre='" + sifre + "' WHERE id='" + ID + "'");
            sorgu.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("KULLANICI GÜNCELLEMEDE HATA");
        }
    }
     public static void projeGuncelle(int ID, String konu, String projeadi, String baslangictarihi, String bitistarihi, String projesahibi){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement sorgu = conn.prepareStatement("UPDATE islemler SET konu ='" + konu + "', projeadi='" + projeadi + "', baslangictarih='" + baslangictarihi + "', bitistarih='" +
                    bitistarihi +  "', projesahibi='" + projesahibi + "' WHERE id='" + ID + "'");
            sorgu.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("KULLANICI GÜNCELLEMEDE HATA");
        }
    }
     
    public static void personelGuncelle(int ID, String ad, String soyad, String tc, String adres, String email, String telefonno, String kullaniciadi, String sifre){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement sorgu = conn.prepareStatement("UPDATE calisanlar SET ad ='" + ad + "', soyad='" + soyad + "', tc='" + tc + "', adres='" +
                    adres +  "', telefonno='" + telefonno  +  "', email='" + email+ "', kullaniciadi='" + kullaniciadi + "', sifre='" + sifre + "' WHERE id='" + ID + "'");
            sorgu.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("KULLANICI GÜNCELLEMEDE HATA");
        }
    }
}
