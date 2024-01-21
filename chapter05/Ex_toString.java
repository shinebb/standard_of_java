package chapter05;

import java.util.Arrays;

public class Ex_toString {
    public static void main(String[] args){

        int[] iArr = {100, 95, 80, 70, 60}; //길이가 5인 int배열 선언

        System.out.println(iArr); //배열의 주소값 출력됨

        //값을 출력하려면 for
        for(int i=0; i<iArr.length; i++){
            System.out.println(iArr[i]);
        }

        //또는 Arrays.toString() 사용
        System.out.println(Arrays.toString(iArr));
        System.out.println();


        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] arr3 = {100, 95, 80, 70, 60};
        char[] chArr = {'a', 'b', 'c', 'd'};

        for(int i=0; i<arr1.length; i++){
           arr1[i] = i + 1; //1~10의 순자를 순서대로 배열에 넣는다.
        }

        for(int i=0; i<arr2.length; i++){
            arr2[i] = (int)(Math.random()*10)+1; //1~10의 랜덤값을 배열에 저장
        }

        //배열에 저장된 값들 출력
        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i]+",");
        }
        System.out.println();

        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(chArr));
        System.out.println(arr3);  //주소값 출력
        System.out.println(chArr); //char타입 배열일때만 value값 출력



    }
}
