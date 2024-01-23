package chapter05;

import java.util.Scanner;

public class Ex_two_array_string {
    public static void main(String[] args) {

        String[][] words = {
                {"chair", "의자"},      //words[0][0], words[0][1]
                {"computer", "컴퓨터"}, //words[1][0], words[1][1]
                {"integer", "정수"}     //words[2][0], words[2][1]
        }; //3행 2열

        Scanner scanner = new Scanner(System.in);

        for(int i=0; i<words.length; i++){
            System.out.printf("Q%d. %s의 뜻은? > ", (i+1), words[i][0]);  //%s 문자열

            String tmp = scanner.nextLine();

            if(tmp.equals(words[i][1])){
                //System.out.println("정답입니다.\n");
                System.out.printf("정답입니다. %n%n"); //os마다 다르기 때문에 %n을 사용하는것이 좋다.
            }else{
                System.out.println("틀렸습니다. 정답은 " + words[i][1] + "입니다.\n");
            }
        }
        System.out.println("참여해주셔서 감사합니다.");
    }
}
