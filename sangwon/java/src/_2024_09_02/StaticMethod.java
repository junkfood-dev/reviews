package _2024_09_02;

class Print{
    public String delimiter;

    public void a() {
        System.out.println(this.delimiter);
        System.out.println("a");
        System.out.println("a");
    }
    public void b() {
        System.out.println(this.delimiter);
        System.out.println("b");
        System.out.println("b");
    }
    public static void c(String delimiter){
        System.out.println(delimiter);
        System.out.println("b");
        System.out.println("b");
    }
}
public class StaticMethod {
    public static void main(String[] args) {
        // instance 소속이면 static 제거
        // 클래스소속이면 static 사용

//        Print.a("-");
//        Print.b("-");
        Print t1 = new Print();
        t1.delimiter = "-";
        t1.a();
        t1.b();
        Print.c("$");

//        Print.a("*");
//        Print.b("*");
        Print t2 = new Print();
        t2.delimiter = "*";
        t2.a();
        t2.b();
    }
}
