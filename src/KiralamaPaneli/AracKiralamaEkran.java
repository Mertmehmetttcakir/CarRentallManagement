package KiralamaPaneli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import MainModel.Arac;
import FaturaPaneli.Transaction;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class AracKiralamaEkran extends JFrame implements ActionListener {
    private JComboBox<String> sehirComboBox;
    private final JComboBox<String> aracComboBox;
    private final JButton kiralamaButton;
    private final ArrayList<Arac> araclar;
    /*

    private JComboBox<String> vitesComboBox;
    private JComboBox<String> yakitComboBox;

     */
    private JComboBox<String> alisTarihiComboBox;
    private JComboBox<String> verisTarihiComboBox;

    private Transaction alisTarihiChooser;
    private Transaction verisTarihiChooser;


    public AracKiralamaEkran() {
        araclar = createAraclar();


        setTitle("Araç Kiralama Ekranı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        sehirComboBox = new JComboBox<>();
        sehirComboBox.addItem("Istanbul");
        sehirComboBox.addItem("Ankara");
        sehirComboBox.addItem("Izmir");
        sehirComboBox.addActionListener(this);
        add(sehirComboBox);

        aracComboBox = new JComboBox<>();
        populateAracComboBox("Istanbul");
        add(aracComboBox);

     /*   vitesComboBox =new JComboBox<>();
        populateVitesComboBox("Manuel");
        populateVitesComboBox("Otomatik");
        add(vitesComboBox);


        yakitComboBox = new JComboBox<>();
        populateYakitComboBox("Benzin");
        populateYakitComboBox("Dizel");
        add(yakitComboBox);
*/
        alisTarihiComboBox = new JComboBox<>();
        populateTarihComboBox(alisTarihiComboBox);
        add(alisTarihiComboBox);

        verisTarihiComboBox = new JComboBox<>();
        populateTarihComboBox(verisTarihiComboBox);
        add(verisTarihiComboBox);


        kiralamaButton = new JButton("Kiralama");
        kiralamaButton.addActionListener(this);
        add(kiralamaButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ArrayList<Arac> createAraclar() {
        ArrayList<Arac> araclar = new ArrayList<>();
        araclar.add(new Arac("Istanbul","Nissan","Juke",300,"34-afk-78","Benzin","Otomatik"));
        araclar.add(new Arac("Izmir","Fiat","Egea",200,"35-hgk-88","Dizel","Manuel"));
        araclar.add(new Arac("Istanbul","Renault","Clio",200,"34-gud-38","Dizel","Otomatik"));
        araclar.add(new Arac("Izmir","Nissan","Micra",150,"35-bht-34","Benzin","Otomatik"));
        araclar.add(new Arac("Ankara","Renault","Fluence",200,"34-hk-457","Dizel","Manuel"));
        araclar.add(new Arac("Ankara","Fiat","Egea",200,"06-sds-78","Dizel","Otomatik"));
        araclar.add(new Arac("Istanbul","Wolkswogen","Golf",250,"34-krm-65","Benzin","Otomatik"));
        araclar.add(new Arac("Izmir","Ford","Focus",200,"35-tht-47","Dizel","Manuel"));
        araclar.add(new Arac("Ankara","Hyundai","Tucson",400,"06-nmk-28","Benzin","Manuel"));

        return araclar;
    }

    private void populateAracComboBox(String aracSube) {
        aracComboBox.removeAllItems();
        for (Arac arac : araclar) {
            if (arac.getaracSube().equals(aracSube)) {
                aracComboBox.addItem(arac.getMarka() + " " + arac.getModel());
            }
        }
    }
/*
    private void populateVitesComboBox(String vitesTuru) {
        if (vitesComboBox == null) {
            vitesComboBox = new JComboBox<>();
            add(vitesComboBox);
        }
        vitesComboBox.removeAllItems();
        vitesComboBox.addItem("seçiniz");
        vitesComboBox.addItem("Manuel");
        vitesComboBox.addItem("Otomatik");
        for (Arac arac : araclar) {
            if ((arac.getMarka() + " " + arac.getModel()).equals(vitesTuru)) {
                vitesComboBox.addItem(arac.getVitesTuru());
            }
        }

        if (vitesComboBox.getItemCount() > 0) {
            vitesComboBox.setSelectedIndex(0);
        }
    }

    private void populateYakitComboBox(String yakitTuru) {
        if (yakitComboBox == null) {
            yakitComboBox = new JComboBox<>();
            add(yakitComboBox);
        }

        yakitComboBox.removeAllItems();
        yakitComboBox.addItem("seçiniz");

        yakitComboBox.addItem("Benzin");
        yakitComboBox.addItem("Dizel");
        for (Arac arac : araclar) {
            if ((arac.getMarka() + " " + arac.getModel()).equals(yakitTuru)) {
                yakitComboBox.addItem(arac.getYakitTuru());
            }
        }

        if (yakitComboBox.getItemCount() > 0) {
            yakitComboBox.setSelectedIndex(0);
        }
    }
*/
    private void populateTarihComboBox(JComboBox<String> comboBox) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();

        comboBox.removeAllItems();
        for (int i = 0; i < 30; i++) {
            String dateStr = dateFormat.format(currentDate);
            comboBox.addItem(dateStr);
            currentDate.setTime(currentDate.getTime() + 24 * 60 * 60 * 1000); // Add one day
        }
    }

    private int calculateGunSayisi(String alisTarihi, String verisTarihi) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date alisDate = dateFormat.parse(alisTarihi);
            Date verisDate = dateFormat.parse(verisTarihi);

            long difference = verisDate.getTime() - alisDate.getTime();
            int gunSayisi = (int) (difference / (24 * 60 * 60 * 1000));
            return gunSayisi;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }






    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sehirComboBox) {
            String selectedSehir = (String) sehirComboBox.getSelectedItem();
            populateAracComboBox(selectedSehir);
        } else if (e.getSource() == kiralamaButton) {
            int selectedIndex = aracComboBox.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < aracComboBox.getItemCount()) {
                String selectedAracString = aracComboBox.getItemAt(selectedIndex);
                Arac selectedArac = findArac(selectedAracString);
                if (selectedArac != null) {
                    System.out.println("Seçilen araç: " + selectedArac.getMarka() + " " + selectedArac.getModel());
                    System.out.println("Seçilen vites türü: " + selectedArac.getVitesTuru());
                    System.out.println("Seçilen yakıt türü: " + selectedArac.getYakitTuru());

                    String alisTarihi = (String) alisTarihiComboBox.getSelectedItem();
                    String verisTarihi = (String) verisTarihiComboBox.getSelectedItem();

                    System.out.println("Seçilen alış tarihi: " + alisTarihi);
                    System.out.println("Seçilen veriş tarihi: " + verisTarihi);

                    showFaturaEkran(selectedArac, alisTarihi, verisTarihi);
                } else {
                    System.out.println("Geçersiz araç seçimi.");
                }
            }
        }
    }

    private Arac findArac(String selectedAracString) {
        for (Arac arac : araclar) {
            if ((arac.getMarka() + " " + arac.getModel()).equals(selectedAracString)) {
                return arac;
            }
        }
        return null;
    }

    private void showFaturaEkran(Arac selectedArac, String alisTarihi, String verisTarihi) {
        int gunSayisi = calculateGunSayisi(alisTarihi, verisTarihi);
        if (gunSayisi < 0) {
            JOptionPane.showMessageDialog(this, "Alış Tarihi Veriş Tarihinden önce olmalıdır. Lütfen tekrar deneyin.", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (gunSayisi ==0) {
            gunSayisi =1;

        }

        JFrame faturaEkrani = new JFrame();
        faturaEkrani.setTitle("Fatura Ekranı");
        faturaEkrani.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        faturaEkrani.setLayout(new FlowLayout());

        JLabel aracLabel = new JLabel("Araç: " + selectedArac.getMarka() + " " + selectedArac.getModel());
        faturaEkrani.getContentPane().add(aracLabel);

        int kiraBedeli = (int) (selectedArac.getKiraBedeli() * gunSayisi);
        JLabel kiraBedeliLabel = new JLabel("Kira Bedeli: " + kiraBedeli);
        faturaEkrani.getContentPane().add(kiraBedeliLabel);

        JLabel vitesLabel = new JLabel("Vites Türü: " + selectedArac.getVitesTuru());
        faturaEkrani.getContentPane().add(vitesLabel);

        JLabel yakitLabel = new JLabel("Yakıt Türü: " + selectedArac.getYakitTuru());
        faturaEkrani.getContentPane().add(yakitLabel);

        JLabel alisTarihiLabel = new JLabel("Alış Tarihi: " + alisTarihi);
        faturaEkrani.getContentPane().add(alisTarihiLabel);

        JLabel verisTarihiLabel = new JLabel("Veriş Tarihi: " + verisTarihi);
        faturaEkrani.getContentPane().add(verisTarihiLabel);

        faturaEkrani.pack();
        faturaEkrani.setLocationRelativeTo(this);
        faturaEkrani.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AracKiralamaEkran());
    }
}

