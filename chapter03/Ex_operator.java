package chapter03;

public class Ex_operator {
    public static void main(String[] args){
        int a = 10;
        int b = 4;

        System.out.printf("%d + %d = %d%n", a, b, a+b);
        System.out.printf("%d - %d = %d%n", a, b, a-b);
        System.out.printf("%d * %d = %d%n", a, b, a*b);
        System.out.printf("%d / %d = %d%n", a, b, a/b);
        //System.out.printf("%d / %f = %f%n", a, b, a/b); //에러
        System.out.printf("%d / %f = %f%n", a, (float)b, a/(float)b); //10 / 4.000000 = 2.500000
        //10/40.0f -> 10.0f/4.0f -> 2.5f
    }
}
