package _2024_09_02;

public class AuthApp {
    public static void main(String[] args) {
//        String[] users = {"youbin", "Jinhunk", "sangwon"};
        String[][] users = {
                {"youbin", "1111"},
                {"jinhuck", "2222"},
                {"sangwon", "3333"}
        };
        String inputId = args[0];
        String inputPass = args[1];

        boolean isLogined = false;
        for (int i = 0; i < users.length; i++) {
            String[] current = users[i];
            if (current[0].equals(inputId) && current[1].equals(inputPass)) {
                isLogined = true;
                break;
            }
        }
        System.out.printf("Hi,");
        if (isLogined) {
            System.out.println("Master!!");
        } else {
            System.out.printf("Who are you?");
        }
    }
}