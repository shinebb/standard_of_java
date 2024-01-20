package chapter04;

import java.util.Scanner;

public class Ex_while {
    public static void main(String[] args){

        int i = 5;
        while(i--!=0){
           System.out.println(i+" - I can do it");
        }


        i = 0;
        int sum = 0;

        //i를 1씩 증가시켜서 sum에 계속 더해나간다.
        //sum이 100을 넘으면 끝남.
        while(sum <= 100){
            System.out.printf("%d - %d%n", i, sum);
            sum += ++i;
        }

        sum = 0;
        int num = 0;

        System.out.print("숫자를 입력하세요. (예:123456) > ");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine(); //화면을 통해 입력받은 문자열
        num = Integer.parseInt(tmp);     //입력받은 문자열(tmp)을 int 형변환

        while(num != 0){
            //num을 10으로 나눈 나머지를 sum에 더함
            sum += num%10; //sum= sum + (num%10); //10으로 나눈 나머지는 마지막 자리수 하나만 남게 된다.
            System.out.printf("sun=%3d num=%d%n", sum, num);

            num /= 10; // num= num / 10; //num을 10으로 나눠 계산된 나머지(마지막 자리수)는 버린다.
        }
        System.out.println("각 자리수의 합 : " + sum);

    }
}
