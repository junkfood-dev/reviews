package _240910;

public class ImplementsTest {
    public static void main(String[] args) {
//        Implements obj = new Implements();

    /* InterfaceC 의 타입으로 객체 생성 , 위와 같은 결과 -> 다형성
    InterfaceC obj = new Implements();
     이렇게 하는 이유?
      - 나중에 새로운 클래스(Implements2)로 InterfaceC를 구현하려 할 때
      InterfaceC obj2 = new Implements2();를 했을때
      obj.methodA();  // "A메소드"
      obj.methodA();  // "Implements2의 A메소드"
      --> 코드의 유연성 증가
     */
        //인텔리제이가
        //InterfaceA interA = obj;
        //interA.methodA();를 계속
        //((InterfaceA) obj).methodA(); 로 바꾸려고 하는데 왜그런지 모르겠음

//        InterfaceA interA = obj;     // Implements obj = new Implements(); , InterfaceA interA로 해서
                                       // 각 인터페이스의 접근범위 보려고하는데 불필요한 변수라고 커밋안되게함 ㅡㅡ
//        interA.methodA();     // A메소드
//        // interA.methodB();  // 접근불가
//        // interA.methodC();  // 접근불가
//        System.out.println("---------------");
//
//        InterfaceB interB = obj;

//        // interB.methodA();  // 접근불가
//        interB.methodB();     // B메소드
//        // interB.methodC();  // 접근불가
//        System.out.println("---------------");
//
//        InterfaceC interC = obj;

//        interC.methodA();     // A메소드
//        interC.methodB();     // B메소드
//        interC.methodC();     // C메소드
        // interfaceA interA가 불필요한
    }
}