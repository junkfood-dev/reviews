package _2024_09_28.movie_reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Showing {
    private int id;
    private int movieId;
    private Timestamp showtime;

    public Showing(int id, int movieId, Timestamp showtime) {
        this.id = id;
        this.movieId = movieId;
        this.showtime = showtime;
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public Timestamp getShowtime() {
        return showtime;
    }

    public void displayShowingInfo() {
        System.out.println("상영관 : " + getMovieId());
        System.out.println("상영 시간: " + getShowtime());
    }

    public static List<Showing> getAllShowingsByMovie(String movieTitle) {
        List<Showing> showings = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM showings AS s INNER JOIN movies AS m ON s.movie_id = m.id WHERE movies.title = ?"
             )) {
            preparedStatement.setString(1, movieTitle);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int movieId = resultSet.getInt("movie_id");
                Timestamp showtime = resultSet.getTimestamp("showtime");
                showings.add(new Showing(id, movieId, showtime));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return showings;
    }
}