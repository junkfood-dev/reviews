package _2024_09_26.raisingACat;

public class Cat {
    String name;
    int age;
    double weight;
    int happiness;
    int hunger;
    int health;
    boolean isAlive;

    public Cat(String name) {
        this.name = name;
        this.age = 0;
        this.weight = 2.0;
        this.happiness = 0;
        this.hunger = 5;
        this.health = 5;
        this.isAlive = true;
    }

    public void feed() {
        hunger --;
        weight += 0.2;
    }

    public void play() {
        happiness++;
        hunger++;
        health += 1;
        weight -= 0.2;
    }

    public void ageUp() {
        age++;
        boolean isDead = healthDown();
        if (!isDead) {
            System.out.println(name + "가 하늘로 갔습니다.");
        } else {
            if (age < 3) {
                weight += 1.0;
                hunger++;
                health += 1;
            } else if (age < 7) {
                weight += 0.4;
                hunger++;
                health -= 1;
            } else {
                weight -= 0.5;
                health -= 2;
            }
        }
    }

    public boolean healthDown() {
        if (hunger > 9 || weight > 7) {
            health--;
            if (health <= 0) {
                setIsAlive();
                return true;
            }
        }
        return false;
    }

    public void setIsAlive() {
        this.isAlive = false;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String getName() {
        return name;
    }
}
