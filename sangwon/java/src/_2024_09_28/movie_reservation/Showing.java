package _2024_09_28.movie_reservation;

import java.time.LocalDateTime;

public class Showing {
    private int id;
    private int movieId;
    private LocalDateTime showtime;

    public Showing(int id, int movieId, LocalDateTime showtime) {
        this.id = id;
        this.movieId = movieId;
        this.showtime = showtime;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public int getMovieId() {
        return movieId;
    }

    public void setShowtime(LocalDateTime showtime) {
        this.showtime = showtime;
    }
    public LocalDateTime getShowtime() {
        return showtime;
    }

    public void displayShowingInfo() {
        System.out.println("상영관: " + getMovieId());
        System.out.println("상영 시간: " + getShowtime());
    }
}