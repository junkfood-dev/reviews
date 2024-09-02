package _2024_09_02;

class Greeting {
    // public, protected, default, private
    // public 모든 접근 허용
    // protected 상속받은 클래스 또는 같은 패키지에서만
    // default 기본 제한자, 자신 클래스 내부와 같은 패키지내에서만
    // private 외부접근 X / 같은클래스내에서만
    public static void hi() {
        System.out.println("Hi");
    }
}
public class AccessLevelModifiersMethod {
    public static void main(String[] args) {
        Greeting.hi();
    }
}
