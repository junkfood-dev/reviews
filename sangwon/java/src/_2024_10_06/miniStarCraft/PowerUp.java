package _2024_10_06.miniStarCraft;

public class PowerUp extends Item{
    private int attackBoost;

    public PowerUp(String name, int attackBoost) {
        super(name);
        this.attackBoost = attackBoost;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    @Override
    public void use() {
        System.out.println(getName() + "을 사용 : " + attackBoost + "공격력 상승");
    }
}
