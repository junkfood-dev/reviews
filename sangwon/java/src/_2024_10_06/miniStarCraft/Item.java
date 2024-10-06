package _2024_10_06.miniStarCraft;

public abstract class Item {
    private int id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void use();
}
