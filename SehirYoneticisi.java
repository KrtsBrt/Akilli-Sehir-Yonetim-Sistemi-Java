public class SehirYoneticisi {
    public String ad;

    public SehirYoneticisi(String ad) {
        this.ad = ad;
    }

    public void yeniVarlikEkle() {
        System.out.println(ad + " yeni bir varlık ekledi.");
    }

    public void hizmetRaporuAl() {
        System.out.println(ad + " şehir hizmetleri raporunu görüntülüyor.");
    }

    @Override
    public String toString() {
        return "Şehir Yöneticisi: " + ad;
    }
}
