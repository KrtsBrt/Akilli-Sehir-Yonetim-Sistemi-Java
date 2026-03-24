public class TrafikYonetimi {
    public int bolgedekiAracSayisi;

    public TrafikYonetimi(int bolgedekiAracSayisi) {
        this.bolgedekiAracSayisi = bolgedekiAracSayisi;
    }

    public void trafikDurumunuKontrolEt() throws TrafikSikisikligi {
        if (bolgedekiAracSayisi > 25) {
            throw new TrafikSikisikligi("Trafik sıkışıklığı tespit edildi! Bölgede 25'ten fazla araç var.");
        }
    }

    @Override
    public String toString() {
        return "Bölgedeki Araç Sayısı: " + bolgedekiAracSayisi;
    }
}

