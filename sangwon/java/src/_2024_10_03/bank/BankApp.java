package _2024_10_03.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankApp {
    private static final Logger logger = Logger.getLogger(BankApp.class.getName());

    public void registerCustomer(Customer customer) {
        try(
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO customer (name, address, password) VALUES (?, ? ,?)"
                )){
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPassword());

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("고객 등록 완료");
            } else {
                System.out.println("고객 등록 실패");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "고객 등록 중 오류 발생: " + e.getMessage(), e);
        }
    }
}