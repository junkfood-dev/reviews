package _2024_09_21.gym;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gym {
    String name;
    List<Customer> customers;
    List<Trainer> trainers;
    List<Lecture> lectures;

    Gym(String name) {
        this.name = name;
        customers = new ArrayList<>();
        trainers = new ArrayList<>();
        lectures = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addTrainer(Trainer trainer) {
        this.trainers.add(trainer);
    }

    public void addLecture(Lecture lecture) {
        this.lectures.add(lecture);
    }

    public void removeCustomer(String name) {
        // 리스트 반복
        Iterator<Customer> iterator = customers.iterator();
        boolean find = false;
        // 리스트 끝까지 반복
        while (iterator.hasNext()) {
            // 현재 고객 가져오기
            Customer customer = iterator.next();
            if (customer.getName().equals(name)) {
                iterator.remove();
                System.out.println("목록에서 회원 삭제");
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("등록되지 않은 회원 입니다.");
        }
    }

    public void removeTrainer(String name) {
        Iterator<Trainer> iterator = trainers.iterator();
        boolean find = false;
        while (iterator.hasNext()) {
            Trainer trainer = iterator.next();
            if (trainer.getName().equals(name)) {
                iterator.remove();
                System.out.println("목록에서 트레이너 삭제");
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("등록되지 않은 트레이너 입니다.");
        }
    }

    public void removeLecture(String title) {
        Iterator<Lecture> iterator = lectures.iterator();
        boolean find = false;
        while (iterator.hasNext()) {
            Lecture lecture = iterator.next();
            if (lecture.getTitle().equals(title)) {
                iterator.remove();
                System.out.println(lecture + "강의를 삭제했습니다.");
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("존재하지 않는 강의 입니다.");
        }
    }

    public void findCustomer(String name) {
        boolean find = false;
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                customer.printCustomer();
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("존재하지 않는 고객입니다.");
        }
    }

    public void findTrainer(String name) {
        boolean find = false;
        for (Trainer trainer : trainers) {
            if (trainer.getName().equals(name)) {
                trainer.printTrainer();
                for (Lecture lecture : lectures) {
                    if (lecture.getTrainer().equals(trainer)) {
                        System.out.println("담당 강의: " + lecture.getTitle());
                    }
                }
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("찾으시는 " + name + " 트레이너가 없습니다.");
        }
    }

    public void findLecture(String title) {
        boolean find = false;
        for (Lecture lecture : lectures) {
            if (lecture.getTitle().equals(title)) {
                lecture.printLecture();
                find = true;
            }
        }
        if (!find) {
            System.out.println("찾으시는 " + title + " 수업이 없습니다.");
        }
    }

    public void gymSituation() {
        System.out.println(getName());
        System.out.println("헬스장 등록고객: " + customers.size() + "명");
        System.out.println("헬스장 트레이너: " + trainers.size() + "명");
        System.out.println("헬스장 강의: " + lectures.size() + "가지");
    }

    public void End() {
        System.out.println("종료");
        System.exit(0);
    }

    public String getName() {
        return name;
    }
}