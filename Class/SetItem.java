package Class;

public class SetItem {
    private String name;
    private String imagePath;
    private int price;

    public SetItem(String name, String imagePath, int price) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
    }

    public String getName() { return name; }
    public String getImagePath() { return imagePath; }
    public int getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + price + " THB)";
    }
}

/*public class SetItem {
    private String name;
    private int price;
    private String imagePath; // เพิ่มฟิลด์ใหม่

    // Constructor ใหม่ (3 พารามิเตอร์)
    public SetItem(String name, int price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }

    // Constructor เดิม (เผื่อโค้ดอื่นเรียกใช้)
    public SetItem(String name, int price) {
        this(name, price, null);
    }

    public String getName() { return name; }
    public int getPrice() { return price; }

    // Getter สำหรับ path ของรูป
    public String getImagePath() { return imagePath; }

    @Override
    public String toString() {
        return name + " (" + price + " THB)";
    }
}*/
