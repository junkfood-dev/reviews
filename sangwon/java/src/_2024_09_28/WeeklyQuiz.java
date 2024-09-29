package _2024_09_28;

import java.sql.*;

public class WeeklyQuiz {
    public static void main(String[] args) {
        // URL, 유저, 비번 가져오기
        String url = "jdbc:mysql://localhost:3306/study_project";
        String user = "root";
        String password = "0000";

        // try-with-resoruces 사용해서 리소스 자동 닫기
        try (
                // 데이터베이스 연결
                Connection connection = DriverManager.getConnection(url, user, password);
                // 쿼리 작성하기
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT name, age, address FROM students WHERE age BETWEEN 30 AND 39");
                // 쿼리 실행하고 결과 받기
                ResultSet resultSet = preparedStatement.executeQuery()
                ){
            // 컬럼명 가져오기
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            // 컬럼명 출력
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // 결과 출력
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                System.out.println(name + "\t" + age + "\t" + address);
            }
        } catch (SQLException e) {
            System.out.println("SQL 에러 발생");
            throw new RuntimeException(e);
        }
    }
}