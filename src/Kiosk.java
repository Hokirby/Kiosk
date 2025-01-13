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
            OrderLogger.logger.info("[ SHAKESHACK MENU ]");
            menu.logCategories();
            OrderLogger.logger.info("0. 종료\t| 종료");
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
            if (menu.getMenuItems().length < categoryNum) { //입력 정보가 존재하는 카테고리 수 보다 큰 수일 경우 예외처리
                OrderLogger.logger.info("Invalid Number");
                continue;
            }
            menu.logMenuItems(categoryNum);
            OrderLogger.logger.info("0. 뒤로가기");
            int orderNum = sc.nextInt();
            if (orderNum == 0) {
                continue;
            }
            menu.logMenu(categoryNum, orderNum);
        }
    }
}
