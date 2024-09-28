package _2024_09_28.movie_reservation;

public class Booking {
    private int id;
    private int showingId;
    private String customerName;
    private int seats;

    public Booking(int id, int showingId, String customerName, int seats) {
        this.id = id;
        this.showingId = showingId;
        this.customerName = customerName;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getShowingId() {
        return showingId;
    }
    public void setShowingId(int showingId) {
        this.showingId = showingId;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void displayBookingInfo() {
        System.out.println("예약 ID: " + getId());
        System.out.println("고객이름: " + getCustomerName());
        System.out.println("상영관 : " + getShowingId());
        System.out.println("예약 좌석: " + getSeats());
    }
}