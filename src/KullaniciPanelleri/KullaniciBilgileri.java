package KullaniciPanelleri;

public class KullaniciBilgileri {
    private String kullaniciAdi;
    private String sifre;

    public KullaniciBilgileri(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }
}