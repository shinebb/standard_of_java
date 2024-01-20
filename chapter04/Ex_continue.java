package chapter04;

import java.util.Scanner;

public class Ex_continue {
    public static void main(String[] args){

        for(int i=0; i<=10; i++) {
            if(i%3 == 0){ //3의 배수일 때 해당 반복문 건너뛰고 다음 차례(조건식)로 넘어간다.
                continue;
            }
            System.out.println(i);
        }


        int menu = 0;

        Scanner scanner = new Scanner(System.in);

        //무한반복문
        while(true){ 
            System.out.println("(1) square");
            System.out.println("(2) square root");
            System.out.println("(3) root");
            System.out.print("원하는 메뉴(1~3)를 선택하세요.(종료:0) > ");

            String tmp = scanner.nextLine();
            menu = Integer.parseInt(tmp);

            //0으로 종료 break가 걸릴 때까지 무한 반복된다.
            if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }else if(!(1<=menu && menu <= 3)){
                System.out.println("메뉴를 잘못 선택하셨습니다.(종료는 0)");
                continue; //다시 조건식으로 돌아감
            }
            System.out.println("선택하신 메뉴는 " + menu + "번입니다.");
        }
    }
}
