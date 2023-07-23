package MainModel;

import java.util.ArrayList;
public class Musteri {
    private String kullaniciAdi;
    private String sifre;
    private String ad;
    private String soyad;

    public Musteri(String kullaniciAdi, String sifre, String ad, String soyad) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }


    public void MusteriList() {
        ArrayList<Musteri> musteris = new ArrayList<>();
        musteris.add(new Musteri("Mert", "6161", "Mert", "Cakir"));
        musteris.add(new Musteri("Hasan", "0606", "Hasan", "Gurbuz"));
        musteris.add(new Musteri("Chapar", "6262", "Umutcan", "Capar"));

        for (Musteri musteri : musteris) {
            System.out.println("Kullanici Adı: " + musteri.getKullaniciAdi() + ", Şifre: " + musteri.getSifre());
        }
    }
}
