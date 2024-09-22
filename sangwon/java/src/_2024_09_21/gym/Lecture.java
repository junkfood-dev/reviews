package _2024_09_21.gym;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
    String title;
    Trainer trainer;
    List<Customer> student;

    Lecture(String title, Trainer trainer) {
        this.title = title;
        this.trainer = trainer;
        this.student = new ArrayList<>();
    }

    public void printLecture() {
        System.out.println("강의이름: \t" + getTitle());
        System.out.println("담당 트레이너: " + getTrainer());
        System.out.println("현재 수강생 수: " + student.size());
    }

    public void addStudent(Customer customer) {
        this.student.add(customer);
    }

    public String getTitle() {
        return title;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    @Override
    public String toString() {
        return String.valueOf(title);
    }
}