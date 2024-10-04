package _2024_10_03.bank;

import java.math.BigDecimal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankApp {
    private static final Logger logger = Logger.getLogger(BankApp.class.getName());

    public void registerCustomer(Customer customer) {
        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO customer (name, address, password) VALUES (?, ? ,?)",
                        Statement.RETURN_GENERATED_KEYS
                )) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPassword());

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int customerId = generatedKeys.getInt(1);
                        try (
                                PreparedStatement accountStatement = connection.prepareStatement(
                                        "INSERT INTO account (customer_id, balance) VALUES (?, ?)"
                                )) {
                            accountStatement.setInt(1, customerId);
                            accountStatement.setBigDecimal(2, BigDecimal.ZERO);
                            accountStatement.executeUpdate();
                        }
                        System.out.println(customer.getName() + "님 계좌 생성");
                    }
                }
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
            } catch (SQLException e) {
                connection.rollback();
                logger.log(Level.SEVERE, "회원탈퇴 중 오류 발생: " + e.getMessage(), e);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "회원탈퇴 중 오류 발생: " + e.getMessage(), e);
        }
    }

    public void balanceInquiry(String name, String password) {
        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT a.* FROM account AS a INNER JOIN customer AS c ON a.customer_id = c.customer_id WHERE c.name = ? AND c.password = ?"
                )) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println(name + "님의 잔액 : " + resultSet.getBigDecimal("balance"));
            } else {
                System.out.println("정보 없음");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "잔액 조회 중 오류 발생: " + e.getMessage(), e);
        }
    }

    public void depositWithdrawal(String name, String password, Transaction.TransactionType transactionType, BigDecimal amount) {
        try (
                Connection connection = Database.getConnection();
                PreparedStatement accountStatement = connection.prepareStatement(
                        "SELECT a.* FROM account AS a INNER JOIN customer AS c ON a.customer_id = c.customer_id WHERE c.name = ? AND c.password = ?");
                PreparedStatement updateStatement = connection.prepareStatement(
                        "UPDATE account SET balance = ? WHERE account_id = ?");
                PreparedStatement transactionStatement = connection.prepareStatement(
                        "INSERT INTO transaction (account_id, transaction_type, amount) VALUES (?, ?, ?)")
        ) {
            connection.setAutoCommit(false);
            accountStatement.setString(1, name);
            accountStatement.setString(2, password);
            ResultSet resultSet = accountStatement.executeQuery();

            if (resultSet.next()) {
                int accountID = resultSet.getInt("account_id");
                BigDecimal currentBalance = resultSet.getBigDecimal("balance");

                BigDecimal newBalance = null;
                if (transactionType == Transaction.TransactionType.DEPOSIT) {
                    newBalance = currentBalance.add(amount);
                } else if (transactionType == Transaction.TransactionType.WITHDRAWAL) {
                    if (currentBalance.compareTo(amount) < 0) {
                        System.out.println("출금 실패, 현재 잔액: " + currentBalance);
                        connection.rollback();
                        return;
                    }
                    newBalance = currentBalance.subtract(amount);
                }

                updateStatement.setBigDecimal(1, newBalance);
                updateStatement.setInt(2, accountID);
                updateStatement.executeUpdate();

                transactionStatement.setInt(1, accountID);
                transactionStatement.setString(2, String.valueOf(transactionType));
                transactionStatement.setBigDecimal(3, amount);
                transactionStatement.executeUpdate();

                connection.commit();
                String message = transactionType == Transaction.TransactionType.DEPOSIT ? "입금 후 잔액: " : "출금 후 잔액: ";
                System.out.println(message + newBalance);
            } else {
                System.out.println("정보 없음");
                connection.rollback();
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "입금 중 오류 발생: " + e.getMessage(), e);
        }
    }
}