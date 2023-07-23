package KullaniciPanelleri;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import KiralamaPaneli.AracKiralamaEkran;

public class KullaniciGirisPenceresi extends JFrame {

    private JLabel kullaniciAdiLabel;
    private JTextField kullaniciAdiField;
    private JLabel sifreLabel;
    private JPasswordField sifreField;
    private JButton girisButton;

    private ArrayList<KullaniciBilgileri> kullaniciListesi;

    public KullaniciGirisPenceresi(ArrayList<KullaniciBilgileri> kullaniciListesi) {
        this.kullaniciListesi = kullaniciListesi;
        initComponents();
    }

    private void initComponents() {
        kullaniciAdiLabel = new JLabel("Kullanıcı Adı:");
        kullaniciAdiField = new JTextField();
        sifreLabel = new JLabel("Şifre:");
        sifreField = new JPasswordField();
        girisButton = new JButton("Giriş");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kullanıcı Girişi");

        setLayout(new java.awt.GridLayout(3, 2));
        add(kullaniciAdiLabel);
        add(kullaniciAdiField);
        add(sifreLabel);
        add(sifreField);
        add(new JLabel()); // Boş alan için
        add(girisButton);

        girisButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String kullaniciAdi = kullaniciAdiField.getText();
                String sifre = new String(sifreField.getPassword());

                boolean gecerliGiris = false;
                for (KullaniciBilgileri kullanici : kullaniciListesi) {
                    if (kullanici.getKullaniciAdi().equals(kullaniciAdi) && kullanici.getSifre().equals(sifre)) {
                        gecerliGiris = true;
                        break;
                    }
                }

                if (gecerliGiris) {
                    JOptionPane.showMessageDialog(null, "Giriş Başarılı");
                    AracKiralamaEkran aracKiralamaEkran = new AracKiralamaEkran();
                    aracKiralamaEkran.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Geçersiz Giriş");
                }
            }
        });

        pack();
    }

    public static void main(String[] args) {
        ArrayList<KullaniciBilgileri> kullaniciListesi = new ArrayList<>();
        kullaniciListesi.add(new KullaniciBilgileri("mert", "6161"));
        kullaniciListesi.add(new KullaniciBilgileri("hasan", "0606"));
        kullaniciListesi.add(new KullaniciBilgileri("Chapar", "6262"));

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullaniciGirisPenceresi(kullaniciListesi).setVisible(true);
            }
        });
    }
}

