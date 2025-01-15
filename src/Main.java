import MenuItems.Burgers;
import MenuItems.Deserts;
import MenuItems.Drinks;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setMenuCategories(3);
        Burgers burger1 = new Burgers("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        Burgers burger2 = new Burgers("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        Burgers burger3 = new Burgers("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        Burgers burger4 = new Burgers("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        menu.setMenuItems(0, burger1);
        menu.setMenuItems(0, burger2);
        menu.setMenuItems(0, burger3);
        menu.setMenuItems(0, burger4);
        Drinks drink1 = new Drinks("Coke", 1.5, "콜라");
        Drinks drink2 = new Drinks("ZeroCoke", 2.0, "제로 콜라");
        Drinks drink3 = new Drinks("MineralWater", 1.0, "생수");
        menu.setMenuItems(1, drink1);
        menu.setMenuItems(1, drink2);
        menu.setMenuItems(1, drink3);
        Deserts desert1 = new Deserts("IceCream", 0.5, "바닐라 아이스크림");
        Deserts deserts2 = new Deserts("Tornado", 2.5, "초콜릿 시럽이 뿌려진 바닐라 아이스크림");
        menu.setMenuItems(2, desert1);
        menu.setMenuItems(2, deserts2);
        OrderLogger.formatLogger();
        Kiosk k = new Kiosk(menu);
        k.start();
    }
}