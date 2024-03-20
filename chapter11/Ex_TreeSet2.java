package chapter11;

import java.util.TreeSet;

public class Ex_TreeSet2 {
    public static void main(String[] args){
        TreeSet set = new TreeSet(); //범위 검색에 유리(from~to)

        String from = "b";
        String to = "d";

        set.add("abc");
        set.add("alien");
        set.add("bat");
        set.add("car");
        set.add("Car");
        set.add("disc");
        set.add("dance");
        set.add("dZZZZ");
        set.add("dzzzz");
        set.add("elephant");
        set.add("elevator");
        set.add("fan");
        set.add("flower");

        System.out.println(set);
        System.out.println("range search : from " + from + " to " + to);
        System.out.println("result1 : " + set.subSet(from, to)); //from보다 같거나 크고 to보다 작다(from<=x<to)
        System.out.println("result2 : " + set.subSet(from, to + "zzz"));


        TreeSet set2 = new TreeSet(); //Set으로 바꾸면 안됨. headSet, tailSet, subSet 메서드들은 TreeSet에만 존재한다.
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for(int i=0; i<score.length; i++){
            set2.add(score[i]);
        }

        System.out.println("50보다 작은 값 : " + set2.headSet(50)); //~50까지이니까 50 미포함
        System.out.println("50보다 큰 값 : " + set2.tailSet(50)); //50부터~ 니까 50포함
        System.out.println("40과 80 사이의 값 : " + set2.subSet(40, 80));
    }
}
