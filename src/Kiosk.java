import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    private final Menu menu; //캡슐화

    Kiosk(Menu menu) {
        this.menu = menu;
    }

    //키오스크 프로그램 실행
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            OrderLogger.logger.info("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
            OrderLogger.logger.info("[ SHAKESHACK MENU ]");
            menu.logCategories();
            OrderLogger.logger.info("0. 종료\t| 종료");
            if (!(menu.isShoppingListEmpty())) {
                OrderLogger.logger.info("[ ORDER MENU ]");
                OrderLogger.logger.info("4. Orders\t\t| 장바구니 확인 후 주문합니다.");
                OrderLogger.logger.info("5. Cancel\t\t| 진행중인 주문을 취소합니다.");
            }
            int categoryNum;
            try {
                categoryNum = sc.nextInt();
            } catch (InputMismatchException e) { //입력 정보가 int 타입이 아닐경우 예외처리
                OrderLogger.logger.info("Invalid Input");
                sc.nextLine();
                continue;
            }
            if (categoryNum == 0) {
                OrderLogger.logger.info("프로그램을 종료합니다.");
                System.exit(0);
            }
            if (menu.isShoppingListEmpty() && menu.getMenuItems().length < categoryNum) { //장바구니가 비어있고 입력 정보가 존재하는 카테고리 수 보다 큰 수일 경우 예외처리
                OrderLogger.logger.info("Invalid Number");
                continue;
            } else if (categoryNum == 4) {
                OrderLogger.logger.info("아래와 같이 주문하시겠습니까?");
                menu.logSoppingList();
                OrderLogger.logger.info("[ Total ]\nW " + menu.getOrderSum());
                OrderLogger.logger.info("1. 주문\t\t2. 메뉴판");
                int completeNum;
                try {
                    completeNum = sc.nextInt();
                } catch (InputMismatchException e) { //입력 정보가 int 타입이 아닐경우 예외처리
                    OrderLogger.logger.info("Invalid Input");
                    continue;
                }
                if (completeNum == 1) {
                    OrderLogger.logger.info("주문이 완료되었습니다. 금액은 W " + menu.getOrderSum() + " 입니다.");
                    menu.clearShoppingList();
                    continue;
                } else if (completeNum == 2) {
                    continue;
                } else { //입력 정보가 유효하지 않은 숫자일 경우 예외처리
                    OrderLogger.logger.info("Invalid Number");
                    continue;
                }
            } else if (categoryNum == 5) {
                menu.clearShoppingList();
            }
            menu.logMenuItems(categoryNum);
            OrderLogger.logger.info("0. 뒤로가기");
            int orderNum = sc.nextInt();
            if (orderNum == 0) {
                continue;
            }
            OrderLogger.logger.info("선택하신 메뉴: " + menu.getMenu(categoryNum, orderNum).toString());
            OrderLogger.logger.info("\"" + menu.getMenu(categoryNum, orderNum).toString() + "\"");
            OrderLogger.logger.info("위 메뉴를 장바구니에 추가하시겠습니까?");
            OrderLogger.logger.info("1. 확인\t\t2. 취소");
            int confirmNum;
            try {
                confirmNum = sc.nextInt();
            } catch (InputMismatchException e) {
                OrderLogger.logger.info("Invalid Input");
                continue;
            }
            if (2 < confirmNum) {
                OrderLogger.logger.info("Invalid Number");
                continue;
            }
            if (confirmNum == 1) {
                menu.setShoppingList(menu.getMenu(categoryNum, orderNum));
                OrderLogger.logger.info(menu.getMenu(categoryNum, orderNum).getName() + " 이/가 장바구니에 추가되었습니다.");
            }


        }
    }
}
