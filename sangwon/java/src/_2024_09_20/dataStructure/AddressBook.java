package _2024_09_20.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("연락처가 비어있습니다.");
            return;
        }
        for (Contact contact : contacts) {
            if (contact instanceof BusinessContact) {
                BusinessContact businessContact = (BusinessContact) contact;
                System.out.println("이름: " + contact.getName() + ", 전화번호: " + contact.getPhoneNumber() + ", 회사명: " + businessContact.getCompany());
            } else {
                PersonalContact personalContact = (PersonalContact) contact;
                System.out.println("이름: " + contact.getName() + ", 전화번호: " + contact.getPhoneNumber() + ", 관계: " + personalContact.getRelationship());
            }
        }
    }

    public boolean searchContact(String name) {
        boolean find = false;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                if (contact instanceof BusinessContact) {
                    BusinessContact businessContact = (BusinessContact) contact;
                    System.out.println("이름: " + contact.getName() + ", 전화번호: " + contact.getPhoneNumber() + ", 회사명: " + businessContact.getCompany());
                } else {
                    PersonalContact personalContact = (PersonalContact) contact;
                    System.out.println("이름: " + contact.getName() + ", 전화번호: " + contact.getPhoneNumber() + ", 관계: " + personalContact.getRelationship());
                }
                find = true;
            }
        }
        return find;
    }

    public void quit() {
        System.out.println("프로그램 종료");
        System.exit(0);
    }
}
