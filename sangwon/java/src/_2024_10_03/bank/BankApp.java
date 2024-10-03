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

    public void editPassword(String name, String password, String changePassword) {
        try (
                Connection connection = Database.getConnection();
                PreparedStatement changePassword2 = connection.prepareStatement(
                        "UPDATE customer SET password = ? WHERE name = ? AND password = ?"
                )) {
            changePassword2.setString(1, changePassword);
            changePassword2.setString(2, name);
            changePassword2.setString(3, password);
            int row = changePassword2.executeUpdate();
            if (row > 0) {
                System.out.println("비밀번호 변경 완료");
            } else {
                System.out.println("변경 실패");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "비밀번호 변경 중 오류 발생: " + e.getMessage(), e);
        }
    }
}