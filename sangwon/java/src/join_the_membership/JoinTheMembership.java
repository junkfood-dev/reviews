package join_the_membership;

import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JoinTheMembership {
    public static void main(String[] args) {
        MembershipManagement membershipManagement = new MembershipManagement();
        Scanner sc = new Scanner(System.in);
        Pattern namePattern = Pattern.compile("[a-zA-Z가-힣]+");
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+=-]).{8,}$");
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

        while (true) {
            MembershipManagement.printMenu();
            String choice;
            try {
                choice = sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("올바른 메뉴번호를 입력해주세요.");
                continue;
            }

            switch (choice) {
                case "1":
                    System.out.println("회원가입");
                    String userId;
                    while (true) {
                        System.out.print("ID 입력: ");
                        userId = sc.nextLine();
                        if (userId.isEmpty()) {
                            System.out.println("입력바람");
                            continue;
                        } else if (membershipManagement.isUserIdExists(userId)) {
                            System.out.println("이미 존재하는 ID");
                            continue;
                        }
                        break;
                    }

                    String userName;
                    while (true) {
                        System.out.print("이름을 입력하세요: ");
                        userName = sc.nextLine();
                        if (namePattern.matcher(userName).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 적어주세요.");
                    }

                    System.out.println("비밀번호 (8자리이상, 영문, 숫자, 특수문자 포함)");
                    String password;
                    while (true) {
                        System.out.print("비밀번호 입력: ");
                        password = sc.nextLine();
                        if (passwordPattern.matcher(password).matches()) {
                            break;
                        }
                        System.out.println("다시 입력 (8자리이상, 영문, 숫자, 특수문자 포함)");
                    }

                    String userEmail;
                    while (true) {
                        System.out.print("메일을 입력하세요: ");
                        userEmail = sc.nextLine();
                        if (emailPattern.matcher(userEmail).matches()) {
                            break;
                        }
                        System.out.println("올바른 메일을 적어주세요.");
                    }

                    Timestamp creatAt = new Timestamp(System.currentTimeMillis());
                    membershipManagement.addMembership(new User(userId, userName, password, userEmail, creatAt));
                    break;

                case "2":
                    System.out.println("가입 조회");
                    String inquiryId;
                    while (true) {
                        System.out.print("ID 입력: ");
                        inquiryId = sc.nextLine();
                        if (inquiryId.isEmpty()) {
                            System.out.println("입력 내용이 없음");
                            continue;
                        }
                        break;
                    }
                    String inquiryPassword;
                    while (true) {
                        System.out.print("비밀번호 입력: ");
                        inquiryPassword = sc.nextLine();
                        if (inquiryPassword.isEmpty()) {
                            System.out.println("입력 내용이 없음");
                            continue;
                        }
                        break;
                    }
                    membershipManagement.displayMemberToId(inquiryId, inquiryPassword);

                    while (true) {
                        System.out.println("1. 비밀번호 변경, 2. 메인메뉴로 돌아가기");
                        String choice2;
                        try{
                            choice2 = sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("올바른 번호를 입력해주세요.");
                            continue;
                        }
                        switch (choice2) {
                            case "1":
                                System.out.println("비밀번호 (8자리이상, 영문, 숫자, 특수문자 포함)");
                                String changePassword;
                                while (true) {
                                    System.out.print("바꾸실 비밀번호 입력: ");
                                    changePassword = sc.nextLine();
                                    if (passwordPattern.matcher(changePassword).matches()) {
                                        if (!changePassword.equals(inquiryPassword)){
                                            membershipManagement.editPassword(inquiryPassword, changePassword);
                                            break;
                                        } else {
                                            System.out.println("현재 비밀번호와 같습니다.");
                                            continue;
                                        }
                                    }
                                    System.out.println("다시 입력 (8자리이상, 영문, 숫자, 특수문자 포함)");
                                }
                                break;
                            case "2":
                                break;
                            default:
                                System.out.println("잘못된 번호");
                        }
                        break;
                    }
                    break;

                case "3":
                    String secessionID;
                    while (true) {
                        System.out.print("회원탈퇴 하실 ID: ");
                        secessionID = sc.nextLine();
                        if (secessionID.isEmpty()) {
                            System.out.println("입력 내용이 없음");
                            continue;
                        }
                        break;
                    }
                    String secessionPassword;
                    while (true) {
                        System.out.print("비밀번호 입력: ");
                        secessionPassword = sc.nextLine();
                        if (secessionPassword.isEmpty()) {
                            System.out.println("입력 내용이 없음");
                            continue;
                        }
                        break;
                    }

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