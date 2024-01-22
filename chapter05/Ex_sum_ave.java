package chapter05;

public class Ex_sum_ave {
    public static void main(String[] args){

        int sum = 0; //총합을 저장하기 위한 변수
        float average = 0f; //평균을 저장하기 위한 변수

        int[] score = {100, 88, 100, 100, 90};

        for(int i=0; i<score.length; i++){
            sum += score[i];
            //sum = sum + score[0]
        }

        average = sum / (float)score.length; //계산 결과를 float 타입으로 얻기위한 형변환(한쪽만 형변환하면 됨)
        //int 95
        //float 95.6f
        //아무것도 안하면 95.0f

        System.out.println("총합 : " + sum);
        System.out.println("평균 : " + average);
    }
}
