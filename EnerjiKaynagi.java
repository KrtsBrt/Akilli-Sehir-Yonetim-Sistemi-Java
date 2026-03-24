public class EnerjiKaynagi {
    private String type; // Enerji türü (Güneş, Rüzgar, Nükleer, Fosil Yakıt)
    private int capacity; // Kapasite (günlük üretim kW)
    private int consumption; // Günlük tüketim (kW)

    // Constructor (Yapıcı metot)
    public EnerjiKaynagi(String type, int capacity, int consumption) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Kapasite pozitif bir değer olmalıdır!");
        }
        this.type = type;
        this.capacity = capacity;
        this.consumption = consumption; // Varsayılan tüketim
    }

    // Günlük tüketim değerini güncelle
    public void updateConsumption(int consumption) {
        if (consumption < 0) {
            throw new IllegalArgumentException("Tüketim negatif olamaz!");
        }
        this.consumption = consumption;
    }

    // Üretimden fazla tüketim olup olmadığını kontrol et
    public boolean isOverloaded() {
        return consumption > capacity;
    }

    // Getter ve Setter metodları
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Kapasite pozitif bir değer olmalıdır!");
        }
        this.capacity = capacity;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        updateConsumption(consumption);
    }

    @Override
    public String toString() {
        return "EnergySource{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity + " kW" +
                ", consumption=" + consumption + " kW" +
                ", overloaded=" + (isOverloaded() ? "Evet" : "Hayır") +
                '}';
    }
}

