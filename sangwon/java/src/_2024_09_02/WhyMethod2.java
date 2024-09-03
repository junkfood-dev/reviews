package _2024_09_02;

import java.io.FileWriter;
import java.io.IOException;

import static _2024_09_02.WhyMethod.printTwoTimes;

public class WhyMethod2 {
    public static void main(String[] args) throws IOException {

        System.out.println(twoTimes("a", "-"));
        FileWriter fw = new FileWriter("out.txt");
        fw.write(twoTimes("a", "*"));
        fw.close();
        printTwoTimes("a", "&");
//        Email.send("asdf@a.com", "two times a", twoTimes("a", "&"));
    }
    public static String twoTimes(String text, String delimiter) {
        String out = "";
        out = out + delimiter + "/n";
        out = out + text + "/n";
        out = out + text + "/n";
        return out;
    }
}
