package _240910;

public class Calculator implements Cal{

    public int add(int num1,int num2){
       return num1 + num2;
    }
    public int subtract(int num1,int num2){
       return num1 - num2;
    }
    public int times(int num1,int num2){
       return num1 * num2;
    }
    public int divide(int num1,int num2) {
        if (num2 != 0) {    // 나누는값이 0이 아닐시 정상출력
            return num1 * num2;
        } else {            // 나누는값이 0일시 ERROR
            return Cal.ERROR;
        }
    }
}
