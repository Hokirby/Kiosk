import MenuItems.MenuItem;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem>[] menuItems; //메뉴 리스트
    private final ShoppingCart shoppingCart = new ShoppingCart();

    //메뉴 카테고리 수 설정
    public void setMenuCategories(int categoryNum) {
        menuItems = new ArrayList[categoryNum];
        for (int i = 0; i < categoryNum; i++) {
            menuItems[i] = new ArrayList<>();
        }
    }

    //리스트에 카테고리별 메뉴 객체 추가
    public void setMenuItems(int categoryNum, MenuItem menuItem) {
        menuItems[categoryNum].add(menuItem);
    }

    public ArrayList<MenuItem>[] getMenuItems() {
        return menuItems;
    }

    //콘솔창에 카테고리 출력
    public void logCategories() {
        int i = 1;
        for (ArrayList<MenuItem> list : menuItems) {
            OrderLogger.logger.info(i + ". " + list.get(0).getClass().toString().split("\\.")[1]);
            i++;
        }
    }

    //콘솔창에 카테고리 정보 출력
    public void logMenuItems(int categoryNum) {
        OrderLogger.logger.info("[ " + menuItems[categoryNum - 1].get(0).getClass().toString().split("\\.")[1] + " MENU ]");
        for (int i = 0; i < menuItems[categoryNum - 1].size(); i++) {
            OrderLogger.logger.info((i + 1) + ". " + menuItems[categoryNum - 1].get(i).toString());
        }
    }

    //메뉴 getter
    public MenuItem getMenu(int categoryNum, int orderNum) {
        return menuItems[categoryNum - 1].get(orderNum - 1);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
