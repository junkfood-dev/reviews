package _2024_09_26.raisingACat;

public class Ragdoll extends Cat{
    public Ragdoll(String name) {
        super(name);
    }

    @Override
    public void feed() {
        super.feed();
    }

    @Override
    public void play() {
        super.play();
        weight -= 0.1;
        happiness++;
    }
}
