package _241003;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusicPlayer {

    private static final String URL = System.getenv("DB_URL_sp");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    private static final Logger logger = Logger.getLogger(MusicPlayer.class.getName());


    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "데이터 베이스 연결 실패", e);
        }
        return conn;
    }

    public void getSongs() {
        String query = "SELECT title, artist, album, length FROM song";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                String album = rs.getString("album");
                String length = rs.getString("length");

                System.out.println("제목: " + title + ", 가수: " + artist + ", 앨범명: " + album + ", 길이: " + length);
            }

        } catch (SQLException e) {
            logger.log(Level.WARNING, "곡정보 오류", e);
        }
    }

    public void getPlaylists() {
        String query2 = "SELECT name FROM playlist";

        try (Connection conn = connect();
             PreparedStatement stmt2 = conn.prepareStatement(query2);
             ResultSet rs2 = stmt2.executeQuery()) {

            while (rs2.next()) {
                String name = rs2.getString("name");
                System.out.println("플레이리스트 이름: " + name);
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "플레이리스트 오류", e);
        }
    }

    public void addSong(String title, String artist, String album, String length, int playlistID) {
        String query = "INSERT INTO song(title, artist, album, length, playlist_id) VALUES (?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setString(2, artist);
            stmt.setString(3, album);
            stmt.setString(4, length);
            stmt.setInt(5, playlistID);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("새로운 곡 " + title + "이 추가됨");
                logger.log(Level.INFO, "새로운 곡 추가: " + title);
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "추가중 오류", e);
        }
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.addSong("고민중독", "QWER", "MANITO","00:02:56",3);

        Scanner sc = new Scanner(System.in);
        System.out.println("추가할 곡 제목");
        String title = sc.nextLine();
        System.out.println("가수 이름");
        String artist = sc.nextLine();
        System.out.println("앨범명");
        String album = sc.nextLine();
        System.out.println("곡 길이 입력");
        String length = sc.nextLine();
        System.out.println("""
                1. dance
                2. ballad
                3. rock
                """);
        int playlistID = sc.nextInt();
        player.addSong(title, artist, album, length, playlistID);

    }
}
