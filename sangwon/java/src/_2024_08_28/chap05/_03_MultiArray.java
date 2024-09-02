package _2024_08_28.chap05;

public class _03_MultiArray {
    public static void main(String[] args) {
        // 다차원 배열

        // alt 누르고 드래그해서 한번에 복사하기
        String[] seatA = {"A1", "A2", "A3", "A4", "A5"};
        String[] seatB = {"B1", "B2", "B3", "B4", "B5"};
        String[] seatC = {"C1", "C2", "C3", "C4", "C5"};

        // 3 x 5 크기의 2차원배열
        String[][] seats = new String[][] {
                {"A1", "A2", "A3", "A4", "A5"},
                {"B1", "B2", "B3", "B4", "B5"},
                {"C1", "C2", "C3", "C4", "C5"}
        };

        System.out.println(seats[1][1]);
        System.out.println(seats[2][4]);

        System.out.println("------------------");

        String[][] seats2 = {
                {"A1", "A2", "A3"},
                {"B1", "B2", "B3", "B4"},
                {"C1", "C2", "C3", "C4", "C5"}
        };

        System.out.println(seats2[0][2]);

        System.out.println("-------------------");

        //3차원 배열 (세로 x 가로 x 높이)
        String[][][] marray = {
                {{}, {}, {}},
                {{}, {}, {}},
                {{}, {}, {}},
        };
    }
}
