public class SuYonetimi {
    public int suSeviyesi;

    public SuYonetimi(int suSeviyesi) {
        this.suSeviyesi = suSeviyesi;
    }

    public void suSeviyesiniKontrolEt() throws DusukSu {
        if (suSeviyesi < 10) {
            throw new DusukSu("Su rezerv seviyesi kritik seviyede! Rezervleri artırın.");
        }
    }

    @Override
    public String toString() {
        return "Su Seviyesi: " + suSeviyesi + " birim";
    }
}

