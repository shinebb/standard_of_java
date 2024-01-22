package chapter05;

import java.util.Arrays;

public class Ex_shuffle {
    public static void main(String[] args){

        int[] numArr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(numArr));

        for(int i=0; i<numArr.length; i++){
            int n = (int)(Math.random()*10); //0~9중의 한 값을 임의로 얻는다.
            int tmp = numArr[0];  //tmp=0
            numArr[0] = numArr[n]; //numArr[0]=8
            numArr[n] = tmp; //numArr[8]=0
        }
        System.out.println(Arrays.toString(numArr));
    }
}
