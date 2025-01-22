import menuItems.MenuItem;
import menuItems.MenuType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {
    private final ShoppingCart shoppingCart = new ShoppingCart();
    private final HashMap<MenuType, List<MenuItem>> menuItems = new HashMap<>(); //메뉴 리스트

    //메뉴 카테고리 수 설정
    public void setMenuCategories() {
        for (int i = 0; i < MenuType.values().length - 1; i++) {
            menuItems.put(MenuType.values()[i + 1], new ArrayList<MenuItem>());
        }
    }

    //리스트에 카테고리별 메뉴 객체 추가
    public void setMenuItems(MenuType menuType, List<MenuItem> list) {
        menuItems.put(menuType, list);
    }

    public HashMap<MenuType, List<MenuItem>> getMenuItems() {
        return menuItems;
    }

    //콘솔창에 카테고리 출력
    public void printCategories() {
        for (int i = 0; i < MenuType.values().length; i++) {
            OrderLogger.logger.info((i + 1) + ". " + MenuType.values()[i]);
        }
    }

    //콘솔창에 카테고리 정보 출력
    public void printMenuItems(int categoryNum) {
        OrderLogger.logger.info("[ " + MenuType.values()[categoryNum - 1] + " MENU ]");
        int i = 1;
        for (MenuItem menuItem : menuItems.get(MenuType.values()[categoryNum - 1])) {
            OrderLogger.logger.info(((i++) + ". " + menuItem.toString()));
        }
    }

    //메뉴 getter
    public MenuItem getMenu(int categoryNum, int orderNum) {
        return menuItems.get(MenuType.values()[categoryNum - 1]).get(orderNum - 1);
    }

    //카테고리 getter
    public List<MenuItem> getCategory(int categoryNum) {
        return menuItems.get(MenuType.values()[categoryNum - 1]);
    }

    //ShoppingCart 객체 getter
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
