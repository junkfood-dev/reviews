package _2024_09_10;

public class TodayStudy {
    // 인터페이스(interface) : 구현
    // 선언: public interface 인터페이스명 {추상메소드}
    // 참조변수로 사용가능
    // 구현해야 할 공통 기능들을 '껍데기'만 정의 해놓은 타입
    // 추상메소드만 들어갈 수 있음.
    // 구현할 클래스에서 반드시 인터페이스의 추상메소드를 구현해야함.
    // 접근제어자 class implements 인터페이스명 {}
    // 상속과 다르게 implements ..., ..., ..., 여러개 가능
    // 다형성 - 인터페이스를 타입으로 선언가능
    // 유연한 확장 - 새로운 코드를 추가하더라도, 코드의 구조를 크게 바꾸지 않고도 확장할 수 있다
    // 중요클래스를 작성하는 시점에 종류가 얼마나 늘어날지 알수 없으므로, 인터페이스정의하고 인터페이스 기준으로 메소드 작성
    // 객체 타입 확인 (true/false) -> instanceof


    // 추상클래스(abstract class) vs 인터페이스(interface)

    // 추상클래스는
    // 다중상속 불가
    // 필드, 생성자, 메소드 모두 가질수 있음

    // 인터페이스는
    // 다중구현/상속 가능 public interface InterfaceC extends InterfaceA, InterfaceB {}
    // 필드- 상수값만 가질 수 있음.(static final)
    // 추상메소드와 default메소드만 가질수있음.
    // 필드 추상메소드 public만 가능

    // default 메소드
    // 인터페이스의 메소드는 구현체를 가질수 없지만, 실제 구현된 형태의 메소드를 가질 수 있게 됨
}