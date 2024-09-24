package _2024_09_24.miniStarCraft;

import java.util.Random;

public class Marin extends Unit {
    public Marin(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void enemyAttack(Unit target) {
        Random random = new Random();
        if (random.nextInt(100) < 10) {
            attackPower *= 2;
        }
        target.health -= attackPower;
    }
}
