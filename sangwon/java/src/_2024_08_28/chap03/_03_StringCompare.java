package _2024_08_28.chap03;

public class _03_StringCompare {
    public static void main(String[] args) {
        //문자열 비교
        String s1 = "Java";
        String s2 = "Python";

        System.out.println(s1.equals("s2")); // 서로의 문자열이 같으면 true
        System.out.println(s1.equals("java")); // 대소문자 달라서 false
        System.out.println(s1.equalsIgnoreCase("java")); // 대소문자 구분안함

        // 여기서 s1 s2 가 참조하는 공간이 같음
        s1 = "1234";
        s2 = "1234";
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1 == s2); // true

        // new 를 붙이면 새로운 공간을 생성
        s1 = new String("1234");
        s2 = new String("1234");
        System.out.println(s1.equals(s2)); // ture
        System.out.println(s1 == s2); // false

        //문자열의 비교에서는 ==보다는 equals 를 사용하자
    }
}
