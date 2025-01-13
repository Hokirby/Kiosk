import MenuItems.MenuItem;

import java.util.ArrayList;

public class Menu {
    ArrayList<MenuItem>[] menuItems;

    public void setMenuCategories(int categoryNum) {
        menuItems = new ArrayList[categoryNum];
        for (int i = 0; i < categoryNum; i++) {
            menuItems[i] = new ArrayList<>();
        }
    }

    public ArrayList<MenuItem>[] getMenuItems() {
        return menuItems;
    }

    public void logCategories() {
        int i = 1;
        for (ArrayList<MenuItem> list : menuItems) {
            OrderLogger.logger.info(i + ". " + list.get(0).getClass().toString().split("\\.")[1]);
            i++;
        }
    }

    public void logMenuItems(int categoryNum) {
        OrderLogger.logger.info("[ " + menuItems[categoryNum-1].get(0).getClass().toString().split("\\.")[1] + " MENU ]");
        for(int i = 0; i < menuItems[categoryNum -1].size(); i++) {
           OrderLogger.logger.info((i + 1) + ". " + menuItems[categoryNum-1].get(i).getName() + " | W " + menuItems[categoryNum-1].get(i).getPrice() + " | " + menuItems[categoryNum-1].get(i).getInfo());
        }
    }

    public void logMenu(int categoryNum, int orderNum) {
        OrderLogger.logger.info("선택한 메뉴: " + menuItems[categoryNum - 1].get(orderNum - 1).getName() + " | W " + menuItems[categoryNum - 1].get(orderNum - 1).getPrice() + " | " + menuItems[categoryNum - 1].get(orderNum - 1).getInfo());
    }

}
