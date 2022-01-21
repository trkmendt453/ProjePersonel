package Java;


public class personel {
    
    private String ad;
    private String soyad;
    private String kullaniciadi;
    private String tc;
    private String telefonno;
    private String adres;
    private String sifre;
    private String email;
    
    public personel(String ad,String soyad,String kullaniciadi,String tc,String telefonno,String adres,String sifre,String email) {
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciadi = kullaniciadi;
        this.tc = tc;
        this.telefonno = telefonno;
        this.adres = adres;
        this.sifre = sifre;
        this.email = email;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getTelefonno() {
        return telefonno;
    }

    public void setTelefonno(String telefonno) {
        this.telefonno = telefonno;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
