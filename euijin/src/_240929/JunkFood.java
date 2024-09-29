package _240929;

import java.sql.*;

public class JunkFood {
    private static final String URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    public static void main(String[] args) {
        JunkFood junkFood = new JunkFood();
        junkFood.getMembers();
    }

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void getMembers() {
        String query = "SELECT name, location, CASE WHEN isMarried = 1 THEN '기혼' WHEN isMarried = 0 AND isSolo = 1 THEN '솔로' ELSE '여친있음' END AS statement FROM JunkFood";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String location = rs.getString("location");
                String statement = rs.getString("statement");

                if(name.equals("서명원")) {
                    statement = "대머리";
                }

                System.out.println("이름: " + name + ", 주소: " + location + ", 현재: " + statement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
