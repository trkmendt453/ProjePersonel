package Java;

public class islemler {
    private String konu;
    private String projeadi;
    private String baslangictarih;
    private String bitistarih;
    private String projesahibi;
    public islemler(String konu,String projeadi,String baslangictarih,String bitistarih,String projesahibi){
        this.konu =konu;
        this.projeadi =projeadi;
        this.baslangictarih =baslangictarih;
        this.bitistarih =bitistarih;
        this.projesahibi =projesahibi;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getProjeadi() {
        return projeadi;
    }

    public void setProjeadi(String projeadi) {
        this.projeadi = projeadi;
    }

    public String getBaslangictarih() {
        return baslangictarih;
    }

    public void setBaslangictarih(String baslangictarih) {
        this.baslangictarih = baslangictarih;
    }

    public String getBitistarih() {
        return bitistarih;
    }

    public void setBitistarih(String bitistarih) {
        this.bitistarih = bitistarih;
    }

    public String getProjesahibi() {
        return projesahibi;
    }

    public void setProjesahibi(String projesahibi) {
        this.projesahibi = projesahibi;
    }
    
}
