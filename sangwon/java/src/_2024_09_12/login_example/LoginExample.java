package _2024_09_12.login_example;

public class LoginExample {
    public static void main(String[] args) {
        try {
            login("white", "12345");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            login("blue", "54321");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void login(String id, String password) /*빈칸*/throws NotExistsIdException, WrongPasswordException {
        if (!id.equals("blue")) { /*빈칸*/
            throw new NotExistsIdException("아이디가 존재하지 않습니다.");
        }

        if (!password.equals("12345")) { /*빈칸*/
            throw new WrongPasswordException("패스워드가 틀립니다.");
        }
    }
}
