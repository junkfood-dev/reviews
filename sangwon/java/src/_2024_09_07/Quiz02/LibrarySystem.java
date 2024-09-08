package _2024_09_07.Quiz02;

import java.util.ArrayList;

class Book {
    static int nextId = 1;

    int id;
    String title;
    String author;
    boolean isAvailable = true;

    Book (String title, String author) {
        this.title = title;
        this.author = author;
        this.id = nextId++;
    }

    void printInfo() {
        System.out.println("책 번호:\'" + id + "\', 제목:\'" + title + "\', 저자:\'" + author + "\', 대여가능여부 :\'" + isAvailable + "\'");
    }

    int getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    boolean getIsAvailable() {
        return isAvailable;
    }

    void setIsAvailable(boolean available) {
        this.isAvailable = available;
    }
}

class Library {
    ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        this.books.add(book);
    }

    void removeBookById(int id) {
        boolean find = false;
        // books.length 안되서 ArrayList<>찾아봣을 때 본 거 같은 내용 떠올라서 다시찾음
        // size, get, remove
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                System.out.println(id + "번책 목록에서 제거 되었습니다.");
                find = true;
                i--;
            }
        }
        if (!find) {
            System.out.println("제거할 책이 없습니다.");
        }
    }

    void findBookByTitle(String title) {
        // 리턴도 넣고 순서도바꿔보고 이것저것햇는데 원하는대로 안되서
        // boolean 변수 만들어서 하는 법 찾아서함
        // 위에 removeBookById 메소드에도 적용함.

        // 책 찾았는지 기록
        boolean find = false;
        for (Book book : books) {
            // equals는 문자열 전부 같아야함 -> '자바' 검색을 위해 contains 사용
            if (book.getTitle().contains(title)) {
                book.printInfo();
                find = true;
            }
        }
        if (!find) {
            System.out.println("책이 없습니다.");
        }
    }

    void availableBooks() {
        for (Book book : books) {
            if (book.getIsAvailable()) {
                book.printInfo();
            }
        }
    }

    void borrowByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book.getIsAvailable()) {
                    book.setIsAvailable(false);
                    System.out.println("\'"+ book.getTitle() +"\'책을 대여했습니다.");
                } else {
                    System.out.println("이미 대여중입니다.");
                }
            }
        }
    }

    // 운영체제론을 제외한 나머지 모두대여하려고 만든 메소드
    void borrowByTitleAll(String title) {
        for (Book book : books) {
            if (!book.getTitle().equals(title)) {
                if (book.getIsAvailable()) {
                    book.setIsAvailable(false);
                    System.out.println("\'"+ book.getTitle() +"\'책을 대여했습니다.");
                } else {
                    System.out.println("대여할 책이 없습니다.");
                }
            }
        }
    }

    void returnByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (!book.getIsAvailable()) {
                    book.setIsAvailable(true);
                    System.out.println("\'"+ book.getTitle() +"\'책을 반납했습니다.");
                } else {
                    System.out.println("이미 반납했습니다.");
                }
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // 1. 도서관 객체 생성
        Library library = new Library();

        // 2. 책 객체 생성하고 도서관에 책추가
        Book book1 = new Book("자바의 정석", "남궁성");
        Book book2 = new Book("이펙티브 자바", "Joshua Bloch");
        Book book3 = new Book("클린 코드", "Robert C. Martin");
        Book book4 = new Book("해리포터와 마법사의 돌", "J.K. Rowling");
        Book book5 = new Book("자바스크립트 완벽 가이드", "David Flanagan");
        Book book6 = new Book("객체지향의 사실과 오해", "조영호");
        Book book7 = new Book("운영체제론", "Andrew S. Tanenbaum");
        Book book8 = new Book("스프링 인 액션", "Craig Walls");
        Book book9 = new Book("운영체제론", "조명성");
        Book book10 = new Book("빅데이터 분석과 활용", "한동수");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);
        library.addBook(book10);

        // 3. 운영체제론 제외한 나머지 대여하기
        library.borrowByTitle("스프링 인 액션");
        // 4. 3에서 대여중인 책 대여해보기
        library.borrowByTitle("스프링 인 액션");
        // 5. 3에서 대여한 책 반납하기
        library.returnByTitle("스프링 인 액션");
        // 6. 5에서 반납한 책 대여하기
        library.borrowByTitle("스프링 인 액션");
        // 7. 책 제목으로 검색하기
        library.findBookByTitle("스프링 인 액션");
        // 8. '자바' 검색하기
        library.findBookByTitle("자바");
        // 9. '운영체제론' 검색
        library.findBookByTitle("운영체제론");
        // 10. 책삭제하기
        library.removeBookById(10);
        // 11. 대여 가능 책 확인
        library.availableBooks();
    }
}
