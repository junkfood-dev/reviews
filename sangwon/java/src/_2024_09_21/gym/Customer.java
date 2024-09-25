package _2024_09_21.gym;

public class Customer {
    String name;
    String phoneNumber;
    Membership membership;

    Customer(String name, String phoneNumber, Membership membership) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.membership = membership;
    }

    public void printCustomer() {
        System.out.println("회원: \t" + getName());
        System.out.println("연락처: \t" + getPhoneNumber());
        System.out.println("이용중인 멤버쉽: \t" + getMemberShip());
        System.out.println("회원권 시작날짜: \t" + membership.getStartDate());
        System.out.println("회원권 종료날짜: \t" + membership.getEndDate());
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Membership getMemberShip() {
        return membership;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}