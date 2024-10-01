package _2024_10_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MembershipManagement {
    private static final Logger logger = Logger.getLogger(MembershipManagement.class.getName());

    public void printMenu() {
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
}
