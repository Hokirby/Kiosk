package MenuItems;

public abstract class MenuItem {
    String name;
    double price;
    String info;
    String category = "MenuItem";

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

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name
                + " | W " + price
                + " | " + info;
    }
}
