package chapter11;

import java.util.ArrayList;
import java.util.Collections;

public class Ex_ArrayList {
    public static void main(String[] args) {
        //기본 길이(용량, capacity)가 10인 ArrayList를 생성
        ArrayList list1 = new ArrayList(10);

        //list1.add(new Integer(5));
        //ArrayList에는 객체만 저장가능 -> autoboxing에 의해 기본형이 참조형으로 자동 변환된다.
        list1.add(5); //순서대로 저장된다.
        list1.add(4);
        list1.add(2);
        list1.add(0);
        list1.add(1);
        list1.add(3);

        ArrayList list2 = new ArrayList(list1.subList(1,4)); //1<=x<4 -> index 1부터 4까지의 객체를 가져와서 새로운 ArrayList를 만든다.
        print(list1, list2);

        //Collection은 인터페이스, Collections는 유틸 클래스 ->유틸클래스의 sort 메서드를 통해 오름차순 sorting이 가능하다.
        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        //containsAll -> list1에 list2의 모든 요소가 포함되어있는가
        System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));

        list2.add("B"); //list2에 B,C 추가
        list2.add("C");
        list2.add(3, "A"); //3번 인덱스에 "A"추가(중간에 삽입됨) //0, 2, 4, A, B, C
        print(list1, list2);
        
        list2.set(3, "AA"); //3번 인덱스의 요소를 AA로 변경
        print(list1, list2);

        list1.add(0, "1"); //문자열 "1"추가
        System.out.println("index = " + list1.indexOf("1")); //문자열 "1"의 위치 반환 => 0
        System.out.println("index = " + list1.indexOf(1)); //Integer 1의 위치 반환 => 2
        print(list1, list2);

        list1.remove(0); //0번 index에 위치한 객체 삭제
        list1.remove(new Integer(1)); //인덱스가 아닌 값으로 삭제하고 싶다면
        list1.remove("1"); //문자열 "1"인 요소를 삭제
        print(list1, list2);

        //list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
        System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
        print(list1, list2);


        //list2에서 list1에 포함된 객체들을 삭제한다.
        for(int i = list2.size()-1; i >= 0; i--){
            if(list1.contains(list2.get(i))){
                list2.remove(i);
            }
        }
        print(list1, list2);

    }

    static void print(ArrayList list1, ArrayList list2){
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();

    }
}
