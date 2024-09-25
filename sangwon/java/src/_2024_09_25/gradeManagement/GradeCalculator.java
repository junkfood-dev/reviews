package _2024_09_25.gradeManagement;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {
    private List<Student> studentList;

    public GradeCalculator() {
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public double calculateGradeAverage(String subject) {
        return studentList.stream()
                .mapToDouble(student -> {
                    switch (subject) {
                        case "국어":
                            return student.getKoreanLanguage();
                        case "수학":
                            return student.getMathematics();
                        case "영어":
                            return student.getEnglish();
                        case "전체":
                            return student.getAverage();
                        default:
                            System.out.println("없는 과목");
                            return 0;
                    }
                })
                .average()
                .orElse(0);
    }

    public int calculateRanks(String name) {
        List<Student> sortedStudents = studentList.stream()
                .sorted((s1, s2) -> Double.compare(s2.getAverage(), s1.getAverage()))
                .toList();

        for (int i = 0; i < sortedStudents.size(); i++) {
            if (sortedStudents.get(i).getName().equals(name)) {
                return i + 1;
            }
        }
        return -1;
    }

    public void printReportCard(String name) {
        boolean isFound = false;
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                System.out.println("학생이름: " + student.getName());
                System.out.println("국어 점수: " + student.getKoreanLanguage() + "/ 전체 국어 평균: " + calculateGradeAverage("국어"));
                System.out.println("영어 점수: " + student.getEnglish() + "/ 전체 영어 평균: " + calculateGradeAverage("영어"));
                System.out.println("수학 점수: " + student.getMathematics() + "/ 전체 수학 평균: " + calculateGradeAverage("수학"));
                System.out.println("평균 점수: " + student.getAverage() + "전체 등수: " + calculateRanks(name) + "등");
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("찾을 수 없는 이름입니다.");
        }
    }

    public void printRanks() {
        List<Student> sortedStudents = studentList.stream()
                .sorted((s1, s2) -> Double.compare(s2.getAverage(), s1.getAverage()))
                .toList();

        System.out.println("학생 등수:");
        for (int i = 0; i < sortedStudents.size(); i++) {
            Student student = sortedStudents.get(i);
            System.out.println((i + 1) + "등: " + student.getName() + " - 평균 점수: " + student.getAverage());
        }
    }
}
