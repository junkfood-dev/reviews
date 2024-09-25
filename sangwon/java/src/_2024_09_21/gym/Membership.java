package _2024_09_21.gym;

import java.time.LocalDate;

public class Membership {
    String type;
    int price;
    LocalDate startDate;
    LocalDate endDate;

    Membership(String type, int price, LocalDate startDate){
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.endDate = calculateEndDate(type, startDate);
    }

    // 회원권 종료일 자동 계산
    private LocalDate calculateEndDate(String type, LocalDate startDate) {
        switch (type) {
            case "일간권":
                return startDate.plusDays(1);
            case "월간권":
                return startDate.plusMonths(1);
            case "연간권":
                return startDate.plusYears(1);
            default:
                throw new IllegalArgumentException(type + "은 없는 회원권 입니다.");
        }
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}