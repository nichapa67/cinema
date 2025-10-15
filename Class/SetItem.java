package Class;
public class SetItem {
    private String name;
    private int price;
    private String imagePath;

    public SetItem(String csvLine) {
        String[] p = csvLine.split(",", 3);
        this.name = p.length > 0 ? p[0].trim() : "";
        this.imagePath = p.length > 1 ? p[1].trim() : "";
        try {
            this.price = p.length > 2 ? Integer.parseInt(p[2].trim()) : 0;
        } catch (NumberFormatException e) {
            this.price = 0;
        }
    }

    public SetItem(String name, int price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getImagePath() { return imagePath; }

    public void setName(String name) { this.name = name; }
    public void setPrice(int price) { this.price = price; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String toCSV() {
        return name + "," + imagePath + "," + price;
    }

    public static SetItem fromCSV(String line) {
        String[] parts = line.split(",", 3);
        String name = parts[0];
        int price = Integer.parseInt(parts[1]);
        String imagePath = parts.length > 2 ? parts[2] : "";
        return new SetItem(name, price, imagePath);
    }

    public String toString() {
        return name + " (" + price + " THB)";
    }
}
