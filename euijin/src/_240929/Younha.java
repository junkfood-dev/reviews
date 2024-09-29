package _240929;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Younha {
    private static final String URL = "jdbc:mysql://localhost:3306/sqlpractice";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    Scanner sc = new Scanner(System.in);

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void getSongs() {
        while (true) {
            try {
                System.out.println("원하는 메뉴를 입력하셈");
                System.out.println("1. 앨범 검색");
                System.out.println("2. 검색 종료");

                System.out.print("선택: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("""
                                앨범을 선택하세요:
                                1. 1집
                                2. 2집
                                3. 3집-PartA
                                4. 3집-PartB
                                5. 4집
                                6. 5집
                                7. 6집
                                8. 6집-Repackage
                                9. 7집
                                0. 메뉴로 돌아가기
                                """);

                        System.out.print("앨범 선택: ");
                        int albumChoice = sc.nextInt();  // 앨범 번호 선택

                        String albumIDInput = "";
                        if (albumChoice >= 1 && albumChoice <= 9) {
                            albumIDInput = switch (albumChoice) {
                                case 1 -> "1집";
                                case 2 -> "2집";
                                case 3 -> "3집-PartA";
                                case 4 -> "3집-PartB";
                                case 5 -> "4집";
                                case 6 -> "5집";
                                case 7 -> "6집";
                                case 8 -> "6집-Repackage";
                                case 9 -> "7집";
                                default -> "";
                            };
                        } else if (albumChoice == 0) {
                            System.out.println("메뉴로 돌아갑니다.");
                            continue;
                        } else {
                            System.out.println("잘못된 선택입니다.");
                            continue;
                        }


                        String query = "SELECT * FROM Songs WHERE albumID = ?";

                        try (Connection conn = connect();
                             PreparedStatement stmt = conn.prepareStatement(query)) {

                            // 입력받은 albumID 값을 쿼리의 ?에 바인딩
                            stmt.setString(1, albumIDInput); // 더 알아보자

                            try (ResultSet rs = stmt.executeQuery()) {
                                boolean found = false;
                                int number = 1;
                                while (rs.next()) {
                                    found = true;
                                    String title = rs.getString("title");
                                    String length = rs.getString("length");

                                    System.out.println(number + ". " + title + ", 길이: " + length);
                                    number ++;
                                }
                                if (!found) {
                                    System.out.println("해당 앨범 ID에 대한 곡을 찾을 수 없습니다.");
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        System.out.println("프로그램을 종료합니다.");
                        return;

                    default:
                        System.out.println("1,2중에 하나치셈");
                }
            } catch (InputMismatchException e) {
                System.out.println("1,2중에 하나만 치셈.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Younha younha = new Younha();
        younha.getSongs();
    }
}
