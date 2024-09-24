package _2024_09_24.miniStarCraft;

public class Zergling extends Unit{
    public Zergling(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void bunkerAttack(Bunker target) {
        target.takeDamage(this.getAttackPower());
    }

    public void adrenaline(int enforce) {
        this.health += enforce;
    }
}
