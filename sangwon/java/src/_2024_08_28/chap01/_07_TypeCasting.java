package _2024_08_28.chap01;

public class _07_TypeCasting {
    public static void main(String[] args) {
        //형변환

        int score = 93;
        System.out.println(score);
        System.out.println((float) score); //93.0
        System.out.println((double) score); //93.0

        float score_f = 93.3F;
        double score_d = 98.7;
        System.out.println((int) score_f); //93
        System.out.println((int) score_d); //98

        score = 93 + (int) 98.8;
        System.out.println(score); //191

        score_d = 93 + 98.8;
        System.out.println(score_d); //191.8

        //변수에 형변환된 데이터 넣기
        double convertedScoreDouble = score; // 191 -> 191.0
        // int -> long -> float -> double (자동형변환)

        int convertedScoreInt = (int) score_d; // 191.8 -> 191
        // double -> float -> long -> int (수동형변환)

        // 숫자를 문자열로
        String s1 = String.valueOf(93);
        s1 = Integer.toString(93);
        System.out.println(s1); // 93

        String s2 = String.valueOf(98.8);
        s2 = Double.toString(98.8);
        System.out.println(s2); //98.8

        // 문자열을 숫자로
        int i = Integer.parseInt("93");
        System.out.println(i); // 93
        double d = Double.parseDouble("98.8");
        System.out.println(d); // 98.8

        int error = Integer.parseInt("자바");
    }
}
