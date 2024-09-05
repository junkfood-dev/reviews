package _2024_09_05;

import java.util.Arrays;

public class StringMethod {
    public static void main(String[] args) {
        // String 은 불변객체이다 (immutable)
        // 문자열을 수정할때, 새로운문자열을 복사해서 만든다.

        // equals(비교할문자열)
        // 문자열끼리의 값비교
        // == 주소값 비교
        String str = "Java";
        String str1 = new String("Java");
        String str2 = "java";
        str.equals(str1); // true
        str.equals(str2); // false
//        str == str1; // false

        // indexOf(문자)
        // 특정문자가 몇번째 인덱스에 있는지
        String s = "Hello World";
        s.indexOf("W"); // 6

        // charAt(index)
        // 인덱스위치의 문자 반환
        s.charAt(3); // l

        // contains(특정문자열)
        // 해당 문자열에 포함되어있는지 true false로 확인
        s.contains("lo"); // true

        // replace(문자, 문자), replaceAll
        // 특정문자열을 다른 문자열로 바꿀 때
        s.replace("World", "Java"); // Hello Java

        // substring(index, index)
        // 인덱스 사이 문자열 잘라내기 시작인덱스~끝인덱스바로전
        s.substring(0,5); // Hello
        s.substring(s.length()-2, s.length()); // ld

        // toUpperCase
        // toLowerCase

        // split(구분자)
        // 문자열을 특정 구분자로 나누어 배열로 반환
        String[] list = s.split(" ");
        System.out.println(Arrays.toString(list)); // [Hello, World]

        // trim
        // 앞뒤 공백제거
        String s2 = "      abcdefg     ";
        s2.trim(); // abcdefg

        // concat
        // 문자열 합치기
        String text1 = "Hello ";
        String text2 = "Java ";
        String text3 = "World";
        text1.concat(text2).concat(text3); // Hello Java World

        // 문자열 포맷팅 메소드
        // String.format(문자열, 치환값, 치환값, ....)
        // 문자열 안의 특정한 값을 바꿀 수 있게 해줌
        // %s(문자열), %d(정수형), %f(실수형)
        String str3 = ".....%s....%s....";
        String.format(str3, "A", "B"); // .....A....B....

        // StringBuffer (멀티스레드 환경에서 안전) / StringBuilder (성능이 우수함)
        // 문자열을 추가하거나 변경(연산)할 때 주로 사용
        // String자료형 concat메소드로 이어 붙일수 있지만, 새로운 객체를 생성하고 공간을 할당하기 때문에 비효율적임
        // 내장메소드
        // append 문자열을 생성(추가)
        StringBuffer buffer = new StringBuffer();
        buffer.append("Hello ");
        buffer.append("Java ");
        buffer.append("World!");
        // insert(index, "") 인덱스 위치에 문자열 집어넣기
        buffer.insert(0, "시작! "); // 시작! Hello Java World!
        // substring
    }
}
