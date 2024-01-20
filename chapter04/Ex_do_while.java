package chapter04;

import java.util.Scanner;

public class Ex_do_while {
    public static void main(String[] args){

        int input = 0;
        int answer = 0;

        answer = (int)(Math.random() * 100) + 1; //1~100사이의 읨의의 수를 저장
        System.out.println("answer = " + answer);
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("1과 100사이의 정수를 입력하세요. > ");
            input = scanner.nextInt();

            if(input > answer){
                System.out.println("더 작은 수로 다시 시도해보세요.");
            }else if(input< answer){
                System.out.println("더 큰 수로 다시 시도해주세요.");
            }
        }while(input!=answer);

        System.out.println("정답입니다.");


        //while문이면 입력받는 부분이 중복되게 됨.
        /*
        System.out.print("1과 100사이의 정수를 입력하세요. > ");
        input = scanner.nextInt();

        while(input!=answer){
            if(input > answer){
                System.out.println("더 작은 수로 다시 시도해보세요.");
            }else if(input< answer){
                System.out.println("더 큰 수로 다시 시도해주세요.");
            }
            System.out.print("1과 100사이의 정수를 입력하세요. > ");
            input = scanner.nextInt();
        }*/
    }
}
