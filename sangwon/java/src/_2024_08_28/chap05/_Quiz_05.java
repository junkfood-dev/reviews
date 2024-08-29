package _2024_08_28.chap05;

public class _Quiz_05 {
    public static void main(String[] args) {
//        int[] size = {250, 255, 260, 265, 270, 275, 280, 285, 290, 295};
//        for (int i = 0; i < size.length; i++) {
//            System.out.println("사이즈 " + size[i] + " (재고 있음)");
//        }

        int[] sizeArray = new int[10];
        for (int i = 0; i < sizeArray.length; i++) {
            sizeArray[i] = 250 + (5 * i);
        }

        for (int size : sizeArray) {
            System.out.println("사이즈 " + size + " (재고 있음)");
        }
    }
}
