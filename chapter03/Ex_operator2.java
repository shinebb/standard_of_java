package chapter03;

public class Ex_operator2 {
    public static void main(String[] args){
        int a = 1_000_000;  //1백만 = 10의 6제곱
        int b = 2_000_000;  //2백만 = 10의 6제곱

        //10의 12제곱 => int의 범위는 10의 9제곱
        long c = a*b;

        System.out.println(c); //-1454759936 -> 오버플로우

        long d = (long)a * b; //어느한쪽은 형변환하여 다른 하나 자동형변환 진행됨

        System.out.println(d); //2000000000000  -> long타입으로 변환하여 정상결과 노출
        
    }
}
