package _2024_09_15.rentalCar;

public class RentalShop {
    public static void main(String[] args) {
        Car car1 = new Car("아반떼", 30000);
        Car car2 = new Car("아반떼", 30000);
        Car car3 = new Car("소나타", 50000);
        Car car4 = new Car("소나타", 50000);
        Car car5 = new Car("그렌져", 70000);
        Car car6 = new Car("그렌져", 70000);
        Car car7 = new Car("제네시스", 100000);

        CarRental rentalShop = new CarRental();
        rentalShop.addCar(car1);
        rentalShop.addCar(car2);
        rentalShop.addCar(car3);
        rentalShop.addCar(car4);
        rentalShop.addCar(car5);
        rentalShop.addCar(car6);
        rentalShop.addCar(car7);

        rentalShop.printRentalAvailable();
        rentalShop.findRentalCar("소나타");
        rentalShop.borrowByCar(4);
        rentalShop.printRentalAvailable();
        rentalShop.returnByCar(4);
    }
}
