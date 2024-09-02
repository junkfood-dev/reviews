package _2024_08_28.chap01;

public class _03_Variables {
    public static void main(String[] args) {
        String name;
        name = "abc";
        //String name = "abc";
        int number = 15;

        System.out.println(name + "는" + number + "시작함");
        System.out.println(name + "끝남");

        double score = 90.5;
        char grade = 'A';
        name = "고윤정";
        System.out.println(name + "너의 점수" + score + "이거다");
        System.out.println("니 등급은" + grade + "임");

        boolean pass = false;
        System.out.println("너 합격했을까? " + pass);

        double d = 3.14123456789;
        float f = 3.14123456789F;
        System.out.println(d);
        System.out.println(f);

//        int i = 1000000000000;
        long l = 1000000000000L;
        l = 100_000_000_000_000L;
        System.out.println(l);

//        int. long //정수
//        float, double //실수
//        char // 한글자
//        String //문자열
//        boolean // 참 거짓
    }
}
