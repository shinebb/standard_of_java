package chapter03;

public class Ex_math_round {
    public static void main(String[] argr){
        double pi = 3.141592;
        double shortPi = Math.round(pi * 1000) / 1000.0;

        System.out.println(shortPi);  //3.142
        System.out.println(pi*1000);  //3141.592
        System.out.println(Math.round(pi*1000));  //3142
        System.out.println(Math.round(pi*1000)/1000);  //3
        System.out.println(Math.round(pi*1000)/1000.0);  //3.142
        System.out.println((double)Math.round(pi*1000)/1000);  //3.142


        System.out.println(pi*1000); //3141.592에서 소수점 뒷자리를 자르고싶다면?
        System.out.println((int)(pi*1000));

    }
}
