import menuItems.MenuType;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Kiosk {
    private final Menu menu; //캡슐화

    Kiosk(Menu menu) {
        this.menu = menu;
    }

    public int validateInputNumber(int min, int max, String input) throws IllegalArgumentException {
        String regex = "^[" + min + "-" + max + "]$"; // 정규식: min ~ max 한 자리 숫자만 허용
        if (input.matches(regex)) {
            return Integer.parseInt(input);
        } else {
            OrderLogger.logger.info("Invalid Input");
            throw new IllegalArgumentException("");
        }
    }

    // 장바구니가 비어있고 입력 정보가 존재하는 카테고리 수 보다 큰 경우
    private boolean validateCategoryNum(Menu menu, int categoryNum) {
        return menu.getShoppingCart().isShoppingCartEmpty() && MenuType.values().length < categoryNum;
    }

    //키오스크 프로그램 실행
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                OrderLogger.logger.info("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                OrderLogger.logger.info("[ SHAKESHACK MENU ]");
                menu.printCategories();
                OrderLogger.logger.info("0. 종료\t| 종료");
                if (!(menu.getShoppingCart().isShoppingCartEmpty())) {
                    OrderLogger.logger.info("[ ORDER MENU ]");
                    OrderLogger.logger.info("4. Orders\t\t| 장바구니 확인 후 주문합니다.");
                    OrderLogger.logger.info("5. Cancel\t\t| 진행중인 주문을 취소합니다.");
                }
                int categoryNum = validateInputNumber(0, 5, sc.nextLine());
                if (categoryNum == 0) {
                    OrderLogger.logger.info("프로그램을 종료합니다.");
                    System.exit(0);
                }
                if (validateCategoryNum(menu, categoryNum)) { //장바구니가 비어있고 입력 정보가 존재하는 카테고리 수 보다 큰 수일 경우 예외처리
                    OrderLogger.logger.info("Invalid Number");
                    continue;
                } else if (categoryNum == 4) {
                    OrderLogger.logger.info("아래와 같이 주문하시겠습니까?");
                    menu.getShoppingCart().printShoppingList();
                    OrderLogger.logger.info("[ Total ]\nW " + menu.getShoppingCart().getOrderSum());
                    OrderLogger.logger.info("1. 주문\t\t2. 메뉴판\t\t3. 상품 제거");
                    int completeNum = validateInputNumber(1, 3, sc.nextLine());
                    if (completeNum == 1) {
                        OrderLogger.logger.info("할인 정보를 입력해주세요");
                        DiscountType.logDiscountType();
                        int discountNum = validateInputNumber(1, DiscountType.values().length + 1, sc.nextLine());
                        OrderLogger.logger.info("주문이 완료되었습니다. 금액은 W "
                                + DiscountType.calculateOrderSum(menu.getShoppingCart().getOrderSum(), DiscountType.getDiscountTypeByIndex(discountNum - 1))
                                + " 입니다.");
                        menu.getShoppingCart().clearShoppingList();
                        continue;
                    } else if (completeNum == 3) {
                        OrderLogger.logger.info("제거할 상품의 이름을 영어로 입력해주세요.");
                        String name = sc.nextLine();
                        menu.getShoppingCart().removeShoppingMenu(name);
                        OrderLogger.logger.info("입력하신 " + name + "이/가 성공적으로 제거되었습니다");
                        continue;
                    } else if (completeNum == 2) {
                        continue;
                    }
                } else if (categoryNum == 5) {
                    menu.getShoppingCart().clearShoppingList();
                }
                menu.printMenuItems(categoryNum);
                OrderLogger.logger.info("0. 뒤로가기");
                int orderNum = validateInputNumber(0, menu.getCategory(categoryNum).size(), sc.nextLine());
                if (orderNum == 0) {
                    continue;
                }
                OrderLogger.logger.info("선택하신 메뉴: " + menu.getMenu(categoryNum, orderNum).toString());
                OrderLogger.logger.info("\"" + menu.getMenu(categoryNum, orderNum).toString() + "\"");
                OrderLogger.logger.info("위 메뉴를 장바구니에 추가하시겠습니까?");
                OrderLogger.logger.info("1. 확인\t\t2. 취소");
                int confirmNum = validateInputNumber(1, 2, sc.nextLine());
                if (confirmNum == 1) {
                    menu.getShoppingCart().addToShoppingCart(menu.getMenu(categoryNum, orderNum));
                    OrderLogger.logger.info(menu.getMenu(categoryNum, orderNum).getName() + " 이/가 장바구니에 추가되었습니다.");
                }
            } catch (IllegalArgumentException e) {
                continue;
            } catch (NoSuchElementException e) {
                OrderLogger.logger.info("Value Not Found");
            }
        }
    }
}
