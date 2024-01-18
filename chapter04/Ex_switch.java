package chapter04;

import java.util.Scanner;

public class Ex_switch {

    public static void main(String[] args) {
        System.out.print("현재 월을 입력하세요. > ");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();  //화면을 통해 입력받은 숫자를 month에 저장

        switch(month){
            case 3:
            case 4:
            case 5:
                System.out.println("현재의 계절은 봄입니다.");
                break;
            case 6: case 7: case 8:
                System.out.println("현재의 계절은 여름입니다.");
                break;
            case 9: case 10: case 11:
                System.out.println("현재의 계절은 가을입니다.");
                break;
            default:
            //case 12: case 1: case 2:
                System.out.println("현재의 계절은 겨울입니다.");
                break;
        }
        //default값이 없을 때 해당 case가 없다면 아무것도 실행되지 않고 switch문을 빠져나온다.
        //봄계절에 break문이 없다면 봄과 여름 모두 실행된다. (그리고 여름 break문에서 빠져나온다.)
    }
}
