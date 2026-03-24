public class Arac {
    private String type; // Araç tipi (Otobüs, Otomobil, Motosiklet, Elektrikli Araç)
    private int capacity; // Kapasite (örneğin yolcu kapasitesi)
    private boolean isElectric; // Elektrikli araç olup olmadığını belirtir
    private int batteryLevel; // Eğer araç elektrikli ise batarya seviyesi (% 0-100)

    // Constructor (Yapıcı metot)
    public Arac(String type, int capacity, boolean isElectric) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Araç kapasitesi pozitif bir değer olmalıdır!");
        }
        this.type = type;
        this.capacity = capacity;
        this.isElectric = isElectric;
        this.batteryLevel = isElectric ? 100 : -1; // Elektrikli araçlar başlangıçta %100 şarjlı
    }

    // Şarj seviyesi güncelleme (Sadece elektrikli araçlar için)
    public void updateBatteryLevel(int batteryLevel) {
        if (!isElectric) {
            throw new UnsupportedOperationException("Bu araç elektrikli değil, batarya seviyesi ayarlanamaz!");
        }
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException("Batarya seviyesi 0 ile 100 arasında olmalıdır!");
        }
        this.batteryLevel = batteryLevel;
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

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
    @Override
    public String toString() {


        return "Vehicle{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                ", isElectric=" + isElectric +
                (isElectric ? ", batteryLevel=" + batteryLevel + "%" : "") +
                '}';
    }
}

