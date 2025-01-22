import menuItems.Burgers;
import menuItems.Deserts;
import menuItems.Drinks;
import menuItems.MenuType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setMenuCategories();
        menu.setMenuItems(MenuType.Burgers, List.of(
                new Burgers("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new Burgers("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new Burgers("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new Burgers("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
        ));
        menu.setMenuItems(MenuType.Drinks, List.of(
                new Drinks("Coke", 1.5, "콜라"),
                new Drinks("ZeroCoke", 2.0, "제로 콜라"),
                new Drinks("MineralWater", 1.0, "생수")
        ));
        menu.setMenuItems(MenuType.Deserts, List.of(
                new Deserts("IceCream", 0.5, "바닐라 아이스크림"),
                new Deserts("Tornado", 2.5, "초콜릿 시럽이 뿌려진 바닐라 아이스크림")
        ));
        OrderLogger.formatLogger();
        Kiosk k = new Kiosk(menu);
        k.start();
    }
}