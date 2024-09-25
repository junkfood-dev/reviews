package _2024_09_21.gym;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GymManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gym gym1 = new Gym("해동 헬스");
        Pattern patternTest = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
        Pattern namePattern = Pattern.compile("[a-zA-Z가-힣]+");

        while (true) {
            System.out.println("===============");
            System.out.println("1. \t회원 등록");
            System.out.println("2. \t트레이너 등록");
            System.out.println("3. \t강의 생성");
            System.out.println("4. \t회원 조회");
            System.out.println("5. \t트레이너 조회");
            System.out.println("6. \t강의 조회");
            System.out.println("7. \t강의 등록");
            System.out.println("8. \t회원 삭제");
            System.out.println("9. \t트레이너 삭제");
            System.out.println("10. 강의 삭제");
            System.out.println("11. 헬스장 현황");
            System.out.println("0. \t종료");
            System.out.println("===============");
            System.out.print("실행할 메뉴 번호: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("올바른 메뉴번호를 입력하세요.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    String customerName;
                    while (true) {
                        System.out.print("회원 이름: ");
                        customerName = sc.nextLine();
                        if (namePattern.matcher(customerName).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 적어주세요.");
                    }

                    String phoneNumber;
                    while (true) {
                        System.out.print("연락처: ");
                        phoneNumber = sc.nextLine();
                        if (patternTest.matcher(phoneNumber).matches()) {
                            break;
                        }
                        System.out.println("올바른 연락처를 입력해주세요");
                        System.out.println("예) 000-0000-0000");
                    }

                    int choice2;
                    while (true) {
                        try {
                            System.out.println("회원권 종류");
                            System.out.println("1. 일간권(가격: 10000)");
                            System.out.println("2. 월간권(가격: 80000)");
                            System.out.println("3. 연간권(가격: 600000)");
                            System.out.print("선택: ");
                            choice2 = sc.nextInt();
                            sc.nextLine();

                            if (choice2 >= 1 && choice2 <= 3) {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("올바른 메뉴번호를 입력하세요.");
                            sc.nextLine();
                        }
                    }

                    String membershipType = "";
                    int price = 0;
                    switch (choice2) {
                        case 1:
                            membershipType = "일간권";
                            price = 10000;
                            break;
                        case 2:
                            membershipType = "월간권";
                            price = 80000;
                            break;
                        case 3:
                            membershipType = "연간권";
                            price = 600000;
                            break;
                    }

                    Membership membership = new Membership(membershipType, price, LocalDate.now());
                    gym1.addCustomer(new Customer(customerName, phoneNumber, membership));
                    System.out.println("회원 등록 완료");
                    continue;

                case 2:
                    String trainerName;
                    while (true) {
                        System.out.print("트레이너 이름: ");
                        trainerName = sc.nextLine();
                        if (namePattern.matcher(trainerName).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 적어주세요.");
                    }

                    System.out.print("전문분야: ");
                    String specialty = sc.nextLine();
                    System.out.print("경력: ");
                    String personalHistory = sc.nextLine();

                    gym1.addTrainer(new Trainer(trainerName, specialty, personalHistory));
                    System.out.println("트레이너 등록 완료");
                    continue;

                case 3:
                    System.out.print("강의 생성: ");
                    String lecture = sc.nextLine();

                    String trainerForLecture;
                    while (true) {
                        System.out.print(lecture + "강의 담당 트레이너: ");
                        trainerForLecture = sc.nextLine();
                        if (namePattern.matcher(trainerForLecture).matches()) {
                            break;
                        }
                        System.out.println("이름이 잘못 되었습니다.");
                    }

                    Trainer find = null;
                    for (Trainer trainer : gym1.trainers) {
                        if (trainer.getName().equals(trainerForLecture)) {
                            find = trainer;
                            break;
                        }
                    }
                    if (find != null) {
                        gym1.addLecture(new Lecture(lecture, find));
                        System.out.println("강의 추가 완료");
                    } else {
                        System.out.println("의 추가 실패 (이유: 해당 이름의 트레이너가 없습니다.");
                    }
                    continue;

                case 4:
                    String findCustomer;
                    while (true) {
                        System.out.print("조회할 회원: ");
                        findCustomer = sc.nextLine();
                        if (namePattern.matcher(findCustomer).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 입력해 주세요");
                    }
                    gym1.findCustomer(findCustomer);
                    continue;

                case 5:
                    String findTrainer;
                    while (true) {
                        System.out.print("조회할 트레이너: ");
                        findTrainer = sc.nextLine();
                        if (namePattern.matcher(findTrainer).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 입력해 주세요");
                    }
                    gym1.findTrainer(findTrainer);
                    continue;

                case 6:
                    String lectureName;
                    System.out.print("조회할 강의명: ");
                    lectureName = sc.nextLine();
                    gym1.findLecture(lectureName);
                    continue;

                case 7:
                    System.out.println("현재 강의 목록");
                    for (int i = 0; i < gym1.lectures.size(); i++) {
                        System.out.println((i + 1) + ". " + gym1.lectures.get(i).getTitle());
                    }
                    System.out.println("등록을 원하시는 강의번호를 선택하세요");
                    int choice3;
                    try {
                        choice3 = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("잘못된 번호입니다.");
                        sc.nextLine();
                        continue;
                    }
                    if (choice3 < 1 || choice3 > gym1.lectures.size()) {
                        System.out.println("존재하지 않는 강의 입니다.");
                        continue;
                    }

                    Lecture choiceLecture = gym1.lectures.get(choice3 - 1);
                    System.out.println("선택 강의: " + choiceLecture.getTitle());

                    String customerForLecture;
                    while (true) {
                        System.out.print("강의에 등록할 회원: ");
                        customerForLecture = sc.nextLine();
                        if (namePattern.matcher(customerForLecture).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 입력해 주세요");
                    }

                    Customer nameForLecture = null;
                    for (Customer customer : gym1.customers) {
                        if (customer.getName().equals(customerForLecture)) {
                            nameForLecture = customer;
                            break;
                        }
                    }
                    if (nameForLecture != null) {
                        choiceLecture.addStudent(nameForLecture);
                        System.out.println(nameForLecture + "회원 " + choiceLecture.getTitle() + "강의에 등록완료");
                    } else {
                        System.out.println("회원이 존재하지 않음");
                    }
                    continue;

                case 8:
                    String removeCustomer;
                    while (true) {
                        System.out.print("삭제할 회원: ");
                        removeCustomer = sc.nextLine();
                        if (namePattern.matcher(removeCustomer).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 입력해 주세요");
                    }
                    gym1.removeCustomer(removeCustomer);
                    continue;

                case 9:
                    String removeTrainer;
                    while (true) {
                        System.out.print("삭제할 트레이너: ");
                        removeTrainer = sc.nextLine();
                        if (namePattern.matcher(removeTrainer).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 입력해 주세요");
                    }
                    gym1.removeTrainer(removeTrainer);
                    continue;

                case 10:
                    System.out.print("삭제할 강의: ");
                    String removeLecture = sc.nextLine();
                    gym1.removeLecture(removeLecture);
                    continue;

                case 11:
                    gym1.gymSituation();
                    continue;

                case 0:
                    gym1.End();
            }
        }
    }
}