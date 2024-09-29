package _2024_09_28.movie_reservation;

import java.util.List;
import java.util.Scanner;

public class MovieReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("메뉴");
            System.out.println("1. 영화 목록 보기");
            System.out.println("2. 상영 정보 보기");
            System.out.println("3. 예매 하기");
            System.out.println("4. 예매 확인");
            System.out.println("5. 종료");
            System.out.print("번호 선택: ");
            String choice = sc.nextLine();
            System.out.println("--------------");

            switch (choice) {
                case "1":
                    List<Movie> movies = Movie.getAllMovies();
                    System.out.println("영화 목록");
                    for (Movie movie : movies) {
                        movie.displayMovieInfo();
                        System.out.println("--------------");
                    }
                    break;

                case "2":
                    System.out.println("상영관 확인 할 영화");
                    String movieTitle = sc.nextLine();
                    List<Showing> showingByTitle = Showing.getAllShowingsByMovie(movieTitle);
                    System.out.println(movieTitle + " 영화 상영 정보");
                    for (Showing showing : showingByTitle) {
                        showing.displayShowingInfo();
                    }
                    break;

                case "3":
                    System.out.println("예약할 영화 제목");
                    String bookingMovie = sc.nextLine();
                    List<Showing> showingList = Showing.getAllShowingsByMovie(bookingMovie);
                    if (showingList.isEmpty()) {
                        System.out.println("상영 없음");
                        break;
                    }
                    System.out.print("예약 상영관: ");
                    int choiceShowingId = sc.nextInt();
                    System.out.println();
                    sc.nextLine();
                    System.out.print("예약자 이름: ");
                    String customerName = sc.nextLine();
                    System.out.println("예약할 자리: ");
                    int seat = sc.nextInt();
                    sc.nextLine();

                    Booking booking = new Booking(0, choiceShowingId, customerName, seat);
                    booking.saveReservation(booking);
                    System.out.println("예약 완료");
                    break;

                case "4":
                    System.out.print("예매 확인할 고객이름: ");
                    String searchName = sc.nextLine();
                    System.out.println();
                    List<Booking> bookings = Booking.getBookingByCustomer(searchName);
                    if (bookings.isEmpty()) {
                        System.out.println(searchName + "님의 예매 기록이 없음");
                    } else {
                        System.out.println(searchName + "님의 예매 정보");
                        for (Booking booking1 : bookings) {
                            booking1.displayBookingInfo();
                        }
                    }
                    break;

                case "5":
                    System.out.println("종료");
                    System.exit(0);

                default:
                    System.out.println("잘못된 입력");
            }
        }
    }
}
