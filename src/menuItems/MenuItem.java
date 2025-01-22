package menuItems;

public abstract class MenuItem {
    private final String name;
    private final double price;
    private final String info;

    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%-15s | W %-4.1f | %s", name, price, info);
    }
}
