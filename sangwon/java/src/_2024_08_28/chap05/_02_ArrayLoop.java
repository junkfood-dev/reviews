package _2024_08_28.chap05;

public class _02_ArrayLoop {
    public static void main(String[] args) {
        // 배열 순회
        String[] arr = {"아아", "라떼", "우유", "스무디"};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " 한잔");
        }
        System.out.println("주쇼");

        System.out.println("---------------------------");

        // enhanced for (for-each) 반복문
        // iter 탭키 단축키
        for (String coffee : arr) {
            System.out.println(coffee + " 한잔");
        }
        System.out.println("주쇼");
    }
}
