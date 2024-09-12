package _2024_09_12.login_example;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) { /*빈칸*/
        super(message);
    }
}
