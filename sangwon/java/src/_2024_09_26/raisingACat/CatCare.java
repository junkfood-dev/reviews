package _2024_09_26.raisingACat;

import java.util.ArrayList;
import java.util.List;

public class CatCare {
    List<Cat> cats;

    public CatCare() {
        this.cats = new ArrayList<>();
    }

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }

    public void printMenu(){
        String menu = """
            1. 고양이 추가
            2. 먹이 주기
            3. 놀아 주기
            4. 고양이 상태 확인
            5. 종료
            메뉴를 선택해주세요: ↵
            """;
        System.out.println(menu);
    }

    public void printCatStatus() {
        System.out.println("============");
        for (Cat cat : cats) {
            if (!cat.isAlive()) {
                System.out.println(cat.getName() + "하늘에 있습니다.");
            } else {
                System.out.println("이름: " + cat.getName());
                System.out.println("나이: " + cat.getAge());
                System.out.println("체중: " + cat.getWeight() + "kg");
                System.out.println("행복도: " + cat.getHappiness());
                System.out.println("배고픔: " + cat.getHunger());
                System.out.println("건강: " + cat.getHealth());
                System.out.println("============");
            }
        }
    }

    public static Cat findCatByName(CatCare catCare, String name) {
        for (Cat cat : catCare.cats) {
            if (cat.getName().equals(name) && cat.isAlive()) {
                return cat;
            }
        }
        return null;
    }
}
