package _2024_09_02;

public class _01_WrapperClass {
//    기본 자료형을 참조 자료형처럼 사용하기 위함

    // 기본자료형은 실제 값을 변수에 저장
    // 참조자료형은 메모리의 주소값을 가짐

    //박싱
    // 기본자료형을 래퍼클래스로
    int x = 1;
    Integer y = Integer.valueOf(x);
//    Integer y = x; //오토박싱
    // 오토박싱은 제네릭 컬렉션에 값을 추가할때 유용
    // ArrayList<Integer> arrayList = new ArrayList<>();

    //언박싱
    // 래퍼클래스를 기본자료형으로
    int num = 20;
    Integer intObject = num; // 오토박싱
    int z = intObject;    // 언박싱 (Integer -> int)

    // 연산시 오토박싱과 언박싱이 일어나지 않도록 동일타입으로 연산되게 구현하는것이 좋음
    // 오토박싱과 언박싱이 일어날 때 내부적으로 추가 연산작업을 거쳐 성능이 떨어짐

    // 래퍼클래스 동등비교시
    // == 사용시 값을 비교하는게 아닌 객체의 주소값을 비교
    // equals() 메소드를 통해 비교하는 것이 좋음
}
