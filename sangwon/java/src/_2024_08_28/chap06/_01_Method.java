package _2024_08_28.chap06;

public class _01_Method {
    // 메소드 정의
    public static void sayHello() {
        System.out.println("안녕하세요? Method입니다.");
    }

    public static void main(String[] args) {
        // 메소드(함수) 호출
        System.out.println("메소드 호출 전");
        sayHello();
        sayHello();
        sayHello();
        System.out.println("메소드 호출 후");
    }
}
