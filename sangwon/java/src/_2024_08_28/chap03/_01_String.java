package _2024_08_28.chap03;

public class _01_String {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";
        System.out.println(s);

        // 문자열의 길이
        System.out.println(s.length());

        // 대소문자
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());

        // 포함관계
        System.out.println(s.contains("Java")); // true / false
        System.out.println(s.indexOf("Java")); // 위치정보
        System.out.println(s.indexOf("c#")); // 없으면 -1반환함
        System.out.println(s.lastIndexOf("and")); // 마지막에 일치하는 것
        System.out.println(s.startsWith("I like")); // 이 문자열로 시작하는지 true/false
        System.out.println(s.endsWith(".")); // 이 문자열로 끝나는지 true/false

    }
}
