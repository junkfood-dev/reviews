package _2024_09_20.hashSet;

public class Member {
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }


    // 중복 체크를 위한 오버라이딩으로 재정의
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member member = (Member) obj;
            return member.name.equals(this.name) && member.age == this.age;
        } else {
            return false;
        }
    }
}
