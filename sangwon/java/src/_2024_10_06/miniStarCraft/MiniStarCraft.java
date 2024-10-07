package _2024_10_06.miniStarCraft;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiniStarCraft {
    private static final Logger logger = Logger.getLogger(MiniStarCraft.class.getName());

    List<Marine> marines;
    List<Scv> scvs;
    List<Zergling> zerglings;
    Resources mineral;
    Bunker bunker;
    Timer addZergling;
    Timer zerglingAttack;
    Timer marineAttack;
    private int score;
    private int globalAttackUp = 0;

    public MiniStarCraft() {
        this.marines = new ArrayList<>();
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

        // 저글링 강화
        Timer addUpZergling = new Timer();
        TimerTask addUpZerglingTimer = new TimerTask() {
            @Override
            public void run() {
                for (Zergling zergling : zerglings) {
                    zergling.adrenaline(5);
                }
                System.out.println("저글링의 체력이 증가 했습니다.");
            }
        };
        addUpZergling.schedule(addUpZerglingTimer, 0, 20000);

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
                                addResources.cancel();
                                addZergling.cancel();
                                addUpZergling.cancel();
                                zerglingAttack.cancel();
                                marineAttack.cancel();
                                clearItems();

                                System.out.println("점수 등록");
                                System.out.print("이름 : ");
                                String name = sc.nextLine();
                                saveScore(name, score);
                                System.out.println(name + "님의 점수: " + score);
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
        marineAttack = new Timer();
        TimerTask marineAttackTimer = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (!marines.isEmpty() && !zerglings.isEmpty()) {
                        for (Marine marine : marines) {
                            marine.enemyAttack(zerglings.get(0));
                            if (!zerglings.get(0).isAlive()) {
                                System.out.println("저글링 수 - 1");
                                score += 10;
                                checkItemDrop();
                                zerglings.remove(0);
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("저글링이 없습니다.");
                }
            }
        };
        marineAttack.schedule(marineAttackTimer, 0, 5000);

        while (bunker.health > 0) {
            System.out.println("scv수: " + scvs.size() + ", 마린 수: " + marines.size() + ", 저글링 수: " + zerglings.size());
            System.out.println("1. SCV 생산 : 50미네랄");
            System.out.println("2. 마린 생산 : 50미네랄");
            System.out.println("3. 아이템 사용");

            synchronized (sc) {
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
                            marines.add(new Marine("마린", 40, 6, globalAttackUp));
                            System.out.println("마린 추가 완료");
                        } else {
                            System.out.println("미네랄이 부족합니다.");
                        }
                        break;
                    case "3":
                        int powerUpCount = getItemCount("파워업");
                        int repairKitCount = getItemCount("수리 키트");

                        System.out.println("사용할 수 있는 아이템:");
                        System.out.println("1. 파워업 아이템 (공격력 증가): " + ((powerUpCount > 0) ? "갯수: " + powerUpCount : "갯수: 0"));
                        System.out.println("2. 수리 키트 아이템 (체력 회복): " + ((repairKitCount > 0) ? "갯수: " + repairKitCount : "갯수: 0"));

                        System.out.println("사용할 아이템 번호를 입력하세요:");
                        String itemChoice = sc.nextLine();

                        switch (itemChoice) {
                            case "1":
                                useItem("파워업");
                                break;
                            case "2":
                                useItem("수리 키트");
                                break;
                            default:
                                System.out.println("잘못된 선택입니다.");
                                break;
                        }
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }

    // 아이템흭득
    public void checkItemDrop() {
        Random random = new Random();
        int chance = random.nextInt(100);
        if (chance < 10) {
            System.out.println("파워업 아이템을 획득했습니다!");
            PowerUp powerUp = new PowerUp("파워업", 1);
            addItem(powerUp);
        } else if (chance < 20) {
            System.out.println("수리 키트를 획득했습니다!");
            RepairKit repairKit = new RepairKit("수리 키트", 50);
            addItem(repairKit);
        }
    }

    // DB에 아이템추가
    public void addItem(Item item) {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO items (name, attack_boost, heal_amount) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, item.getName());

            if (item instanceof PowerUp) {
                statement.setInt(2, ((PowerUp) item).getAttackBoost());
                statement.setNull(3, Types.INTEGER);
            } else if (item instanceof RepairKit) {
                statement.setNull(2, Types.INTEGER);
                statement.setInt(3, ((RepairKit) item).getHealAmount());
            }

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                item.setId(generatedId);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "아이템 저장 중 오류 발생: " + e.getMessage(), e);
        }
    }

    // 아이템 가져오기
    public Item getItem(String itemName) {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items WHERE name = ?");
            statement.setString(1, itemName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int attackBoost = resultSet.getInt("attack_boost");
                int healAmount = resultSet.getInt("heal_amount");

                if (attackBoost > 0) {
                    return new PowerUp(itemName, attackBoost);
                } else if (healAmount > 0) {
                    return new RepairKit(itemName, healAmount);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "아이템 가져오기 중 오류 발생: " + e.getMessage(), e);
        }
        return null;
    }

    // 아이템사용
    public void useItem(String itemName) {
        Item item = getItem(itemName);
        if (item == null) {
            System.out.println(itemName + " 아이템이 없습니다.");
            return;
        }

        if (item instanceof PowerUp) {
            PowerUp powerUp = (PowerUp) item;
            boostAllMarines(powerUp.getAttackBoost());
        } else if (item instanceof RepairKit) {
            RepairKit repairKit = (RepairKit) item;
            bunker.takeDamage(-repairKit.getHealAmount());
            System.out.println("벙커 체력이 " + repairKit.getHealAmount() + "만큼 회복되었습니다.");
        }
        deleteItem(item.getId());
        System.out.println("사용완료");
    }

    // 아이템 사용시 마린 공격력 상승
    public void boostAllMarines(int boost) {
        for (Marine marine : marines) {
            marine.setAttackPower(marine.getAttackPower() + boost);
        }
        globalAttackUp += boost;
        System.out.println("모든 마린의 공격력이 " + boost + "만큼 증가했습니다.");
    }

    // 아이템 소모
    public void deleteItem(int id) {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM items WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "아이템 제거 중 오류 발생: " + e.getMessage(), e);
        }
    }

    // 아이템갯수
    private int getItemCount(String itemName) {
        int count = 0;
        try (Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT COUNT(*) FROM items WHERE name = ?"
            );
            statement.setString(1, itemName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "아이템 카운트 중 오류 발생: " + e.getMessage(), e);
        }
        return count;
    }

    // 점수 등록
    public void saveScore(String name, int score) {
        try (Connection connection = Database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO score (user_name, score) VALUES (?, ?)"
            );
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, score);
            preparedStatement.executeUpdate();
            System.out.println("점수 저장 완료");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "점수 등록 중 오류 발생: " + e.getMessage(), e);
        }
    }

    // 종료시 아이템초기화
    public void clearItems() {
        try(Connection connection = Database.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM items"
            );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "아이템 테이블 초기화 중 오류 발생: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        MiniStarCraft game = new MiniStarCraft();
        game.start();
    }
}
