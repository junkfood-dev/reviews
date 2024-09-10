package _2024_09_08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Room {
    static int nextRoomNumber = 1;

    // enum -> 참조형변수임, 나중에 설명드릴게요 여기까지만들음
    // 찾아보고함
    private final RoomType roomType;
    enum RoomType {
        Single,
        Double,
        Premium
    }
    int roomNumber;
    int pricePerNight;
    boolean isAvailable = true;

    Room (RoomType roomType, int pricePerNight) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.roomNumber = nextRoomNumber++;
    }

    // 객실 예약
    void bookRoom () {
        if (isAvailable) {
            setIsAvailable(false);
            System.out.println("객실 \'" + roomNumber + "\' 예약했습니다.");
        } else {
            System.out.println("이미 예약중입니다.");
        }
    }

    // 객실 예약 취소
    void cancelBooking() {
        if (!isAvailable) {
            setIsAvailable(true);
            System.out.println("객실 \'" + roomNumber + "\' 예약 취소 되었습니다.");
        } else {
            System.out.println("예약된 객실이 아닙니다.");
        }
    }

    // 객실 정보
    void printInfo() {
        System.out.println("객실 번호:\'" + roomNumber + "\', 객실유형:\'" + roomType + "\', 가격:\'" + pricePerNight + "\', 예약가능 여부:\'" + isAvailable + "\'");
    }

    // 객실 번호 반환
    int getRoomNumber () {
        return roomNumber;
    }

    // 객실 유형 반환
    RoomType getRoomType () {
        return roomType;
    }

    // 예약 가능 여부 반환
    boolean getIsAvailable () {
        return isAvailable;
    }

    // 객실 예약가능 상태 변경 추가
    void setIsAvailable (boolean available) {
        this.isAvailable = available;
    }
}

class Customer {
    String customerId;
    String name;
    String email;

    Customer (String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    // 고객정보
    void printInfo() {
        System.out.println("ID:\'" + customerId + "\', 성함:\'" + name + "\', email:\'" + email + "\'");
    }
}

class Booking {
    String bookingId;
    Customer customer;
    Room room;
    String checkInDate;
    String checkOutDate;

    Booking(Customer customer, Room room, String checkInDate, String checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingId = generateBookingId();
    }

    // 중복되지않는 8자리 난수
    // 이것도 몰라서 찾아보고 함
    static String generateBookingId () {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            id.append(numbers.get(i));
        }
        return id.toString();
    }

    // 예약정보
    void printInfo () {
        System.out.println("예약 번호:\'" + bookingId + "\'");
        customer.printInfo();
        room.printInfo();
        System.out.println("체크인: " + checkInDate);
        System.out.println("체크아웃: " + checkOutDate);
    }

    // 예약 번호 반환
    String getBookingId () {
        return bookingId;
    }

    // 방 객체 반환
    Room getRoom () {
        return room;
    }
}

class Hotel {
    ArrayList<Room> rooms;
    ArrayList<Booking> bookings;

    Hotel () {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    // 객실 추가
    void addRoom (Room room) {
        this.rooms.add(room);
    }

    // 예약 가능 객실확인
    void findAvailableRoomByType(String roomType) {
        Room.RoomType type = Room.RoomType.valueOf(roomType);
        boolean find = false;
        for (Room room : rooms) {
            if (room.getRoomType() == type) {
                if (room.getIsAvailable()) {
                    room.printInfo();
                    find = true;
                }
            }
        }
        if (!find) {
            System.out.println("예약 가능한 객실이 없습니다.");
        }
    }

    // 예약하기
    void makeBooking (Customer customer, String roomType, String checkInDate, String checkOutDate) {
        for (Room room : rooms) {
            if (room.getRoomType().equals(Room.RoomType.valueOf(roomType))) {
                if (room.getIsAvailable()) {
                    Booking booking = new Booking(customer, room, checkInDate, checkOutDate);
                    bookings.add(booking);
                    room.bookRoom();
                    break;
                }
            }
        }
    }

    // 예약취소 추가
    void cancelReservation(String bookingId) {
        boolean find = false;
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                bookings.remove(booking);
                Room room = booking.getRoom();
                room.cancelBooking();
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("해당 예약번호가 없습니다.");
        }
    }

    // 개인 예약정보 호출 추가
    void getBookingByCustomer(Customer customer) {
        boolean find = false;
        for (Booking booking : bookings) {
            if (booking.customer.equals(customer)) {
                booking.printInfo();
                find = true;
            }
        }
        if (!find) {
            System.out.println("예약 정보 없음");
        }
    }

    // 모든예약정보 확인
    void getAllBookings () {
        for (Booking booking : bookings) {
            booking.printInfo();
        }
    }
}

public class HotelSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Room room1 = new Room(Room.RoomType.Single, 50000);
        Room room2 = new Room(Room.RoomType.Single, 50000);
        Room room3 = new Room(Room.RoomType.Single, 50000);
        Room room4 = new Room(Room.RoomType.Double, 90000);
        Room room5 = new Room(Room.RoomType.Double, 90000);
        Room room6 = new Room(Room.RoomType.Premium, 150000);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);
        hotel.addRoom(room4);
        hotel.addRoom(room5);
        hotel.addRoom(room6);
        Customer customer1 = new Customer("lsw", "이상원", "adsfad@ad.com");
        Customer customer2 = new Customer("guj", "고윤정", "aqwed@ad.com");

        hotel.makeBooking(customer1, "Single", "2024-09-15", "2024-09-17");
        hotel.makeBooking(customer2, "Double", "2024-10-20", "2024-09-25");
        hotel.getAllBookings();
        hotel.findAvailableRoomByType("Premium");
        hotel.getBookingByCustomer(customer2);
    }
}
