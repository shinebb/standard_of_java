package chapter11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ex_HashMap3 {
    public static void main(String[] args){

        String[] data = {"A","K","A","K","D","K","A","K","K","Z","D"};

        HashMap map = new HashMap();

        for(int i=0; i<data.length; i++) {
            if(map.containsKey(data[i])){ // 키값이 있는지
                int value = (int)map.get(data[i]);
                map.put(data[i], value+1);
            }else { // 처음에는 없으니까 else 옴
                map.put(data[i], 1);
            }
        }

        Iterator it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            int value = (int)entry.getValue();
            System.out.println(entry.getKey() + " : " + value);
        }
    }
}
