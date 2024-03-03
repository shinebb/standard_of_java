package chapter08;

import java.util.ArrayList;

public class Ex_autoboxing {

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(new Integer(100)); //list에는 Integer 객체만 가능(이게 정석)
        list.add(100);  //오토박싱이 가능하여 이것도 가능하다.

        Integer i = list.get(0); //list에 저장된 첫번째 객체를 꺼낸다.
        int i2 = list.get(0).intValue(); //intValue()로 Integer를 int로 변환(이게 정석)
        int i3 = list.get(0); //컴파일러의 오토언박싱으로 int로 자동 변환된다.

        int ii = 10;

        //기본형을 참조형으로 형변환(형변환 생략가능)
        Integer intg = (Integer)ii; //Integer intg = Integer.valueOf(ii);
        Object obj = (Object)ii; //Object obj = (Object)Integer.valueOf(ii);

        Long lng = 100L; //Long lng = new Long(100L);

        int ii2 = intg + 10; //참조형과 기본형간의 연산 가능
        long ll = intg + lng; //참조형 간의 덧셈도 가능

        Integer intg2 = new Integer(20);
        int ii3 = (int)intg2; //참조형을 기본형으로 형변환도 가능(형변환 생략가능)

    }
}
