import MenuItems.MenuItem;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<MenuItem> shoppingList = new ArrayList<>();//장바구니 리스트

    //장바구니 담기 기능
    public void setShoppingList(MenuItem menuItem) {
        shoppingList.add(menuItem);
    }

    //장바구니 null check
    public boolean isShoppingListEmpty() {
        return (shoppingList == null) || (shoppingList.isEmpty());
    }

    //장바구니 모든 메뉴 출력 기능
    public void logShoppingList() {
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
