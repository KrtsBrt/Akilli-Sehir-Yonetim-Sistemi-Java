public class Bina {
    private String type; // Bina tipi (Akıllı Bina veya Geleneksel Bina)
    private int floors; // Kat sayısı
    private int energyEfficiency; // Enerji verimliliği (% 0-100)

    // Constructor (Yapıcı metot)
    public Bina(String type, int floors, int energyEfficiency) {
        if (energyEfficiency < 0 || energyEfficiency > 100) {
            throw new IllegalArgumentException("Enerji verimliliği 0 ile 100 arasında olmalıdır!");
        }
        this.type = type;
        this.floors = floors;
        this.energyEfficiency = energyEfficiency;
    }

    // Getter ve Setter metodları
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        if (floors <= 0) {
            throw new IllegalArgumentException("Kat sayısı pozitif bir değer olmalıdır!");
        }
        this.floors = floors;
    }

    public int getEnergyEfficiency() {
        return energyEfficiency;
    }

    public void setEnergyEfficiency(int energyEfficiency) {
        if (energyEfficiency < 0 || energyEfficiency > 100) {
            throw new IllegalArgumentException("Enerji verimliliği 0 ile 100 arasında olmalıdır!");
        }
        this.energyEfficiency = energyEfficiency;
    }

    @Override
    public String toString() {
        return "Building{" +
                "type='" + type + '\'' +
                ", floors=" + floors +
                ", energyEfficiency=" + energyEfficiency + "%}";
    }
}

