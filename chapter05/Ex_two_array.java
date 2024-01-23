package chapter05;

public class Ex_two_array {
    public static void main(String[] args){

        int[][] score = {
                {100, 100, 100},
                {20, 20, 20, 20}, //열이 달라도 구현 가능 => 다만 보통 정사각형의 배열만 사용함
                {30, 30, 30},
                {40, 40, 40}
        }; //4행 3열 -> new int[4][3]

        int sum = 0;

        for(int i=0; i<score.length; i++){ //score.length == 4
            for(int j=0; j<score[i].length; j++){ //score[i].length == 3
                System.out.printf("score[%d][%d]=%d%n", i, j, score[i][j]);

                sum += score[i][j];
            }
        }

        System.out.println("sum = " + sum);
    }
}
