package MenuItems;

public abstract class MenuItem {
    String name;
    double price;
    String info;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }
}
