package _2024_09_26.raisingACat;

public class RussianBlue extends Cat{
    public RussianBlue(String name) {
        super(name);
    }

    @Override
    public void feed() {
        super.feed();
        weight += 0.2;
        happiness += 1;
    }

    @Override
    public void play() {
        super.play();
        hunger++;
    }
}
