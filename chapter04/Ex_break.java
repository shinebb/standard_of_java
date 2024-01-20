package chapter04;

import java.util.Scanner;

public class Ex_break {
    public static void main(String[] args){

        int sum = 0;
        int i = 0;
        
        //무한반복문
        while(true){ //for문 무한반복은 for(;;){} or for(;true;) -> while문은 true생략불가
            if(sum > 100){ //sum이 100이 넘으면 break문 실행으로 while문을 빠져나온다.
                break;
            }
            ++i;
            sum += i;
        }

        System.out.println("i=" + i);
        System.out.println("sum=" + sum);
    }
}
