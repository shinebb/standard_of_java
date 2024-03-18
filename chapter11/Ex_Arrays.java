package chapter11;

import java.util.Arrays;

public class Ex_Arrays {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4};
        int[][] arr2D = {{11,12,13},{21,22,23}};

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arr2D = " + Arrays.toString(arr2D)); //다차원배열은 toString 사용하면 이상하게 나옴
        System.out.println("arr2D = " + Arrays.deepToString(arr2D)); //다차원 배열

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, 3);
        int[] arr4 = Arrays.copyOf(arr, 7);
        int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
        int[] arr6 = Arrays.copyOfRange(arr, 0, 7);

        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println("arr3 = " + Arrays.toString(arr3));
        System.out.println("arr4 = " + Arrays.toString(arr4));
        System.out.println("arr5 = " + Arrays.toString(arr5));
        System.out.println("arr6 = " + Arrays.toString(arr6));

        int[] arr7 = new int[5];
        Arrays.fill(arr7, 9); //arr = [9,9,9,9,9]
        System.out.println("arr7 = " + Arrays.toString(arr7));

        Arrays.setAll(arr7, i -> (int)(Math.random()*6)+1);
        System.out.println("arr7 = " + Arrays.toString(arr7));

        for(int i : arr7){ //향상된 for문 for(int i=0; i<arr7; i++)
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(new String(graph)+i);
        }

        String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};

        System.out.println(Arrays.equals(str2D, str2D2));     //false
        System.out.println(Arrays.deepEquals(str2D, str2D2)); //true

        char[] chArr = {'A', 'D', 'C', 'B', 'E'};

        System.out.println("chArr = " + Arrays.toString(chArr));
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B')); //음수 -2가 나옴 => 잘못된결과(정렬안해줘서)
        System.out.println(" = After Sorting = ");
        Arrays.sort(chArr); //배열을 정렬. binarySearch 하기전에는 반드시 정렬먼저
        System.out.println("chArr = " + Arrays.toString(chArr));
        System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));
    }
}
