public class Vatandas {
    public String ad;

    public Vatandas(String ad) {
        this.ad = ad;
    }

    public void trafikBilgisiAl() {
        System.out.println(ad + " trafik yoğunluğu bilgisini aldı.");
    }

    public void enerjiRaporuGoruntule() {
        System.out.println(ad + " şehirdeki enerji durumu raporunu görüntülüyor.");
    }

    @Override
    public String toString() {
        return "Vatandaş: " + ad;
    }
}

