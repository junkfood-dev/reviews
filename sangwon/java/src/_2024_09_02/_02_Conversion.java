package _2024_09_02;

public class _02_Conversion {
    public static void main(String[] args) {
        // 문자열을 숫자로
        // 문자열에 숫자만 존재해야 가능
        // 문자열 -> 기본자료형 parseXxx() 메소드사용
        // 문자열 -> 래퍼클래스 volueOf() 메소드사용

        String str = "12345";
        int intValue = Integer.parseInt(str);
        Integer integerValue = Integer.valueOf(str);

        // 숫자 -> 문자
        // 아래 3가지 방법
        // integer.toString()
        // String.valueOf()
        // 변수 + ""  / Casting방식 주로 많이씀
        int intValue1 = 10;
        String StrValue;
        String x = String.valueOf(intValue1);
        String y = Integer.toString(intValue1);
        String z = "" + intValue1;

        //null 처리
        Object nullValue = null;
        String str1;
        str = nullValue.toString(); // NullPointerException 에러 발생
        str = String.valueOf(nullValue); // 문자열 "null"로 변환됨.
        // String 값이 없더라도 (String a = "";) 초기화하는게 좋음
    }
}
