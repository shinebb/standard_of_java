package chapter05;

public class Ex_two_array_avg {
    public static void main(String[] args) {

        int[][] score = {
                {100, 100, 100},
                {20, 20, 20},
                {30, 30, 30},
                {40, 40, 40},
                {50, 50, 50}
        }; //5행 3열 -> new int[5][3]

        //과목별 총점
        int korTotal = 0;
        int engTotal = 0;
        int mathTotal = 0;

        System.out.println("번호 국어 영어 수학 총점 평균");
        System.out.println("===============================");

        for(int i=0; i<score.length; i++){
            int sum = 0; //개인별 총점
            float avg = 0; //개인별 평균

            korTotal += score[i][0];
            engTotal += score[i][1];
            mathTotal += score[i][2];

            for(int j=0; j<score[i].length; j++){
                sum += score[i][j];
            }
            avg = sum / (float)score[i].length;
            System.out.printf(" %d  %d  %d  %d  %d  %.1f%n", (i+1), score[i][0], score[i][1], score[i][2], sum, avg);
        }
        System.out.println("===============================");
        System.out.printf("총점 : %d %d %d", korTotal, engTotal, mathTotal);
    }
}
