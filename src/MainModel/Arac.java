package MainModel;

import java.util.ArrayList;

public class Arac {

    private String aracSube;
    private String marka;
    private String model;
    private double kiraBedeli;
    private String plaka;
    private String yakitTuru;
    private String vitesTuru;


    public Arac(String aracSube, String marka, String model, double kiraBedeli, String plaka,String yakitTuru,String vitesTuru) {
        this.aracSube = aracSube;
        this.marka = marka;
        this.model = model;
        this.kiraBedeli = kiraBedeli;
        this.plaka = plaka;
        this.yakitTuru=yakitTuru;
        this.vitesTuru=vitesTuru;

    }


    public String getaracSube() {
        return aracSube;
    }



    @Override
    public String toString() {
        return getMarka() + " " + getModel();
    }

    public String getMarka() {
        return marka;
    }





    public double getKiraBedeli() {
        return kiraBedeli;
    }



    public String getPlaka() {
        return plaka;
    }



    public String getModel() {
        return model;
    }
    public String getYakitTuru(){
        return yakitTuru;
    }
    public String getVitesTuru(){
        return vitesTuru;
    }
    public void PriceList() {

        ArrayList<Arac> Araclar = new ArrayList<>();
        Araclar.add(new Arac("Istanbul","Nissan","Juke",300,"34-afk-78","Benzin","Otomatik"));
        Araclar.add(new Arac("Izmir","Fiat","Egea",200,"35-hgk-88","Dizel","Manuel"));
        Araclar.add(new Arac("Istanbul","Renault","Clio",200,"34-gud-38","Dizel","Otomatik"));
        Araclar.add(new Arac("Izmir","Nissan","Micra",150,"35-bht-34","Benzin","Otomatik"));
        Araclar.add(new Arac("Ankara","Renault","Fluence",200,"34-hk-457","Dizel","Manuel"));
        Araclar.add(new Arac("Ankara","Fiat","Egea",200,"06-sds-78","Dizel","Otomatik"));
        Araclar.add(new Arac("Istanbul","Wolkswogen","Golf",250,"34-krm-65","Benzin","Otomatik"));
        Araclar.add(new Arac("Izmir","Ford","Focus",200,"35-tht-47","Dizel","Manuel"));
        Araclar.add(new Arac("Ankara","Hyundai","Tucson",400,"06-nmk-28","Benzin","Manuel"));


        for(Arac Arac : Araclar){
            System.out.println("Kiralanan arac: "+Arac.marka+ " "+ Arac.model+ "Fiyati: " + Arac.getKiraBedeli());
        }
    }
}
