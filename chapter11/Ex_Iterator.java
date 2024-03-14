package chapter11;

import java.util.*;

public class Ex_Iterator {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        HashSet set = new HashSet(); //for문에서 안돌아감
        Collection c = new TreeSet(); //set은 collection의 자손 = 이렇게 사용하면 객체만 변경해주면 된다.



        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator it = list.iterator();

        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }

        //iterator는 1회용이라 다쓰고나면 다시 얻어와야 한다.
        it = list.iterator();

        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }

        System.out.println("for문");

        //for문의 단점. ArrayList가 아닌 HashSet 객체는 돌릴 수 없다.
        for(int i=0; i<list.size(); i++){
            Object obj = list.get(i);
            System.out.println(obj);
        }
    }
}
