package MenuItems;

public class Drinks extends MenuItem {
    String name;
    double price;
    String info;

    public Drinks(String name, double price, String info) {
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

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return name
                + " | W " + price
                + " | " + info;
    }
}
