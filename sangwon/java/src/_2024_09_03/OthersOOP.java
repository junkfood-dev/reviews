package _2024_09_03;

import java.io.FileWriter;
import java.io.IOException;

public class OthersOOP {
    public static void main(String[] args) throws IOException {
        // class : System, Math, FileWriter
        // instance : f1, f2

        System.out.println(Math.PI);
        System.out.println(Math.floor(1.8));
        System.out.println(Math.ceil(1.8));

        FileWriter f1 = new FileWriter("data.txt"); // data.txt 파일 생성
        f1.write("Hello");
        f1.write(" Java");

        FileWriter f2 = new FileWriter("data2.txt"); // data2.txt 파일 생성
        f2.write("Hello");
        f2.write(" Java2");
        f2.close();

        f1.write("!!!");
        f1.close();
    }
}
