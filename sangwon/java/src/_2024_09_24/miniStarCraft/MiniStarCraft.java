package _2024_09_24.miniStarCraft;

import java.util.*;

public class MiniStarCraft {
    List<Marin> marins;
    List<Scv> scvs;
    List<Zergling> zerglings;
    Resources mineral;
    Bunker bunker;
    Timer addZergling;
    Timer zerglingAttack;
    Timer marinAttack;

    public MiniStarCraft() {
        this.marins = new ArrayList<>();
        this.scvs = new ArrayList<>();
        this.zerglings = new ArrayList<>();
        this.bunker = new Bunker("벙커", 500);
        mineral = new Resources("미네랄", 0);

        scvs.add(new Scv("scv", 30, 5));
        scvs.add(new Scv("scv", 30, 5));
        scvs.add(new Scv("scv", 30, 5));
        scvs.add(new Scv("scv", 30, 5));
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("디펜스 시작");

        // 미네랄 수급
        Timer addResources = new Timer();
        TimerTask resourcesTimer = new TimerTask() {
            @Override
            public void run() {
                for (Scv scv : scvs) {
                    scv.collect(mineral);
                }
                System.out.println("미네랄 + " + scvs.size() * 8 + ", 현재 미네랄: " + mineral.getAmount());
            }
        };
        addResources.schedule(resourcesTimer, 0, 8000);

        // 저글링 생성
        addZergling = new Timer();
        TimerTask addZerglingTimer = new TimerTask() {
            @Override
            public void run() {
                Zergling zuggling = new Zergling("저글링", 35, 5);
                zerglings.add(zuggling);
                System.out.println("저글링 발견! 현재 저글링 수: " + zerglings.size());
            }
        };
        addZergling.schedule(addZerglingTimer, 0, 6000);

        // 벙커 공격
        zerglingAttack = new Timer();
        TimerTask zerglingAttakTimer = new TimerTask() {
            @Override
            public void run() {
                if (!zerglings.isEmpty()) {
                    for (Zergling zergling : zerglings) {
                        if (zergling.isAlive()) {
                            zergling.bunkerAttack(bunker);
                            if (bunker.getHealth() <= 0) {
                                System.out.println("벙커가 터졌습니다");
                                System.exit(0);
                            }
                        }
                    }
                    System.out.println("벙커체력: " + bunker.getHealth());
                }
            }
        };
        zerglingAttack.schedule(zerglingAttakTimer, 0, 6000);

        // 마린 공격
        marinAttack = new Timer();
        TimerTask marinAttackTimer = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (!marins.isEmpty() && !zerglings.isEmpty()) {
                        for (Marin marin : marins) {
                            marin.enemyAttack(zerglings.get(0));
                            if (!zerglings.get(0).isAlive()) {
                                System.out.println("저글링 수 - 1");
                                zerglings.remove(0);
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("저글링이 없습니다.");
                }
            }
        };
        marinAttack.schedule(marinAttackTimer, 0 , 5000);

        while (bunker.health > 0) {
            System.out.println("scv수: " + scvs.size() + ", 마린 수: " + marins.size() + ", 저글링 수: " + zerglings.size());
            System.out.println("1. SCV 생산 : 50미네랄");
            System.out.println("2. 마린 생산 : 50미네랄");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    if (mineral.useResources(50)) {
                        scvs.add(new Scv("scv", 40, 5));
                        System.out.println("scv 추가 완료");
                    } else {
                        System.out.println("미네랄이 부족합니다.");
                    }
                    break;
                case "2":
                    if (mineral.useResources(50)) {
                        marins.add(new Marin("마린", 40, 6));
                        System.out.println("마린 추가 완료");
                    } else {
                        System.out.println("미네랄이 부족합니다.");
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static void main(String[] args) {
        MiniStarCraft game = new MiniStarCraft();
        game.start();
    }
}
