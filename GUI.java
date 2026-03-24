// gerekli kütüphaneler
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


//GUI sınıfı
public class GUI {
    //arac,enerji ve binaları sisteme kaydetmeye yarayan listeler
    private List<String> aracListesi = new ArrayList<String>();//arac  lıstesi
    private List<String> binaListesi = new ArrayList<String>(); // Bina listesi
    private List<String> enerjiListesi = new ArrayList<String>(); // Enerji kaynağı listesi

    // kişilerin girişini sağlayan butonlar
    JButton yoneticiButton;
    JButton vatandasButton;
    JFrame pencere;
    JTextArea goruntulemeAlani;

    //GUI sınıfının constructor yapısı
    public GUI() {
        anaSayfa();

        pencere.setVisible(true);
    }

    public void anaSayfa() {
        pencere = new JFrame("Rol Seçimi");

        pencere.setSize(400, 300);
        pencere.getContentPane().setBackground(Color.YELLOW); // Arka plan rengi kırmızı



        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel anaSayfaPanel = new JPanel(new GridLayout(2, 1));
        anaSayfaPanel.setBackground(Color.YELLOW); // Arka plan rengi kırmızı

        yoneticiButton = new JButton("Yönetici");
        vatandasButton = new JButton("Vatandaş");
        // Buton yazı rengini siyah yap
        yoneticiButton.setForeground(Color.BLACK);
        vatandasButton.setForeground(Color.BLACK);


        anaSayfaPanel.add(yoneticiButton);
        anaSayfaPanel.add(vatandasButton);

        pencere.add(anaSayfaPanel);

        yoneticiButton.addActionListener(e -> yoneticiIslemleri());
        vatandasButton.addActionListener(e -> vatandasIslemleri());

        pencere.setVisible(true);
    }
    //varlık yonetımını sağlayan fonksiyon
    public void varlikYonetimi() {
        JFrame varlikAltMenuPenceresi = new JFrame("Varlık Yönetimi - Alt Menü");
        varlikAltMenuPenceresi.setSize(400, 300);
        varlikAltMenuPenceresi.getContentPane().setBackground(Color.YELLOW); // Arka plan rengi
        varlikAltMenuPenceresi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel altMenuPanel = new JPanel(new GridLayout(3, 1));
        altMenuPanel.setBackground(Color.YELLOW); // Arka plan rengi kırmızı
        JButton aracEkleButton = new JButton("Araç Ekle");
        JButton enerjiEkleButton = new JButton("Enerji Ekle");
        JButton binaEkleButton = new JButton("Bina Ekle");

        // Buton yazı rengini siyah yap
        aracEkleButton.setForeground(Color.BLACK);
        enerjiEkleButton.setForeground(Color.BLACK);
        binaEkleButton.setForeground(Color.BLACK);



        altMenuPanel.add(aracEkleButton);
        altMenuPanel.add(enerjiEkleButton);
        altMenuPanel.add(binaEkleButton);

        varlikAltMenuPenceresi.add(altMenuPanel);

        aracEkleButton.addActionListener(e -> aracEkle());
        enerjiEkleButton.addActionListener(e -> enerjiEkle());
        binaEkleButton.addActionListener(e -> binaEkle());

        varlikAltMenuPenceresi.setVisible(true);
    }
    //sisteme araçları eklemek için kullandığım fonksiyon
    private void aracEkle() {
        JFrame frame = new JFrame("Araç Ekleme");
        frame.setSize(500, 300);
        frame.getContentPane().setBackground(Color.YELLOW); // Arka plan rengi kırmızı

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.YELLOW); // Arka plan rengi kırmızı
        frame.add(panel);

        JLabel vehicleTypeLabel = new JLabel("Araç Tipini Seçin:");
        vehicleTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        vehicleTypeLabel.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(vehicleTypeLabel);

        String[] vehicleTypes = {"Otobüs", "Otomobil", "Motosiklet", "Elektrikli Araç"};
        JComboBox<String> vehicleTypeComboBox = new JComboBox<>(vehicleTypes);
        vehicleTypeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(vehicleTypeComboBox);

        JLabel capacityLabel = new JLabel("Kapasiteyi Girin:");
        capacityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        capacityLabel.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(capacityLabel);





