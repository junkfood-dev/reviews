package _2024_09_28.movie_reservation;

public class Movie {
    int movieId;
    String title;
    String genre;
    int duration;

    public Movie(int movieId, String title, String genre, int duration) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void displayMovieInfo() {
        System.out.println("영화 : " + getTitle());
        System.out.println("장르 : " + getGenre());
        System.out.println("상영 시간 : " + duration + "분");
    }
}
