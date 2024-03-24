package chapter12;

import java.util.ArrayList;

public class Ex_Generics2 {
    public static void main(String[] args){
        ArrayList list = new ArrayList();

        list.add(new Tv());
        list.add(new Audio());

        ArrayList<Tv> list2 = new ArrayList<Tv>(); //Tv타입의 객체만 저장 가능

        list2.add(new Tv());
        //list2.add(new Audio()); //Tv 타입이 아니므로 에러 발생

        Tv t = (Tv) list.get(0); //list의 첫번째 요소를 꺼낸다. 형변환 필요.
        Tv t2 = list2.get(0); //list의 첫번째 요소를 꺼낸다. 형변환 불필요.

    }
}

class Tv {}
class Audio {}
