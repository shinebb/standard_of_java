package chapter04;

import java.util.Scanner;

public class Ex_if_elseif {
    public static void main(String[] args){
        int score = 0;    //점수 저장
        //char grade = ' '; //학점 저장(공백으로 초기화)
        char grade = 'D';  //처음에 D로 초기화한다면 else{grade='d'} 코드를 생략할 수 있다.

        System.out.print("점수를 입력하세요. > ");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();  //화면을 통해 입력받은 숫자를 score에 저장

        if(score >= 90){    //score가 90점 보다 같거나 크면 A학점
            grade = 'A';
        }else if(score >= 80){ //score가 80점 보다 같거나 크기 B학점
            grade = 'B';
        }else if(score >= 70){ //score가 70점 보다 같거나 크면 C학점
            grade = 'C';
        }/*else{                 //나머지는 D학점
            grade = 'D';
        }*/

        System.out.println("당신의 학점은 " + grade + "입니다.");
        //입력한 점수가 70이라면 C
        //입력한 점수가 63이라면 D
    }
}
