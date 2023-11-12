package christmas.ui;

public class OutputView {
    public void printIntro() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        // ...
    }

    public void printEventDate(int day) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", day);
        // ...
    }

    public void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }

    public void printTotalRawPrice() {
        System.out.println("<할인 전 총주문 금액>");
        // ...
    }

    public void printGiftMenu() {
        System.out.println("<증정 메뉴>");
        // ...
    }

    public void printBenefits() {
        System.out.println("<혜택 내역>");
        // ...
    }

    public void printTotalBenefitPrice() {
        System.out.println("<총헤택 금액>");
        // ...
    }

    public void printTotalDiscountedPrice() {
        System.out.println("<할인 후 예상 결제 금액>");
        // ...
    }

    public void printEventBadge() {
        System.out.println("<12월 이벤트 배지>");
        // ...
    }

}
