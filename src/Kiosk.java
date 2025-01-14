import java.util.Scanner;

public class Kiosk {
    private final Menu menu; //캡슐화

    Kiosk(Menu menu) {
        this.menu = menu;
    }

    public int validateInputNumber(int min, int max, String input) throws IllegalArgumentException {
        String regex = "^[" + min + "-" + max + "]$"; // 정규식: min~max 한 자리 숫자만 허용
        if (input.matches(regex)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("Invalid Input");
            throw new IllegalArgumentException("");
        }
    }

    //키오스크 프로그램 실행
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                OrderLogger.logger.info("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                OrderLogger.logger.info("[ SHAKESHACK MENU ]");
                menu.logCategories();
                OrderLogger.logger.info("0. 종료\t| 종료");
                if (!(menu.getShoppingCart().isShoppingListEmpty())) {
                    OrderLogger.logger.info("[ ORDER MENU ]");
                    OrderLogger.logger.info("4. Orders\t\t| 장바구니 확인 후 주문합니다.");
                    OrderLogger.logger.info("5. Cancel\t\t| 진행중인 주문을 취소합니다.");
                }
                int categoryNum = validateInputNumber(0, 5, sc.nextLine());
                if (categoryNum == 0) {
                    OrderLogger.logger.info("프로그램을 종료합니다.");
                    System.exit(0);
                }
                if (menu.getShoppingCart().isShoppingListEmpty() && menu.getMenuItems().length < categoryNum) { //장바구니가 비어있고 입력 정보가 존재하는 카테고리 수 보다 큰 수일 경우 예외처리
                    OrderLogger.logger.info("Invalid Number");
                    continue;
                } else if (categoryNum == 4) {
                    OrderLogger.logger.info("아래와 같이 주문하시겠습니까?");
                    menu.getShoppingCart().logSoppingList();
                    OrderLogger.logger.info("[ Total ]\nW " + menu.getShoppingCart().getOrderSum());
                    OrderLogger.logger.info("1. 주문\t\t2. 메뉴판");
                    int completeNum = validateInputNumber(1, 2, sc.nextLine());
                    if (completeNum == 1) {
                        OrderLogger.logger.info("주문이 완료되었습니다. 금액은 W " + menu.getShoppingCart().getOrderSum() + " 입니다.");
                        menu.getShoppingCart().clearShoppingList();
                        continue;
                    } else if (completeNum == 2) {
                        continue;
                    }
                } else if (categoryNum == 5) {
                    menu.getShoppingCart().clearShoppingList();
                }
                menu.logMenuItems(categoryNum);
                OrderLogger.logger.info("0. 뒤로가기");
                int orderNum = validateInputNumber(0, 3, sc.nextLine());
                if (orderNum == 0) {
                    continue;
                }
                OrderLogger.logger.info("선택하신 메뉴: " + menu.getMenu(categoryNum, orderNum).toString());
                OrderLogger.logger.info("\"" + menu.getMenu(categoryNum, orderNum).toString() + "\"");
                OrderLogger.logger.info("위 메뉴를 장바구니에 추가하시겠습니까?");
                OrderLogger.logger.info("1. 확인\t\t2. 취소");
                int confirmNum = validateInputNumber(1, 2, sc.nextLine());
                if (confirmNum == 1) {
                    menu.getShoppingCart().setShoppingList(menu.getMenu(categoryNum, orderNum));
                    OrderLogger.logger.info(menu.getMenu(categoryNum, orderNum).getName() + " 이/가 장바구니에 추가되었습니다.");
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}
