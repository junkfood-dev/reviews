package _2024_10_06.miniStarCraft;

public class Resources {
    String type;
    int amount;

    public Resources(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public void collect(int quantity) {
        amount += quantity;
    }

    public boolean useResources(int price) {
        if (amount >= price) {
            amount -= price;
            return true;
        }
        return false;
    }

    public int getAmount() {
        return amount;
    }
}
