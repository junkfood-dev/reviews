package _2024_09_24.miniStarCraft;

public class Unit {
    String name;
    int health;
    int attackPower;

    public Unit(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }
}
