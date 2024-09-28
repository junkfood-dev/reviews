package _2024_09_28.movie_reservation;

import java.util.Date;

public class Showing {
    private int id;
    private int movieId;
    private Date showtime;

    public Showing(int id, int movieId, Date showtime) {
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

    public void setShowtime(Date showtime) {
        this.showtime = showtime;
    }
    public Date getShowtime() {
        return showtime;
    }
}