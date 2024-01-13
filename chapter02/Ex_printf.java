package chapter02;

public class Ex_printf {
    public static void main(String[] args){
        //print() : 출력 후에 줄바꿈 안함
        //println() : 출력 후에 줄바꿈 함

        System.out.println(10/3);  //두개 다 정수라서 3
        System.out.println(10.0/3);  //3.3333333333...
        System.out.println("---");
        System.out.printf("%d%n", 15); //15  =10진수
        System.out.printf("%o%n", 15); //17  =8진수
        System.out.printf("%x%n", 15); //f   =16진수
        System.out.printf("%#o%n", 15); //017  =(+접두사)8진수
        System.out.printf("%#x%n", 15); //0xf  =(+접두사)16진수
        System.out.printf("%s%n", Integer.toBinaryString(15));  //1111  =2진수
        System.out.println("---");

        float f = 123.456789f;
        System.out.printf("%f%n", f); //123.456787  =소수점 아래 6자리/정밀도 7자리로 마지막 두자리는 의미x, 그래서 정밀도가 더 높은 double을 쓰는것이 좋음
        System.out.printf("%e%n", f); //1.234568e+02  =지수형식(e+02 = 10의 2승)(마지막 반올림)
        System.out.printf("%g%n", 123.456789); //123.457  =간략한 형식(소수점포함 7자리/마지막 반올림)
        System.out.printf("%g%n", 0.00000001); //1.00000e-8  =간략한 형식(지수형태로 나타내는게 더 간략하게 판단되면 지수형태로 나타냄)
        System.out.println("---");

        System.out.printf("[%5d]%n", 10);  //[   10] => 5자리까지 출력
        System.out.printf("[%-5d]%n", 10);  //[10   ] => 5자리까지 출력(-왼쪽정렬)
        System.out.printf("[%05d]%n", 10);  //[00010] => 빈자리 0으로 채움
        System.out.printf("[%5d]%n", 1234567);  //[1234567] => 저장된 값 그대로 출력

        double d = 1.23456789;
        System.out.printf("%f%n", d);  //1.234568
        System.out.printf("d=%14.10f%n", d);  //d=  1.2345678900 => 전체 14자리 중 소수점 아래 10자리
        System.out.printf("d=%14.6f%n", d);  //d=      1.234568 => 전체 14자리 중 소수점 아래 6자리
        System.out.printf("d=%.6f%n", d);  //d=1.234568 => 전체생략가능/소수점 아래 6자리

        System.out.printf("[%s]%n", "www.codechobo.com"); //[www.codechobo.com]
        System.out.printf("[%20s]%n", "www.codechobo.com"); //[   www.codechobo.com] => 전체 20자리
        System.out.printf("[%-20s]%n", "www.codechobo.com"); //[www.codechobo.com   ]  => 전체 20자리 + 왼쪽정렬
        System.out.printf("[%.10s]%n", "www.codechobo.com"); //[www.codech] => 10자리 자르기


        //System.out.printf("[%s]%n", url);

    }
}
