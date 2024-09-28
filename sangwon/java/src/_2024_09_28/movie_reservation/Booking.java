package _2024_09_28.movie_reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void saveReservation(Booking booking) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO bookings (showing_id, customer_name, seats) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, this.showingId);
            preparedStatement.setString(2, this.customerName);
            preparedStatement.setInt(3, this.seats);

            int addRow = preparedStatement.executeUpdate();
            if (addRow > 0) {
                System.out.println("예매 정보 저장 완료");
            } else {
                System.out.println("예매 정보 저장 실패");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Booking> getBookingByCustomer(String name) {
        List<Booking> bookings = new ArrayList<>();
        try(
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM bookings WHERE customer_name = ?")) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int showingId = resultSet.getInt("showing_id");
                String customerName = resultSet.getString("customer_name");
                int seats = resultSet.getInt("seats");
                bookings.add(new Booking(id, showingId, customerName, seats));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookings;
    }
}