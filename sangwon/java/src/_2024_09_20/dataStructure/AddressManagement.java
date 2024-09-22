package _2024_09_20.dataStructure;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AddressManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        Pattern PatternTest = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
        Pattern namePattern = Pattern.compile("[a-zA-Z가-힣]+");

        while (true) {
            System.out.println("====================");
            System.out.println("1. 비즈니스 연락처 추가");
            System.out.println("2. 개인 연락처 추가");
            System.out.println("3. 연락처 출력");
            System.out.println("4. 연락처 검색");
            System.out.println("5. 종료");
            System.out.println("====================");
            System.out.print("메뉴를 선택해주세요: ");

            int num;
            try {
                num = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("올바른 메뉴번호를 입력해주세요.");
                sc.nextLine();
                continue;
            }

            switch (num) {
                case 1:
                    String name1;
                    while (true) {
                        System.out.print("이름을 입력하세요: ");
                        name1 = sc.nextLine();
                        if (namePattern.matcher(name1).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 적어주세요.");
                    }

                    String phoneNum1;
                    while (true) {
                        System.out.print("전화번호를 입력하세요: ");
                        phoneNum1 = sc.nextLine();
                        if (PatternTest.matcher(phoneNum1).matches()) {
                            break;
                        }
                        System.out.println("전화번호를 올바르게 적어주세요");
                        System.out.println("예) 000-0000-0000");
                    }

                    String company;
                    while (true) {
                        System.out.print("회사명을 입력하세요: ");
                        company = sc.nextLine();
                        if (!company.isEmpty()) {
                            break;
                        }
                        System.out.println("입력 값이 없습니다.");
                    }

                    BusinessContact businessContact = new BusinessContact(name1, phoneNum1, company);
                    addressBook.addContact(businessContact);
                    System.out.println("====================");
                    System.out.println("\'" + name1 + "\'연락처 추가 완료");
                    continue;

                case 2:
                    String name2;
                    while (true) {
                        System.out.print("이름을 입력하세요: ");
                        name2 = sc.nextLine();
                        if (namePattern.matcher(name2).matches()) {
                            break;
                        }
                        System.out.println("올바른 이름을 적어주세요.");
                    }

                    String phoneNum2;
                    while (true) {
                        System.out.print("전화번호를 입력하세요: ");
                        phoneNum2 = sc.nextLine();
                        if (PatternTest.matcher(phoneNum2).matches()) {
                            break;
                        }
                        System.out.println("전화번호를 올바르게 적어주세요");
                        System.out.println("예) 000-0000-0000");
                    }

                    String relationship;
                    while (true) {
                        System.out.print("관계를 입력하세요: ");
                        relationship = sc.nextLine();
                        if (namePattern.matcher(relationship).matches()) {
                            break;
                        }
                        System.out.println("올바른 관계명을 적어주세요.");
                    }

                    PersonalContact personalContact = new PersonalContact(name2, phoneNum2, relationship);
                    addressBook.addContact(personalContact);
                    System.out.println("====================");
                    System.out.println("\'" + name2 + "\'연락처 추가 완료");
                    continue;

                case 3:
                    addressBook.displayContacts();
                    continue;

                case 4:
                    String name3;
                    while (true) {
                        System.out.print("검색할 이름을 입력하세요: ");
                        name3 = sc.nextLine();
                        if (namePattern.matcher(name3).matches()) {
                            boolean find = addressBook.searchContact(name3);
                            if (!find) {
                                System.out.println("연락처를 찾을 수 없습니다.");
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("올바른 이름을 입력해주세요");
                        }
                    }
                    continue;

                case 5:
                    addressBook.quit();
            }
        }
    }
}
