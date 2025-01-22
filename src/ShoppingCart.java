import menuItems.MenuItem;

import java.util.HashMap;
import java.util.Map.Entry;

public class ShoppingCart {
    private final HashMap<MenuItem, Integer> shoppingCart = new HashMap<>();//장바구니

    //장바구니 담기 기능
    public void addToShoppingCart(MenuItem menuItem) {
        if (shoppingCart.containsKey(menuItem)) {
            shoppingCart.put(menuItem, shoppingCart.get(menuItem) + 1);
        } else {
            shoppingCart.put(menuItem, 1);
        }
    }

    //장바구니 null check
    public boolean isShoppingCartEmpty() {
        return shoppingCart.isEmpty();
    }

    //장바구니 모든 메뉴 출력 기능
    public void printShoppingList() {
        OrderLogger.logger.info("[ Orders ]");
        shoppingCart.entrySet()
                .forEach(entry -> OrderLogger.logger.info(entry.getValue() + " | " + entry.getKey().toString()));
    }

    //장바구니 상품 제거 기능
    public void removeShoppingMenu(String name) {
        shoppingCart.remove(shoppingCart.keySet().stream()
                .filter(key -> key.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow());
    }

    //장바구나 모든 메뉴 삭제 기능
    public void clearShoppingList() {
        shoppingCart.clear();
    }

    //장바구니 모든 메뉴 금액 합해 리턴
    public double getOrderSum() {
        double orderSum = 0;
        for (Entry<MenuItem, Integer> entry : shoppingCart.entrySet()) {
            orderSum += entry.getKey().getPrice() * entry.getValue();
        }
        return (double) Math.round(orderSum * 10) / 10;
    }
}
