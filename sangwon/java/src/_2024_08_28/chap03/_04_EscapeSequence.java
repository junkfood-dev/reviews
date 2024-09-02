package _2024_08_28.chap03;

public class _04_EscapeSequence {
    public static void main(String[] args) {
        // 특수문자, 이스케이프 문자
        // \n \t \\ \" \'

        System.out.println("자바가");
        System.out.println("너무");
        System.out.println("재밌어요");

        // \n 줄바꿈
        System.out.println("자바가\n너무\n재밌어요");

        // \t 탭만큼 띄어쓰기 (정렬할때)
        System.out.println("해물파전\t9000원");
        System.out.println("김치전\t8000원");
        System.out.println("감자전\t7000원");

        // 경로를 표현할때 \\ 써야 (\)로 표시됨
        System.out.println("D:\\Program Files\\Java"); // D:\Program Files\Java

        // \" 과 \' 문자열 내에 따옴표 표시할때 사용
        System.out.println("호두가 \"냐용\"이라고 함");
        System.out.println("호두가 \'냐용\'이라고 함");
        System.out.println("호두가 '냐용'이라고 함");

        char c = 'a';
        c = '\'';
        System.out.println(c);
    }
}
