package parks;
//# 아주 아주 간단한 출결 시스템 만들기
//
//1. 학생 객체를 생성한다.
//2. 학생 정보를 출력해본다.
//3. `attendanceRecord` 메소드를 호출하여 출석해본다.
//4. 출석 정보를 출력해본다.
//5. 한 번 더 `attendanceRecord` 메소드를 호출하여 출석해본다.
//6. 출석 정보를 출력해본다.
//
//### 클래스 참고
//
//1. 학생 클래스
//    - 클래스명: `Student`
//        - 속성
//        - `id`: 학번, `int` 타입의 데이터. `2024xx` 형태로 이루어져 있음. `xx`는 01부터 순차적으로 증가해야 함.
//        - `name`: 이름, `String` 타입의 데이터.
//        - `attendanceRecords`: 출결 배열, `ArrayList<Date>` 타입의 데이터.
//        - 생성자: `Student(String name)`
//        - 메소드
//        - `printInfo()`: 학생 정보(학번, 이름)를 출력하는 기능
//        - `attendanceRecord()`: 출석하는 기능
//        - `getAllRecords()`: 출석 정보를 출력하는 기능

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Student {
    static int number = 1;
    int id;
    String name;
    ArrayList<LocalTime> attendanceRecords;

    Student(String name) {
        id = 202400 + number;
        number++;
        this.name = name;
        attendanceRecords = new ArrayList<>();
    }

    void printInfo() {
        System.out.println("이름 : " + name + " 학번 : " + id);
    }

    void attendanceRecord() {
        attendanceRecords.add(LocalTime.now());
        System.out.println(name + " 출석");
    }

    void getAllRecords() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분");
        for (LocalTime time : attendanceRecords) {
            System.out.println(name + " " + time.format(formatter) + " ");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("김메주");
        Student student2 = new Student("이감태");
        Student student3 = new Student("박춘장");

        student1.printInfo();
        student2.printInfo();
        student3.printInfo();

        student1.attendanceRecord();
        student2.attendanceRecord();
        student3.attendanceRecord();

        student1.getAllRecords();
        student2.getAllRecords();
        student3.getAllRecords();
    }
}