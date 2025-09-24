package Class;
public class SetItem {
    private String name;
    private int price;

    public SetItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }

    public String toString() {
        return name + " (" + price + " THB)";
    }
}