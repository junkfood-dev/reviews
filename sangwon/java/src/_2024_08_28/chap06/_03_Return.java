package _2024_08_28.chap06;

public class _03_Return {
    public static String getPhoneNumber() {
        String phoneNumber = "02-1234-5678";
        return phoneNumber;
    }

    public static String getAdress() {
        return "서울시 어딘가";
    }

    public static String getActivities() {
        return "볼링, 탁구 , 노래방";
    }

    public static void main(String[] args) {
        String contactNumber = getPhoneNumber();
        System.out.println("호텔 전화번호 : " + contactNumber);

        String address = getAdress();
        System.out.println("호텔 주소 : " + address);

        System.out.println("호텔 액티비티 : " + getActivities());
    }
}
