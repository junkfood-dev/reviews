package _2024_09_09;

public class TodayQuiz {
    public static void main(String[] args) {
//        1.
//        정수 리스트 num_list가 주어질 때,
//        마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을
//        마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을
//        추가하여 return하도록 solution 함수를 완성해주세요.
//
//        int[] num_list = {4, 5, 2, 7, 5};
//        int[] answer = new int[num_list.length + 1];
//        int last = num_list[num_list.length -1];
//        int secondLast = num_list[num_list.length - 2];
//        int result;
//        if (last > secondLast) {
//            result = last - secondLast;
//        } else {
//            result = last * 2;
//        }
//        for (int i = 0; i < num_list.length; i++) {
//            answer[i] = num_list[i];
//        }
//        answer[num_list.length] = result;
//        return answer;
///////////////////////////////////////////////////////////////////
//        2.
//        정수 리스트 num_list와 찾으려는 정수 n이 주어질 때,
//        num_list안에 n이 있으면 1을 없으면 0을
//        return하도록 solution 함수를 완성해주세요.
//
//        int[] num_list = {4, 5, 2, 7, 5};
//        int n = 7;
//        int answer = 0;
//        for (int i = 0; i < num_list.length; i++) {
//            if (num_list[i] == n) {
//                answer = 1;
//                break;
//            } else {
//                answer = 0;
//            }
//        }
//        return answer;
///////////////////////////////////////////////////////////////////
//        3.
//        정수 start_num와 end_num가 주어질 때,
//        start_num부터 end_num까지의 숫자를 차례로 담은 리스트를
//        return하도록 solution 함수를 완성해주세요.
//
//        int start_num = 2;
//        int end_num = 5;
//        int[] answer = new int[end_num - start_num + 1];
//        for (int i = end_num; i >= start_num; i--) {
//            answer[i-start_num] = i;
//        }
//        return answer;
///////////////////////////////////////////////////////////////////
//        4.
//        정수 배열 arr가 주어집니다.
//        arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고,
//        50보다 작은 홀수라면 2를 곱합니다.
//        그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.
//
//        int[] arr = {1, 2, 3, 100, 99, 98};
//        int[] answer = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] >= 50 && arr[i] % 2 == 0) {
//                answer[i] = arr[i] / 2;
//            } else if (arr[i] < 50 && arr[i] % 2 != 0){
//                answer[i] = arr[i] * 2;
//            } else {
//                answer[i] = arr[i];
//            }
//        }
//        return answer;
    }
}
