package chapter11;

import java.util.*;

public class Ex_HashSet {
    public static void main(String[] args) {
        Object[] objArr = {"1", new Integer(1),"2","2","3","3","4","4","4"};
        Set set = new HashSet();

        for(int i=0; i<objArr.length; i++){
            set.add(objArr[i]); //HashSet에 objArr의 요소들을 저장한다.
            //System.out.println(set.add(objArr[i])); //add할 수 있으면 true, 중복 값으로 add할 수 없으면 false
        }

        //HashSet에 저장된 요소들을 출력한다.
        System.out.println(set); //[1,1,2,3,4] = HashSet은 중복이 되지 않는다.
        //첫번째 1은 String 문자열이고, 두번째 1은 Integer 객체이기 때문에 들어감

        //HashSet에 저장된 요소들을 출력한다.(Iterator 이용)
        Iterator it = set.iterator();

        while(it.hasNext()){ //읽어올 요소가 남아있는지 확인
            System.out.println(it.next()); //요소 하나 꺼내오기
        }


        /* Ex_2 */
        Set set1 = new HashSet();

        for(int i=0; set1.size()<6; i++){
            int num = (int)(Math.random()*45)+1;
            set1.add(num);
        }

        //Set은 정렬 불가. 따라서 List로 옮기고 List를 정렬한다.
        List list = new LinkedList(set1); //LinkedList(Collection c)
        Collections.sort(list); //Collections.sort(List list)
        System.out.println(list);
    }
}
