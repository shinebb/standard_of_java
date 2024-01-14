package chapter02;

import java.util.Scanner;

public class Ex_scanner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //System.in = 화면에서 입력

        int num = scanner.nextInt(); //입력받기(정수)
        int num2 = scanner.nextInt();
        System.out.println(num);
        System.out.println(num2);

        String input = scanner.nextLine(); //입력받기(한 행)
        System.out.println(input);

        int num3 = Integer.parseInt(input); //정수아니면 error
        System.out.println(num3);
    }
}
