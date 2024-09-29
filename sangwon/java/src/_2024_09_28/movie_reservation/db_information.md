```mysql
CREATE TABLE movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    genre VARCHAR(50),
    duration INT
);

INSERT INTO movies(title, genre, duration) VALUES
                                                   ('어벤져스: 엔드게임', '액션', 181),
                                                   ('기생충', '드라마', 132),
                                                   ('인셉션', '공상 과학', 148),
                                                   ('대부', '범죄', 175),
                                                   ('라이온 킹', '애니메이션', 88);

CREATE TABLE showings (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          movie_id INT,
                          showtime DATETIME,
                          FOREIGN KEY (movie_id) REFERENCES movies(id)
);

INSERT INTO showings (movie_id, showtime) VALUES
                                              (1, '2024-09-30 18:00:00'),
                                              (2, '2024-09-30 20:00:00'),
                                              (3, '2024-10-01 18:30:00'),
                                              (4, '2024-10-01 21:00:00'),
                                              (5, '2024-10-02 19:00:00');

CREATE TABLE bookings (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          showing_id INT,
                          customer_name VARCHAR(100),
                          seats VARCHAR(100),
                          FOREIGN KEY (showing_id) REFERENCES showings(id)
);
```