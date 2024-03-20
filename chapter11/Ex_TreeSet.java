package chapter11;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Ex_TreeSet {
    public static void main(String[] args){
        Set set = new TreeSet(); //자동 정렬 OK, 정렬 필요 없음
        //Set set = new HashSet(); //정렬 X -> 정렬하려면 List에 담아서 sort() 진행

        for(int i = 0; set.size() < 6; i++){
            int num = (int)(Math.random()*45) + 1;
            set.add(num);
            //set.add(Test); //비교 기준이 없어서 에러 발생
            //set.add(TestComp); //Comparator 인터페이스 compare를 구현하여 에러발생 X, 정상 작동한다.
        }
        System.out.println(set);
    }
}

class Test {} //비교기준이 없음.

class TestComp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}