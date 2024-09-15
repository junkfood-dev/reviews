package _2024_09_15.rentalCar;

public class Car {
    static int nextNumber = 1;

    int carNumber;
    String name;
    int price;
    boolean isRental = true;

    Car(String name, int price) {
        this.name = name;
        this.price = price;
        this.carNumber = nextNumber++;
    }

    String getName() {
        return this.name;
    }

    int getPrice() {
        return this.price;
    }

    int getCarNumber() {
        return this.carNumber;
    }

    boolean getIsRental() {
        return this.isRental;
    }

    void setIsRental(boolean isRental) {
        this.isRental = isRental;
    }
}
