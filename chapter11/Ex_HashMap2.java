package chapter11;

import java.util.*;

public class Ex_HashMap2 {
    public static void main(String[] args){
        HashMap map = new HashMap();

        map.put("김자바", 90);
        map.put("김자바", 100); //키값이 일치하기때문에 벨류만 100으로 변경
        map.put("이자바", 100);
        map.put("강자바", 80);
        map.put("안자바", 90);

        Set set = map.entrySet(); //key와 value이 하나의 엔트리로 set으로 반환
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();
            System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
        }

        set = map.keySet(); //key값만 가져옴
        System.out.println("참가자 명단 : " + set);

        Collection values = map.values(); //value만 가져옴, max()와 min()을 사용하기 위해 Collection에 담아줌
        it = values.iterator();

        int total = 0;

        while(it.hasNext()){
            int i =(int)it.next();
            total += i;
        }

        System.out.println("총점 : " +  total);
        System.out.println("평균 : " + (float)total/set.size());
        System.out.println("최고점수 : " + Collections.max(values));
        System.out.println("최저점수 : " + Collections.min(values));

    }
}
