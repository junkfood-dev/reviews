package _2024_09_20.hashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        set.add(new Member("고윤정", 20));
        set.add(new Member("고윤정", 20));

        System.out.println("총 객체수: " + set.size()); // 1
    }
}
