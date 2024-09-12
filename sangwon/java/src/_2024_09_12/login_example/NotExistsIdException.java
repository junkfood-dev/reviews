package _2024_09_12.login_example;

public class NotExistsIdException extends Exception{
    public NotExistsIdException() {
    }

    public NotExistsIdException(String message) { /*빈칸*/
        super(message);
    }
}
