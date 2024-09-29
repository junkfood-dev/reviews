package _240929;


import java.sql.*;

public class SQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/weeklyquiz";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

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
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.getStudents();
    }
}
