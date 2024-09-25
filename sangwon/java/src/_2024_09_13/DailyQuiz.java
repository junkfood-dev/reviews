package _2024_09_13;

import java.util.Arrays;

public class DailyQuiz {
    public static void main(String[] args) {
//    어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
//    예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
//    문자열 my_string이 매개변수로 주어질 때,
//    my_string의 모든 접미사를 사전순으로 정렬한 문자열 배열을 return 하는
//    solution 함수를 작성해 주세요.

        String my_string = "banana";
        String[] my = my_string.split("");
        String[] answer = new String[my.length];
        String x = my[my.length - 1];
        answer[my.length - 1] = x;
        for (int i = my.length - 2; i >= 0; i--) {
            x = my[i] + x;
            answer[i] = x;
        }
        Arrays.sort(answer);

//        더 간단한 풀이
//        String[] answer = new String[my_string.length()];
//        for (int i = 0; i < answer.length; i++) {
//            answer[i] = my_string.substring(i, my_string.length());
//        }
//        Arrays.sort(answer);
    }
}
