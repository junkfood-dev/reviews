package _2024_10_06.miniStarCraft;

public class Scv extends Unit {
    public Scv(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void collect(Resources resources) {
        int collected = 8;
        resources.collect(collected);;
    }
}
