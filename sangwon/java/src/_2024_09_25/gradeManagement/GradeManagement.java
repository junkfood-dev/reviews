package _2024_09_25.gradeManagement;

import java.util.Scanner;

public class GradeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeCalculator gradeCalculator = new GradeCalculator();

        while (true) {
            System.out.println("1. 학생 성적 입력");
            System.out.println("2. 학생 성젹표 출력");
            System.out.println("3. 전체 등수 확인");
            System.out.println("4. 종료");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("학생이름: ");
                    String name = sc.nextLine();
                    System.out.print("국어 점수: ");
                    int koreanLanguage = sc.nextInt();
                    sc.nextLine();
                    System.out.print("수학 점수: ");
                    int mathematics = sc.nextInt();
                    sc.nextLine();
                    System.out.print("영어 점수: ");
                    int english = sc.nextInt();
                    sc.nextLine();
                    gradeCalculator.addStudent(new Student(name, koreanLanguage, mathematics, english));
                    break;
                case "2":
                    System.out.print("성적 확인할 학생 이름: ");
                    String choiceName = sc.nextLine();
                    gradeCalculator.printReportCard(choiceName);
                    break;
                case "3":
                    gradeCalculator.printRanks();
                    break;
                case "4":
                    System.out.println("종료");
                    System.exit(0);
                default:
                    System.out.println("1, 2, 3 중에 선택하세요.");
                    break;
            }
        }
    }
}
