package _240910;
public class CalculatorTest {

    public static void main(String[] args) {
        // Cal 인터페이스 타입의 객체를 cal 생성
        Cal cal = new Calculator();

        System.out.println(cal.add(10, 20));
        System.out.println(cal.subtract(20, 10));
        System.out.println(cal.times(10, 5));
        System.out.println(cal.divide(20, 2));
        System.out.println(cal.divide(20, 0));
        System.out.println(cal.circleArea(5));
        // 정적메소드 사용으로 인해 인터페이스 Cal으로 직접 호출함
        System.out.println(Cal.square(5));

    }
}