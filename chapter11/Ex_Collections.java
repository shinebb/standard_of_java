package chapter11;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static java.util.Collections.*; // import static 은 static 멤버를 사용할 때 앞에 클래스 이름을 생략가능

public class Ex_Collections {
    public static void main(String[] args){
        List list = new ArrayList();
        System.out.println(list);

        addAll(list, 1,2,3,4,5); //import static으로 Collections.addAll() 클래스명 생략가능
        System.out.println(list);

        rotate(list, 2); //오른쪽으로 두 칸씩 이동(반시계방향으로 두번 회전)
        System.out.println(list);

        swap(list, 0, 2);   //첫번째와 세번째를 교환(swap)
        System.out.println(list);

        shuffle(list);          //저장된 요소의 위치를 임의로 변경
        System.out.println(list);

        sort(list, reverseOrder()); //역순 정렬 reverse(list);의 반대
        System.out.println(list);

        sort(list);             //정렬
        System.out.println(list);


        int idx = binarySearch(list, 3); //3이 저장된 위치(index) : 정렬되어있어야지 정상작동
        System.out.println("index of 3  = " + idx);

        System.out.println("max = " + max(list)); //최대값
        System.out.println("min = " + min(list)); //최소값
        System.out.println("min = " + max(list, reverseOrder())); //최소값, 반대로

        fill(list, 9);      //list를 9로 채운다.
        System.out.println("list = " + list);

        //list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경불가
        List newList = nCopies(list.size(), 2);
        System.out.println("newList = " + newList);


        System.out.println(disjoint(list, newList)); //공통 요소가 없으면 true

        copy(list, newList); //newList를 list로 복사
        System.out.println("newList = " + newList);
        System.out.println("list = " + list);

        replaceAll(list, 2, 1); //list에서 2를 1로 바꿈
        System.out.println("list = " + list);

        Enumeration e = enumeration(list); //Iterator랑 비슷.
        ArrayList list2 = list(e);

        System.out.println("list2 = " + list2);
    }
}
