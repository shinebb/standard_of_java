package chapter04;

import java.util.Scanner;

public class Ex_if_if {
    public static void main(String[] args){
        int score = 0;    //점수 저장
        char grade = 'D'; //학점 저장
        char opt = '0';   //+/-

        System.out.print("점수를 입력하세요. > ");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();  //화면을 통해 입력받은 숫자를 score에 저장

        if(score >= 90){    //score가 90점 보다 같거나 크면 A학점
            grade = 'A';
            if(score >= 98){
                opt = '+';
            }else if(score < 94){
                opt = '-';
            }
        }else if(score >= 80){ //score가 80점 보다 같거나 크기 B학점
            grade = 'B';
            if(score >= 88){
                opt = '+';
            }else if(score < 84){
                opt = '-';
            }
        }else if(score >= 70){ //score가 70점 보다 같거나 크면 C학점
            grade = 'C';
            if(score >= 78){
                opt = '+';
            }else if(score < 74){
                opt = '-';
            }
        }

        System.out.println("당신의 학점은 " + grade + opt + "입니다.");
        //입력한 점수가 92이라면 A-
        //입력한 점수가 63이라면 D0
    }
}
