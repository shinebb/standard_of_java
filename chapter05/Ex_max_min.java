package chapter05;

public class Ex_max_min {
    public static void main(String[] args){

        int[] score = {79, 88, 91, 33, 100, 55, 95};

        int max = score[0]; //배열의 첫 번째 값으로 최대값을 초기화
        int min = score[0]; //배열의 첫 번째 값으로 최소값을 초기화

        for(int i=1; i<score.length; i++){ //배열의 두 번째 요소부터 읽기 위해서 변수 i의 값을 1로 초기화(이미 max와 min 변수가 첫 번째 값으로 초기화 되어있기 때문에)
            if(score[i] > max){
                max = score[i];
            }else if(score[i] < min){
                min = score[i];
            }
        }

        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);

    }
}
