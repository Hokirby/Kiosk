import MenuItems.MenuItem;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem>[] menuItems; //메뉴 리스트
    private ArrayList<MenuItem> shoppingList = new ArrayList<>();//장바구니 리스트

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

    //장바구니 담기 기능
    public void setShoppingList(MenuItem menuItem) {
        shoppingList.add(menuItem);
    }

    //장바구니 null check
    public boolean isShoppingListEmpty() {
        return (shoppingList == null) || (shoppingList.isEmpty());
    }

    //장바구니 모든 메뉴 출력 기능
    public void logSoppingList() {
        OrderLogger.logger.info("[ Orders ]");
        for (int i = 0; i < shoppingList.size(); i++) {
            OrderLogger.logger.info((i + 1) + ". " + shoppingList.get(i).toString());
        }
    }

    //잘바구나 모든 메뉴 삭제 기능
    public void clearShoppingList() {
        shoppingList.clear();
    }

    //장바구니 모든 메뉴 금액 합해 리턴
    public double getOrderSum() {
        double orderSum = 0;
        for (MenuItem menuItem : shoppingList) {
            orderSum += menuItem.getPrice();
        }
        return orderSum;
    }

}
