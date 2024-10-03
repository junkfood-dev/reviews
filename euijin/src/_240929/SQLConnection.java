package _240929;


import java.sql.*;

public class SQLConnection {
    private static final String URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void getStudents() {
        String query = "SELECT * FROM students WHERE age BETWEEN 30 AND 39";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");

                System.out.println("이름: " + name + ", 나이: " + age + ", 주소: " + address);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 메시지 그대로 출력, 실무 사용 X
//            System.out.println(e.getErrorCode());
//            System.out.println(e.getMessage()); // 위 2개는 용량 문제 등으로 사용 X
            // logger.error(""); // 서버 로그를 파일로 남길 수 있는 '로거'(slf4j, log4j,..)


        }
    }
    public static void main(String[] args) {
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.getStudents();


    }
}
