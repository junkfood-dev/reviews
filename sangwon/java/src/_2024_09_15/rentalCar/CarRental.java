package _2024_09_15.rentalCar;

import java.util.ArrayList;

public class CarRental {
    ArrayList<Car> rentalList;

    CarRental() {
        rentalList = new ArrayList<>();
    }

    void addCar(Car car) {
        this.rentalList.add(car);
    }

    void borrowByCar(int carNumber) {
        for (Car car : rentalList) {
            if (car.getCarNumber() == carNumber) {
                if (car.getIsRental()) {
                    car.setIsRental(false);
                    System.out.println(car.getName() + " 차량 대여 완료");
                    break;
                } else {
                    System.out.println("대여 가능 차량이 없습니다.");
                }
            }
        }
    }

    void returnByCar(int carNumber) {
        for (Car car : rentalList) {
            if (car.getCarNumber() == carNumber) {
                if (!car.getIsRental()) {
                    car.setIsRental(true);
                    System.out.println("반납 완료");
                } else {
                    System.out.println("저희 집에서 대여하신 차량이 아닙니다.");
                }
            }
        }
    }

    void findRentalCar(String name) {
        for (Car car : rentalList) {
            if (car.getName().equals(name)) {
                if (car.getIsRental()) {
                    System.out.println("차량번호: " + car.getCarNumber());
                    System.out.println("모델명: " + car.getName());
                    System.out.println("랜트가격: " + car.getPrice());
                } else {
                    System.out.println(name + "모델 중 대여가능 차량이 없습니다.");
                }
            }
        }
    }

    void printRentalAvailable() {
        for (Car car : rentalList) {
            if (car.getIsRental()) {
                System.out.println("차량번호: " + car.getCarNumber());
                System.out.println("모델명: " + car.getName());
                System.out.println("랜트가격: " + car.getPrice());
            }
        }
    }
}
