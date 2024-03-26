package chapter12;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex_Generics4 {
    public static void main(String[] args){
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("자바왕", 1, 1));
        list.add(new Student("자바짱", 1, 2));
        list.add(new Student("홍길동", 2, 1));

        //Iterator it = list.iterator(); //이렇게 선언하면 형변환 필요.
        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            //Student s = (Student)it.next(); //제네릭스를 사용하지 않으면 형변환 필요.

            //Student s = it.next(); //제네릭스를 사용하므로 형변환 필요 X
            //System.out.println(s.name);
            System.out.println(it.next().name); //형변환을 하지 않으면 훨씬 단축된 코드를 사용할 수 있다.
        }
    }
}

class Student {
    String name = "";
    int ban; //반
    int no;  //번호

    Student(String name, int ban, int no){
        this.name = name;
        this.ban = ban;
        this.no = no;
    }
}
