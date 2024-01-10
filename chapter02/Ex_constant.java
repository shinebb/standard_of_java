package chapter02;

public class Ex_constant {
    public static void main(String[] args){

        int score = 100;
        score = 200;

        System.out.println(score);

        final int f_score = 100;
        //f_score = 200; //상수에 새로운 값을 넣을 수 없으므로 에러 발생
        final int n_score;
        n_score = 200; //선언 후 초기화 가능

        System.out.println(f_score);

        boolean power = true;
        //byte b = 128;  //byte타입 범위를 벗어남으로 에러 발생

        int oct = 010;  //8진수, 10진수로는 8
        int hex = 0x10;  //16진수, 10진수로는 16
        System.out.println(oct); //8
        System.out.println(hex); //16

        long l = 1000_000_000; //10억=int형 리터럴
        //long ll = 10_000_000_000; //int형 범위를 벗어남으로 에러 발생
        long ll = 10_000_000_000L; //접미사 L를 붙여 long타입의 리터럴로 만들어준다.

        //float f = 3.14; //float < double로 에러발생
        float f = 3.14f; //접미사 f를 붙여 float 타입의 리터럴로 만들어준다.
        double d = 3.14;
        double dd = 3.14f; //double > float이므로 에러가 발생하지 않음.

        System.out.println(10.); //10.0
        System.out.println(.10); //0.1 (0생략)
        System.out.println(10f); //10.0
        System.out.println(1e3); //1000.0

    }
}
