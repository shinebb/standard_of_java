package chapter05;

import java.util.Arrays;

public class Ex_arrays_class {
    public static void main(String[] args) {

        /********** 
        * toString(), deepToString() 배열 출력 
        **********/
        int[] arr = {0,1,2,3,4}; //1차원 배열 arr
        int[][] arr2D = {{11,12}, {21,22}}; //2차원배열 arr2D

        System.out.println(Arrays.toString(arr));  //1차원배열 출력
        System.out.println(Arrays.deepToString(arr2D));  //2차원배열 출력

        String[][] str2D = {{"aaa","bbb"},{"AAA","BBB"}};
        String[][] str2D2 = {{"aaa","bbb"},{"AAA","BBB"}};

        System.out.println(Arrays.equals(str2D, str2D2)); //false -> 1차원 비교이기때문에
        System.out.println(Arrays.deepEquals(str2D, str2D2)); //true


        /********** 
         * copyOf(), copyOfRange() 배열 복사
         **********/
        int[] arr2 = Arrays.copyOf(arr, arr.length); //arr배열 복사
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = Arrays.copyOf(arr, 7); //arr3=[0,1,2,3,4,0,0]
        int[] arr4 = Arrays.copyOfRange(arr, 2, 4); //arr5=[2,3] <-4는 불포함
        int[] arr5 = Arrays.copyOfRange(arr, 0, 7); //arr6=[0,1,2,3,4,0,0]

        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));


        /********** 
         * sort() 배열 오름차순 정렬
         **********/
        int[] arr6 = {3,4,1,0,2};
        System.out.println(Arrays.toString(arr6));
        Arrays.sort(arr6); //배열 오름차순 정렬
        System.out.println(Arrays.toString(arr6)); //[0, 1, 2, 3, 4]

    }
}
