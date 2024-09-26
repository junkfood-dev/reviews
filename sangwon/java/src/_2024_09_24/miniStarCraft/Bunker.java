package _2024_09_24.miniStarCraft;

public class Bunker {
    String name;
    int health;

    public Bunker(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getHealth() {
        return health;
    }
}