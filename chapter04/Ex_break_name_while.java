package chapter04;

import java.util.Scanner;

public class Ex_break_name_while {
    public static void main(String[] args){


        int menu = 0;
        int num = 0;

        Scanner scanner = new Scanner(System.in);

        //무한반복문
        //while문에 outer라는 이름을 붙인다.
        outer: while(true){
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

            for(;;){
                System.out.print("계산할 값을 입력하세요.(계산 종료:0, 전체 종료:99) > ");
                tmp = scanner.nextLine();
                num = Integer.parseInt(tmp);

                if (num == 0) {
                    break;  //계산 종료. for문을 벗어난다.
                    //for문만 벗어나서 while문으로 돌아가 메뉴선택이 시작된다.
                }

                if(num==99){
                    break outer; //전체 종료. for문과 while문을 모두 벗어난다.
                }

                switch(menu){
                    case 1:
                        System.out.println("result="+num*num);
                        break;
                    case 2:
                        System.out.println("result="+Math.sqrt(num)); //제곱근(루트)
                        break;
                    case 3:
                        System.out.println("result="+Math.log(num)); //로그
                        break;
                }
            }
        }
        System.out.println("프로그램이 종료 되었습니다.");
    }
}
