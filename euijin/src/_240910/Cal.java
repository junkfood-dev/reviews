package _240910;

public interface Cal {
    double PI = Math.PI;  // 원주율 -> 상수
    int ERROR = -99999999;

    // 추상 메소드 사용
    int add(int num1, int num2);
    int subtract(int num1, int num2);
    int times(int num1, int num2);
    int divide(int num1, int num2);

    // default 메소드 사용 -> 구현하고 있는 클래스에 수정 X
    default double circleArea(double r) {
        return PI * r * r;
    }

    // 정적 메소드 사용 -> 인스턴스가 아닌 인터페이스의 이름으로 직접 호출
    static int square(int num1) {
        return num1 * num1;
    }
}