        JTextField capacityField = new JTextField();
        capacityField.setMaximumSize(new Dimension(200, 30));
        panel.add(capacityField);

        JLabel chargeLabel = new JLabel("Şarj Seviyesi (%):");
        chargeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        chargeLabel.setForeground(Color.BLACK); // Yazı rengi siyah
        chargeLabel.setVisible(false);
        panel.add(chargeLabel);

        JTextField chargeField = new JTextField();
        chargeField.setMaximumSize(new Dimension(200, 30));
        chargeField.setVisible(false);
        panel.add(chargeField);

        vehicleTypeComboBox.addActionListener(e -> {
            if (vehicleTypeComboBox.getSelectedItem().equals("Elektrikli Araç")) {
                chargeLabel.setVisible(true);
                chargeField.setVisible(true);
            } else {
                chargeLabel.setVisible(false);
                chargeField.setVisible(false);
            }
        });

        JButton saveButton = new JButton("Kaydet");
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveButton.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(saveButton);

        saveButton.addActionListener(e -> {
            try {
                String selectedType = (String) vehicleTypeComboBox.getSelectedItem();
                int capacity = Integer.parseInt(capacityField.getText());
                boolean isElectric = selectedType.equals("Elektrikli Araç");

                int chargeLevel = -1;
                if (isElectric) {
                    chargeLevel = Integer.parseInt(chargeField.getText());
                    if (chargeLevel < 20) {
                        JOptionPane.showMessageDialog(frame, "Uyarı: Şarj seviyesi düşük! Şarj istasyonuna yönlendirilmelidir.",
                                "Düşük Şarj", JOptionPane.WARNING_MESSAGE);
                    }
                }

                Arac arac = new Arac(selectedType, capacity, isElectric);
                aracListesi.add(String.valueOf(arac));

                JOptionPane.showMessageDialog(frame, "Araç başarıyla eklendi!", "Başarılı",
                        JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Lütfen kapasite veya şarj seviyesi için geçerli bir sayı girin!",
                        "Hata", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Araç kaydedilirken bir hata oluştu: " + ex.getMessage(), "Hata",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
    //enerhi kaynağı eklemek için fonksiyon
    private void enerjiEkle() {
        JFrame frame = new JFrame("Enerji Kaynağı Ekleme");
        frame.setSize(500, 400);
        frame.getContentPane().setBackground(Color.YELLOW); // Arka plan rengi kırmızı




        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.YELLOW); // Arka plan rengi kırmızı
        frame.add(panel);

        JLabel energyTypeLabel = new JLabel("Enerji Türünü Seçin:");
        energyTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        energyTypeLabel.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(energyTypeLabel);

        String[] energyTypes = {"Güneş", "Rüzgar", "Nükleer", "Fosil Yakıt"};
        JComboBox<String> energyTypeComboBox = new JComboBox<>(energyTypes);
        energyTypeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(energyTypeComboBox);

        JLabel capacityLabel = new JLabel("Üretim Kapasitesini Girin (kW):");
        capacityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        capacityLabel.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(capacityLabel);

        JTextField capacityField = new JTextField();
        capacityField.setMaximumSize(new Dimension(200, 30));
        panel.add(capacityField);

        JLabel consumptionLabel = new JLabel("Günlük Tüketimi Girin (kW):");
        consumptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        consumptionLabel.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(consumptionLabel);

        JTextField consumptionField = new JTextField();
        consumptionField.setMaximumSize(new Dimension(200, 30));
        panel.add(consumptionField);

        JButton saveButton = new JButton("Kaydet");
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveButton.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(saveButton);

        saveButton.addActionListener(e -> {
            try {
                String selectedType = (String) energyTypeComboBox.getSelectedItem();
                int capacity = Integer.parseInt(capacityField.getText());
                int consumption = Integer.parseInt(consumptionField.getText());

                EnerjiKaynagi energySource = new EnerjiKaynagi(selectedType, capacity, consumption);
                energySource.updateConsumption(consumption);

                if (energySource.isOverloaded()) {
                    JOptionPane.showMessageDialog(frame,
                            "UYARI! " + selectedType + " kaynağı kapasitesinin üzerine çıktı! Gerekli önlemler alınmalı.",
                            "Aşırı Yükleme Uyarısı", JOptionPane.WARNING_MESSAGE);
                }
                EnerjiKaynagi enerji = new EnerjiKaynagi(selectedType, capacity, consumption);
                enerjiListesi.add(String.valueOf(enerji));
                JOptionPane.showMessageDialog(frame, "Enerji kaynağı başarıyla eklendi!", "Başarılı",
                        JOptionPane.INFORMATION_MESSAGE);

                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Lütfen kapasite ve tüketim için geçerli bir sayı girin!",
                        "Hata", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Enerji kaynağı eklenirken bir hata oluştu: " + ex.getMessage(),
                        "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });





        frame.setVisible(true);
    }

    //bina eklemeye yarayan fonksiyon
    private void binaEkle() {
        JFrame frame = new JFrame("Bina Ekleme");
        frame.setSize(500, 350);
        frame.getContentPane().setBackground(Color.YELLOW); // Arka plan rengi kırmızı

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.YELLOW); // Arka plan rengi kırmızı
        frame.add(panel);

        JLabel buildingTypeLabel = new JLabel("Bina Tipini Seçin:");
        buildingTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buildingTypeLabel.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(buildingTypeLabel);

        String[] buildingTypes = {"Akıllı Bina", "Geleneksel Bina"};
        JComboBox<String> buildingTypeComboBox = new JComboBox<>(buildingTypes);
        buildingTypeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buildingTypeComboBox);

        JLabel floorLabel = new JLabel("Kat Sayısını Girin:");
        floorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        floorLabel.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(floorLabel);

        JTextField floorField = new JTextField();
        floorField.setMaximumSize(new Dimension(200, 30));
        panel.add(floorField);

        JLabel efficiencyLabel = new JLabel("Enerji Verimliliği (% 0-100):");
        efficiencyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        efficiencyLabel.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(efficiencyLabel);

        JTextField efficiencyField = new JTextField();
        efficiencyField.setMaximumSize(new Dimension(200, 30));
        panel.add(efficiencyField);

        JButton saveButton = new JButton("Kaydet");
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveButton.setForeground(Color.BLACK); // Yazı rengi siyah
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(saveButton);

        saveButton.addActionListener(e -> {
            try {
                String selectedType = (String) buildingTypeComboBox.getSelectedItem();
                int floors = Integer.parseInt(floorField.getText());
                int efficiency = Integer.parseInt(efficiencyField.getText());

                if (efficiency < 0 || efficiency > 100) {
                    throw new IllegalArgumentException("Enerji verimliliği 0 ile 100 arasında olmalıdır!");
                }

                Bina building = new Bina(selectedType, floors, efficiency);
                binaListesi.add(String.valueOf(building));
                JOptionPane.showMessageDialog(frame, "Bina bşarılı bir şekilde eklendi!", "Başarılı",
                        JOptionPane.INFORMATION_MESSAGE);


                if (selectedType.equals("Akıllı Bina")) {
                    JOptionPane.showMessageDialog(frame, "Akıllı bina enerji tasarrufu modunda çalışacaktır.", "Bilgi",
                            JOptionPane.INFORMATION_MESSAGE);
                }





                JOptionPane.showMessageDialog(frame, "Bina başarıyla eklendi!", "Başarılı",
                        JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Lütfen sayı giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Bina eklenirken bir hata oluştu: " + ex.getMessage(), "Hata",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    //yoneticinin sistemi yonettiği kısım
    public void hizmetYonetimi() {
        JFrame hizmetPenceresi = new JFrame("Hizmet Yönetimi");
        hizmetPenceresi.setSize(400, 300);
        hizmetPenceresi.getContentPane().setBackground(Color.YELLOW); // Arka plan rengi kırmızı
        hizmetPenceresi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel hizmetPanel = new JPanel(new GridLayout(3, 1));
        hizmetPanel.setBackground(Color.YELLOW); // Arka plan rengi kırmızı
        JButton trafikYonetimiButonu = new JButton("Trafik Yönetimi");
        JButton suYonetimiButonu = new JButton("Su Yönetimi");
        JButton enerjiYonetimiButonu = new JButton("Enerji Yönetimi");
        // Buton yazı rengini siyah yap
        trafikYonetimiButonu.setForeground(Color.BLACK);
        suYonetimiButonu.setForeground(Color.BLACK);
        enerjiYonetimiButonu.setForeground(Color.BLACK);

        hizmetPanel.add(trafikYonetimiButonu);
        hizmetPanel.add(suYonetimiButonu);
        hizmetPanel.add(enerjiYonetimiButonu);

        hizmetPenceresi.add(hizmetPanel);

        // Trafik Yönetimi Butonu İşlemleri
        trafikYonetimiButonu.addActionListener((ActionEvent e) -> {
            JFrame trafikPenceresi = new JFrame("Trafik Yönetimi");
            trafikPenceresi.setSize(400, 300);
            trafikPenceresi.getContentPane().setBackground(Color.YELLOW); // Arka plan rengi kırmızı

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);

            // Araç listesindeki tüm araçlar gösteriliyor
            if (aracListesi.isEmpty()) {
                textArea.setText("Kayıtlı araç bulunmamaktadır.");
            } else {
                StringBuilder araclar = new StringBuilder("Kayıtlı Araçlar:\n");
                for (String arac : aracListesi) {
                    araclar.append(arac).append("\n");
                }
                textArea.setText(araclar.toString());
            }

            trafikPenceresi.add(new JScrollPane(textArea));
            trafikPenceresi.setVisible(true);
        });

        // Su Yönetimi Butonu İşlemleri
        suYonetimiButonu.addActionListener(e -> {
            JFrame suPenceresi = new JFrame("Su Yönetimi");
            suPenceresi.setSize(400, 300);
            suPenceresi.getContentPane().setBackground(Color.YELLOW); // Arka plan rengi kırmızı

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);



            // Şehirdeki su rezervleri burada görüntüleniyor
            String suRezervBilgileri = "Şehirdeki Su Rezerv Bilgileri:\n" +
                    "Toplam Su Rezervi: 500,000 litre\n" +
                    "Günlük Tüketim: 25,000 litre\n" +
                    "Kalan Su: 475,000 litre";

            textArea.setText(suRezervBilgileri);
            suPenceresi.add(new JScrollPane(textArea));
            suPenceresi.setVisible(true);
        });

        // Enerji Yönetimi Butonu İşlemleri
        enerjiYonetimiButonu.addActionListener(e -> {
            JFrame enerjiPenceresi = new JFrame("Enerji Yönetimi");
            enerjiPenceresi.setSize(400, 300);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);

            // Enerji listesindeki enerji kaynakları ve durumları gösteriliyor
            if (enerjiListesi.isEmpty()) {
                textArea.setText("Kayıtlı enerji kaynağı bulunmamaktadır.");
            } else {
                StringBuilder enerjiKaynaklari = new StringBuilder("Kayıtlı Enerji Kaynakları:\n");
                for (String enerji : enerjiListesi) {
                    enerjiKaynaklari.append(enerji).append("\n");
                }
                textArea.setText(enerjiKaynaklari.toString());
            }

            enerjiPenceresi.add(new JScrollPane(textArea));
            enerjiPenceresi.setVisible(true);
        });

        hizmetPenceresi.setVisible(true);
    }

    //sistemdeki raporları goruntulemeye yarayan işlev
    public void raporGoruntuleme() {
        JFrame raporPenceresi = new JFrame("Raporları Görüntüle");
        raporPenceresi.setSize(400, 300);

        raporPenceresi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel raporPanel = new JPanel(new GridLayout(3, 1));
        raporPanel.setBackground(Color.PINK); // Arka plan rengini sarı yaptık
        JButton trafikRaporButonu = new JButton("Trafik Raporları");
        JButton enerjiRaporButonu = new JButton("Enerji Raporları");
        JButton suRaporButonu = new JButton("Su Raporları");

        raporPanel.add(trafikRaporButonu);
        raporPanel.add(enerjiRaporButonu);
        raporPanel.add(suRaporButonu);

        raporPenceresi.add(raporPanel);

        // Trafik Raporları Butonu İşlemleri
        trafikRaporButonu.addActionListener(e -> {
            JFrame trafikRaporPenceresi = new JFrame("Trafik Raporları");
            trafikRaporPenceresi.setSize(400, 300);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);





            if (aracListesi.isEmpty()) {
                textArea.setText("Trafik Raporu: Araç bulunmamaktadır. Trafik çok rahat.");
            } else {
                StringBuilder trafikRaporu = new StringBuilder("Trafik Raporu:\n");
                trafikRaporu.append("Toplam Araç Sayısı: ").append(aracListesi.size()).append("\n");

                if (aracListesi.size() > 5) {
                    trafikRaporu.append("Trafik Durumu: Yoğun\n");
                } else {
                    trafikRaporu.append("Trafik Durumu: Normal\n");
                }

                trafikRaporu.append("\nAraç Listesi:\n");
                for (String arac : aracListesi) {
                    trafikRaporu.append("- ").append(arac).append("\n");
                }

                textArea.setText(trafikRaporu.toString());
            }

            trafikRaporPenceresi.add(new JScrollPane(textArea));
            trafikRaporPenceresi.setVisible(true);
        });

        // Enerji Raporları Butonu İşlemleri
        enerjiRaporButonu.addActionListener(e -> {
            JFrame enerjiRaporPenceresi = new JFrame("Enerji Raporları");
            enerjiRaporPenceresi.setSize(400, 300);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);

            if (enerjiListesi.isEmpty()) {
                textArea.setText("Enerji Raporu: Enerji kaynağı bulunmamaktadır.");
            } else {
                StringBuilder enerjiRaporu = new StringBuilder("Enerji Raporu:\n");
                enerjiRaporu.append("Toplam Enerji Kaynağı Sayısı: ").append(enerjiListesi.size()).append("\n");

                enerjiRaporu.append("\nEnerji Kaynakları Listesi:\n");
                for (String enerji : enerjiListesi) {
                    enerjiRaporu.append("- ").append(enerji).append("\n");
                }

                textArea.setText(enerjiRaporu.toString());
            }

            enerjiRaporPenceresi.add(new JScrollPane(textArea));
            enerjiRaporPenceresi.setVisible(true);
        });

        // Su Raporları Butonu İşlemleri
        suRaporButonu.addActionListener(e -> {
            JFrame suRaporPenceresi = new JFrame("Su Raporları");
            suRaporPenceresi.setSize(400, 300);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);

            // Suyla ilgili liste veya değer olmadığı için örnek metin gösteriyoruz
            String suRaporu = """ 
                Su Raporu: 
                Toplam Su Rezervi: 500,000 litre 
                Günlük Tüketim: 25,000 litre 
   
 
 
 
                Kalan Su: 475,000 litre 
                Durum: Şehir su sıkıntısı yaşamıyor. 
                """;

            textArea.setText(suRaporu);

            suRaporPenceresi.add(new JScrollPane(textArea));
            suRaporPenceresi.setVisible(true);
        });

        raporPenceresi.setVisible(true);
    }

    // sistemin sistemdeki verilere göre olusturdugu cozum onerilerini kapsayan fonksiyon
    public void sorunCozumu() {
        JFrame sorunCozumuPenceresi = new JFrame("Sorun Çözümü");
        sorunCozumuPenceresi.setSize(500, 400);
        sorunCozumuPenceresi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel sorunPanel = new JPanel(new BorderLayout());
        sorunPanel.setBackground(Color.PINK); // Arka plan rengini sarı yaptık
        JTextArea cozumBilgisiAlani = new JTextArea();
        cozumBilgisiAlani.setEditable(false);

        JButton cozumBulButonu = new JButton("Sorunlara Çözüm Bul");
        sorunPanel.add(new JScrollPane(cozumBilgisiAlani), BorderLayout.CENTER);
        sorunPanel.add(cozumBulButonu, BorderLayout.SOUTH);

        sorunCozumuPenceresi.add(sorunPanel);


        int mevcutSuMiktari = 12000; // Mevcut su miktarı (litre) - Örnektir

        // Butona tıklanınca sistem bilgilerini değerlendirip, sorunlar ve çözümler oluşturuyoruz
        cozumBulButonu.addActionListener(e -> {
            StringBuilder cozumMetni = new StringBuilder("Sorunlar ve Çözüm Önerileri:\n\n");

            // Trafik durumu ve çözümü
            int aracSayisi = aracListesi.size();
            if (aracSayisi > 5) {
                cozumMetni.append("**** Uyarı: Trafik yoğunluğu yüksek.\n");
                cozumMetni.append("Toplam Araç Sayısı: ").append(aracSayisi).append("\n");
                cozumMetni.append("=> Çözüm: Alternatif güzergahlar belirleyin veya trafik ışıklarını optimize edin.\n\n");
            } else if (aracSayisi > 0) {
                cozumMetni.append(" Trafik Durumu: Normal.\n");
                cozumMetni.append("Toplam Araç Sayısı: ").append(aracSayisi).append("\n\n");
            } else {
                cozumMetni.append(" Trafik Durumu: Hiçbir araç bulunmuyor, trafik çok rahat.\n\n");
            }

            // Enerji durumu ve çözümü
            int enerjiKaynakSayisi = enerjiListesi.size();
            if (enerjiKaynakSayisi <= 2) {
                cozumMetni.append("*** Uyarı: Enerji tüketimi kritik seviyede olabilir.\n");
                cozumMetni.append("Mevcut Enerji Kaynağı Sayısı: ").append(enerjiKaynakSayisi).append("\n");
                cozumMetni.append("=> Çözüm: Gereksiz enerji tüketen bölgeleri belirleyin ve yenilenebilir enerji kaynaklarını artırın.\n\n");
            } else {
                cozumMetni.append("✔ Enerji Durumu: Enerji kaynakları yeterli görünüyor.\n");
                cozumMetni.append("Mevcut Enerji Kaynağı Sayısı: ").append(enerjiKaynakSayisi).append("\n\n");
            }

            // Su durumu ve çözümü
            if (mevcutSuMiktari < 10000) { // Su miktarı 10,000 litreden az ise, kritik durum
                cozumMetni.append("*** Uyarı: Su rezervi tükenmek üzere.\n");




                cozumMetni.append("Mevcut Su Miktarı: ").append(mevcutSuMiktari).append(" litre\n");
                cozumMetni.append("=> Çözüm: Su tüketiminde tasarruf sağlayacak kampanyalar başlatın ve kritik bölgelere su kaynağı yönlendirin.\n\n");
            } else if (mevcutSuMiktari < 50000) { // Orta seviye uyarı
                cozumMetni.append("=> Uyarı: Su rezervi azalmış durumda.\n");
                cozumMetni.append("Mevcut Su Miktarı: ").append(mevcutSuMiktari).append(" litre\n");
                cozumMetni.append("=> Çözüm: Su kullanımında dikkatli olunması tavsiye edilir.\n\n");
            } else {
                cozumMetni.append(" Su Durumu: Su rezervi yeterli.\n");
                cozumMetni.append("Mevcut Su Miktarı: ").append(mevcutSuMiktari).append(" litre\n\n");
            }

            // Çözüm bilgilerini kullanıcıya göster
            cozumBilgisiAlani.setText(cozumMetni.toString());
        });

        sorunCozumuPenceresi.setVisible(true);
    }

    //yoneticinin yapacağı işlemleri arayüzde gosteren kısım
    public void yoneticiIslemleri() {
        JFrame yoneticiPenceresi = new JFrame("Yönetici İşlemleri");
        yoneticiPenceresi.setSize(500, 400);
        yoneticiPenceresi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel yoneticiPanel = new JPanel(new GridLayout(4, 1));
        yoneticiPanel.setBackground(Color.YELLOW); // Arka plan rengini sarı yaptık
        JButton varlikYonetimiButonu = new JButton("Varlık Yönetimi");
        JButton hizmetYonetimiButonu = new JButton("Hizmet Yönetimi");
        JButton raporGoruntulemeButonu = new JButton("Raporları Görüntüle");
        JButton sorunYonetimiButonu = new JButton("Sistem Sorunlarını Çöz");

        yoneticiPanel.add(varlikYonetimiButonu);
        yoneticiPanel.add(hizmetYonetimiButonu);
        yoneticiPanel.add(raporGoruntulemeButonu);
        yoneticiPanel.add(sorunYonetimiButonu);

        yoneticiPenceresi.add(yoneticiPanel);

        varlikYonetimiButonu.addActionListener(e -> varlikYonetimi());
        hizmetYonetimiButonu.addActionListener(e -> hizmetYonetimi());
        raporGoruntulemeButonu.addActionListener(e -> raporGoruntuleme());
        sorunYonetimiButonu.addActionListener(e -> sorunCozumu());

        yoneticiPenceresi.setVisible(true);
    }

    //vatandaşın yapacağı işlemleri gosteren kısım
    public void vatandasIslemleri() {
        JFrame vatandasPenceresi = new JFrame("Vatandaş İşlemleri");
        vatandasPenceresi.setSize(500, 400);
        vatandasPenceresi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel vatandasPanel = new JPanel(new GridLayout(3, 1));
        vatandasPanel.setBackground(Color.PINK); // Arka plan rengini sarı yaptık
        JButton trafikBilgisiButonu = new JButton("Trafik Durumu");
        JButton enerjiRaporButonu = new JButton("Enerji Raporları");
        JButton suDurumuButonu = new JButton("Su Rezervleri");

        vatandasPanel.add(trafikBilgisiButonu);
        vatandasPanel.add(enerjiRaporButonu);
        vatandasPanel.add(suDurumuButonu);

        vatandasPenceresi.add(vatandasPanel);




        // Trafik Durumu Butonu İşlemleri
        trafikBilgisiButonu.addActionListener(e -> {
            JFrame trafikPenceresi = new JFrame("Trafik Durumu");
            trafikPenceresi.setSize(400, 300);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);

            // Araç listesinde yer alan trafik bilgileri burada görüntülenebilir
            if (aracListesi.isEmpty()) {
                textArea.setText("Kayıtlı araç bulunmamaktadır.");
            } else {
                StringBuilder trafikBilgileri = new StringBuilder("Trafik Durumu:\n");

                int aracSayisi = aracListesi.size(); // Araç listesindeki araç sayısı

                for (String arac : aracListesi) {
                    trafikBilgileri.append(arac).append("\n");
                }

                // Yoğunluk bilgisi ekliyoruz
                if (aracSayisi > 5) {
                    trafikBilgileri.append("\nYoğunluk Durumu: Trafik yoğunluğu yüksek!\n");
                } else if (aracSayisi > 0) {
                    trafikBilgileri.append("\nYoğunluk Durumu: Trafik yoğunluğu normal.\n");
                } else {
                    trafikBilgileri.append("\nYoğunluk Durumu: Hiçbir araç bulunmamaktadır, trafik çok rahat.\n");
                }

                textArea.setText(trafikBilgileri.toString());
            }

            trafikPenceresi.add(new JScrollPane(textArea));
            trafikPenceresi.setVisible(true);
        });

        // Enerji Raporları Butonu İşlemleri
        enerjiRaporButonu.addActionListener(e -> {
            JFrame enerjiPenceresi = new JFrame("Enerji Raporları");
            enerjiPenceresi.setSize(400, 300);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);

            // Enerji kaynaklarının detaylı durumları burada gösteriliyor
            if (enerjiListesi.isEmpty()) {
                textArea.setText("Kayıtlı enerji kaynağı bulunmamaktadır.");
            } else {
                StringBuilder enerjiRaporlari = new StringBuilder("Enerji Raporları:\n");
                for (String enerji : enerjiListesi) {
                    enerjiRaporlari.append(enerji).append("\n");
                }
                textArea.setText(enerjiRaporlari.toString());
            }

            enerjiPenceresi.add(new JScrollPane(textArea));
            enerjiPenceresi.setVisible(true);
        });

        // Su Rezervleri Butonu İşlemleri
        suDurumuButonu.addActionListener(e -> {
            JFrame suPenceresi = new JFrame("Su Rezervleri");
            suPenceresi.setSize(400, 300);





            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);

            // Su rezervi bilgileri burada görüntüleniyor
            // Örnek bir su raporu metni eklenmiştir, bu dinamik hale getirilebilir:
            String suRezervBilgileri = "Şehirdeki Su Rezervleri:\n" +
                    "Toplam Su Rezervi: 500,000 litre\n" +
                    "Günlük Tüketim: 25,000 litre\n" +
                    "Kalan Su: 475,000 litre";

            textArea.setText(suRezervBilgileri);
            suPenceresi.add(new JScrollPane(textArea));
            suPenceresi.setVisible(true);
        });

        vatandasPenceresi.setVisible(true);
    }
}
