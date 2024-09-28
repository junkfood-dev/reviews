package _2024_09_28.movie_reservation;

import java.util.Scanner;

public class MovieReservation {
    private static final String URL = "jdbc:mysql://localhost:3306/study_project";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("메뉴");
            System.out.println("1. 영화 목록 보기");
            System.out.println("2. 상영 정보 보기");
            System.out.println("3. 예매하기");
            System.out.println("4. 종료");
            System.out.print("번호 선택: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" ->
            }
        }
    }
}
