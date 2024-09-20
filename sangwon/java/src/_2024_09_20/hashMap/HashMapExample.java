package _2024_09_20.hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();

        map.put(new Student(50, "고윤정"), 95);
        map.put(new Student(50, "고윤정"), 95);

        System.out.println("총 Entry 수: " + map.size());
    }
}