package _2024_09_03;

class Foo {
    public static String classVar = "I class var";
    public String instanceVar = "I instance var";
    public static void classMethod() {
        System.out.println(classVar);
//        System.out.println(instanceVar); // 에러
    }
    public void instanceMethod() {
        System.out.println(classVar);
        System.out.println(instanceVar);
    }
}

public class StaticApp {
    public static void main(String[] args) {
        System.out.println(Foo.classVar);
//        System.out.println(Foo.instanceVar); // 에러
        Foo.classMethod();
//        Foo.instanceMethod(); // 에러

        Foo f1 = new Foo();
        Foo f2 = new Foo();

        System.out.println(f1.classVar); // I class var
        System.out.println(f1.instanceVar); // I instance var

        f1.classVar = "changed by f1";
        System.out.println(Foo.classVar); // changed by f1
        System.out.println(f2.classVar); // changed by f1

        f1.instanceVar = "changed by f1";
        System.out.println(f1.instanceVar); // changed by f1
        System.out.println(f2.instanceVar); // I instance var
    }
}

// static이 있으면 클래스 소속 없으면 인스턴스 소속
// 인스턴스는 실제 값을 가지지않고, 클래스를 가르킨다.
// 클래스의 값을 바꾸면 인스턴스의 값이 바뀐다.
// 인스턴스는 클래스의 복제값이라 클래스에 영향을안줌.
