package _2024_09_07;

// java 에서 제공하는 클래스 사용하기
import java.util.ArrayList;
import java.util.Date;

class Student {
    // static 사용하여 클래스변수로 학생등록할때마다 숫자 올라가게하게 함
    // 객체 변수로 만들면 계속 같은값나옴
    int id;
    static int nextId = 202400;
    String name;
    // ArrayList<Date> 제네릭? 뭔지몰라서 찾아봄
    ArrayList<Date> attendanceRecord;

    Student(String name) {
        this.name = name;
        this.id = ++nextId;
        attendanceRecord = new ArrayList<>();
    }

    void printInFo() {
        System.out.println("해당학생의 학번은: \'" + id + "\', 이름은: \'" + name + "\' 입니다.");
    }

    void attendanceRecord() {
        // 이것도 몰랐는데 ArrayList<Date> 이거 찾아보면서 알게됨
        // 현재시간 가져오고
        Date currentDate = new Date();

        // 변수에 add 사용해서 기록하기
        this.attendanceRecord.add(currentDate);
        System.out.println("출석 완료");
    }

    void getAllRecords() {
        // for-each 사용해서 변수의 값들 순회하기
        for (Date list : attendanceRecord) {
            System.out.println("출석기록: " + list);
        }
    }
}

public class AttendanceSystem {
    public static void main(String[] args) {
        // 1. 학생 객체 생성
        Student student1 = new Student("이상원");
        // 2. 학생 정보 출력
        student1.printInFo();
        // 3. 출석하기
        student1.attendanceRecord();
        // 4. 출석정보 출력
        student1.getAllRecords();
        // 5. 한번더 출석
        student1.attendanceRecord();
        // 6. 출석정보 출력
        student1.getAllRecords();

        System.out.println("----------------------------------");

        Student student2 = new Student("고윤정");
        // 학번 제대로올라가나 확인
        student2.printInFo();
        student2.attendanceRecord();
        student2.getAllRecords();

        student1.printInFo();

        // 한번에 실행하면 시간기록 다 똑같아서
        // 디버깅 이용해서 현재시간 기록 바뀌는지 확인해봄
    }
}
