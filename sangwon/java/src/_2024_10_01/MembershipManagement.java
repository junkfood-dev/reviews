package _2024_10_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MembershipManagement {
    private static final Logger logger = Logger.getLogger(MembershipManagement.class.getName());

    public static void printMenu() {
        String menu = """
                1. 회원가입
                2. 가입조회
                3. 회원탈퇴
                4. 종료
                메뉴를 선택해주세요: ↵
                """;
        System.out.println(menu);
    }

    public void addMembership(User user) {
        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO user (id, name, password, email, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)"
                )) {
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setTimestamp(5, user.getCreatedAt());
            preparedStatement.setTimestamp(6, user.getUpdatedAt());

            int addRow = preparedStatement.executeUpdate();
            if (addRow > 0) {
                System.out.println("회원가입 완료");
            } else {
                System.out.println("회원가입 실패");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "회원가입 중 DB 오류 발생: " + e.getMessage(), e);
            System.out.println("회원가입 중 문제가 발생했습니다. 나중에 다시 시도해 주세요.");
        }
    }

    public void displayMemberToId(String id, String password) {
        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM user WHERE id = ?"
                )) {
            preparedStatement.setString(1, id);
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
                System.out.println("유저 아이디: " + resultSet.getString("id"));
                System.out.println("유저 성함: " + resultSet.getString("name"));
                System.out.println("유저 email: " + resultSet.getString("email"));
                System.out.println("가입 날짜: " + resultSet.getTimestamp("created_at"));
            } else {
                System.out.println("누구세요");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "회원조회 중 DB 오류 발생: " + e.getMessage(), e);
            System.out.println("회원조회 중 문제가 발생했습니다. 나중에 다시 시도해 주세요.");
        }
    }

    public void secessionToId(String id, String password) {
        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM user WHERE id = ?"
                )) {
            preparedStatement.setString(1, id);
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
                try (
                        PreparedStatement updateStatement = connection.prepareStatement(
                                "UPDATE user SET is_deleted = true WHERE id = ?"
                        )) {
                    updateStatement.setString(1, id);
                    int rows = updateStatement.executeUpdate();
                    if (rows > 0) {
                        System.out.println("회원탈퇴 성공");
                    } else {
                        System.out.println("탈퇴 실패");
                    }
                }
            } else {
                System.out.println("누구세요");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "회원탈퇴 중 DB 오류 발생: " + e.getMessage(), e);
            System.out.println("회원탈퇴 중 문제가 발생했습니다. 나중에 다시 시도해 주세요.");
        }
    }

    public boolean isUserIdExists(String userId) {
        try (
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT COUNT(*) FROM user WHERE id = ?"
                )) {
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "ID 중복 확인 중 DB 오류 발생: " + e.getMessage(), e);
        }
        return false;
    }
}