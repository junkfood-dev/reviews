package _2024_10_06.miniStarCraft;

public class RepairKit extends Item{
    private int healAmount;

    public RepairKit(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public void use() {
        System.out.println(getName() + "를 사용: " + healAmount + "만큼 벙커 수리 완료");
    }
}
