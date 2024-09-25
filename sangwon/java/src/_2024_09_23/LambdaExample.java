package _2024_09_23;

// 어노테이션 @FunctionalInterface 작성해서 추상메소드 1개로 제한하기
@FunctionalInterface
public interface LambdaExample {
    int method(int a, int b);
//    double method(double a, double b); // 2개만들면 에러
}
