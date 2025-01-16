import java.util.Arrays;

public enum DiscountType {
    MEN_OF_NATIONAL_MERIT("국가유공자", 0.1),
    SOLDIER("군인", 0.05),
    STUDENT("학생", 0.03),
    ORDINARY("일반", 0);

    private final String job;
    private final double discountRate;

    DiscountType(String title, double discountRate) {
        this.job = title;
        this.discountRate = discountRate;
    }

    //enum 리턴
    public static DiscountType getDiscountType(int num) {
        return Arrays.stream(DiscountType.values())
                .toList()
                .get(num - 1);
    }

    //직업과 할인율 퍼센트 로그 (숫자 -> 할인율 * 100)
    public static void logDiscountType() {
        for (int i = 0; i < DiscountType.values().length; i++) {
            OrderLogger.logger.info((i + 1) + ". " + DiscountType.values()[i].job
                    + " : " + (100 * DiscountType.values()[i].discountRate) + "%");
        }
    }

    //discountRate 로 할인 적용한 가격 리턴
    public static double calculateOrderSum(double orderSum, DiscountType discountType) {
        return (double) Math.round(orderSum * (100 - discountType.discountRate * 100)) / 100;
    }
}
