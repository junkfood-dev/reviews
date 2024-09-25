package _240911;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TIL {

//    자바에서 정의하는 예외(Exception)
//        -CheckedException   : 명시적으로 예외 처리를 강제화 O (컴파일러가 빨간줄로 알려줌)
//                              -> 예외처리를 하면 프로그램이 중단되지 않고 다음 프로세스 진행
//        -UncheckedException : 명시적으로 예외 처리를 강제화 X

    //    예외처리
//    -(직접) try-catch-finally
//    -(호출측으로 예외처리를 넘김) throws

//    -FileNotFoundException  -> CheckedException
//
//    -ArithmeticException  -> UncheckedException
//    -ArrayIndexOutOfBoundsException  -> UncheckedException
//      UncheckedException은 예외처리를 잘 하지 않음. 대신 코드 작성시 신경써서 하기
//    -> throw, try - catch 로 예외처리
//    try {
//        예외처리코드;
//    } catch (예외1) {
//        실행문;
//    } catch (예외2) {
//        실행문;
//    } finally {
//        항상 실행;
//    }
//      상위 예외 클래스가 하위 예외 클래스보다 아래쪽에 위치 해야함(아니면 컴파일 에러)
     // throws
    public static void main(String[] args) { // 예외를 처리하지 않고 던짐
        TIL til = new TIL();
        try {
            til.readFile();     // 2. 호출한 main쪽에서 처리함 (그래서 main에서 try-catch해야함)
        } catch (IOException e) {
            System.out.println("던지는바람에 main에서 처리했다");
        }
    }
    public void readFile() throws IOException {   // 1. 이쪽에 throws를 하면 (위로)
        BufferedReader reader = new BufferedReader(new FileReader("GrowthTheory.txt"));
        System.out.println(reader.readLine());
        reader.close();
    }
}

