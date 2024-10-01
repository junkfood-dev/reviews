package _2024_10_01;

import java.sql.Timestamp;
import java.util.Scanner;

public class JoinTheMembership {
    public static void main(String[] args) {
        MembershipManagement membershipManagement = new MembershipManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            MembershipManagement.printMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("회원가입");
                    System.out.print("ID 입력: ");
                    String userId = sc.nextLine();
                    System.out.print("성명 입력: ");
                    String userName = sc.nextLine();
                    System.out.print("비밀번호 입력: ");
                    String password = sc.nextLine();
                    System.out.print("이메일 입력: ");
                    String userEmail = sc.nextLine();

                    Timestamp creatAt = new Timestamp(System.currentTimeMillis());
                    membershipManagement.addMembership(new User(userId, userName, password, userEmail, creatAt));
                    break;

                case "2":
                    System.out.println("가입 조회");
                    System.out.print("ID 입력: ");
                    String inquiryId = sc.nextLine();
                    System.out.print("비밀번호 입력: ");
                    String inquiryPassword = sc.nextLine();

                    membershipManagement.displayMemberToId(inquiryId, inquiryPassword);
                    break;

                case "3":
                    System.out.print("회원탈퇴 하실 ID: ");
                    String secessionID = sc.nextLine();
                    System.out.print("비밀번호 입력: ");
                    String secessionPassword = sc.nextLine();

                    membershipManagement.secessionToId(secessionID, secessionPassword);
                    break;

                case "4":
                    System.out.println("종료");
                    System.exit(0);

                default:
                    System.out.println("잘못된 번호 입력");
            }
        }
    }
}
