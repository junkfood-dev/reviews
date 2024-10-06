package _2024_10_06.miniStarCraft;

import java.util.Random;

public class Marine extends Unit {
    public Marine(String name, int health, int attackPower,int powerUp) {
        super(name, health, attackPower + powerUp);
    }

    public void enemyAttack(Unit target) {
        Random random = new Random();
        if (random.nextInt(100) < 10) {
            attackPower *= 2;
        }
        target.health -= attackPower;
    }
}
