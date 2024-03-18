package chapter11;

import java.util.Arrays;
import java.util.Comparator;

public class Ex_compare {
    public static void main(String[] args){
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr); //String의 Comparable 구현에 의한 정렬
        System.out.println("strArr = " + Arrays.toString(strArr)); //Dog 대문자가 제일 먼저 옴

        //Arrays.sort(정렬대상, 정렬기준);
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분안함
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending()); //역순 정렬(내림차순)
        System.out.println("strArr = " + Arrays.toString(strArr));
    }
}

class Descending implements Comparator {
    public int compare(Object o1, Object o2){
        if(o1 instanceof Comparable && o2 instanceof Comparable){
            Comparable c1 = (Comparable)o1;
            Comparable c2 = (Comparable)o2;

            return c1.compareTo(c2) * -1; //기본 정렬 기준에서 -1을 곱해서 기본 정렬방식의 역으로 변경한다.
            //또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.
        }
        return -1;
    }
}