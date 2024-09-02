package _2024_08_28.chap03;

public class _02_String2 {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";

        // 문자열 반환

        System.out.println(s.replace(" and", ","));

        System.out.println(s.substring(7)); // slice 개념
        System.out.println(s.substring(s.indexOf("Java")));
        System.out.println(s.substring(s.indexOf("Java"), s.indexOf(".")));

        s = "              I love        ";
        System.out.println(s.trim()); // 앞뒤 공백제거

        //문자열 결합
        String s1 = "Java";
        String s2 = "Python";
        System.out.println(s1 + s2);
        System.out.println(s1 + "," + s2);
        System.out.println(s1.concat(s2)); // JavaPython
        System.out.println(s1.concat(",").concat(s2)); // Java,Python
    }
}
