package _2024_10_03.bank;

import java.sql.*;
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

    public void displayCustomer(String name, String password) {
        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM customer WHERE name = ?"
                )) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (!resultSet.getString("password").equals(password)) {
                    System.out.println("비밀번호가 틀림");
                    return;
                }
                if (resultSet.getBoolean("is_deleted")) {
                    System.out.println("탈퇴한 고객");
                    return;
                }
                System.out.println("고객 성함: " + resultSet.getString("name"));
                System.out.println("고객 주소: " + resultSet.getString("address"));
                System.out.println("가입 날짜: " + resultSet.getTimestamp("created_at"));
            } else {
                System.out.println("정보 없음");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "회원조회 중 오류 발생: " + e.getMessage(), e);
        }
    }

    public void secession(String name, String password) {
        try (Connection connection = Database.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM customer WHERE name = ?")) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    if (!resultSet.getString("password").equals(password)) {
                        System.out.println("비밀번호가 틀림");
                        return;
                    }

                    if (resultSet.getBoolean("is_deleted")) {
                        System.out.println("탈퇴한 회원");
                        return;
                    }

                    try (PreparedStatement updateStatement = connection.prepareStatement(
                            "UPDATE customer SET is_deleted = true, deleted_at = ? WHERE name = ?")) {
                        Timestamp deleteTime = new Timestamp(System.currentTimeMillis());
                        updateStatement.setTimestamp(1, deleteTime);
                        updateStatement.setString(2, name);
                        int rows = updateStatement.executeUpdate();
                        if (rows > 0) {
                            System.out.println("회원탈퇴 성공");
                            connection.commit();
                        } else {
                            System.out.println("회원탈퇴 실패");
                            connection.rollback();
                        }
                    }
                } else {
                    System.out.println("없는 정보");
                }
            }catch (SQLException e) {
                connection.rollback();
                logger.log(Level.SEVERE, "회원탈퇴 중 오류 발생: " + e.getMessage(), e);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "회원탈퇴 중 오류 발생: " + e.getMessage(), e);
        }
    }
}