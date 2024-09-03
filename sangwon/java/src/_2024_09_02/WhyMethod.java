package _2024_09_02;

public class WhyMethod {
    public static void main(String[] args) {

                    // 인자(argument)
        printTwoTimes("a", "-");
        printTwoTimes("a", "*");
        printTwoTimes("a", "&");
        printTwoTimes("b", "!");
    }
    public static String twoTimes(String text, String delimiter) {
        String out = "";
        out = out + delimiter + "/n";
        out = out + text + "/n";
        out = out + text + "/n";
        return out;
    }

                                    // 매개변수(parameter)
    public static void printTwoTimes(String text, String delimiter) {
        System.out.println(delimiter);
        System.out.println(text);
        System.out.println(text);
    }
}
