package chapter06;

public class Ex_referenceParam {
    public static void main(String[] args){
        Data2 d = new Data2(); //객체생성
        d.x = 10;
        System.out.println("main() : x = " + d.x); //10

        change(d); //change 메서드 호출
        System.out.println("After change(d)");
        System.out.println("main() : x = " + d.x); //1000

    }

    static void change(Data2 d) { //참조형 매개변수
        d.x = 1000;
        System.out.println("change() : x = " + d.x); //1000

        //참조형 매개변수는 읽고 쓰기가 가능하다.
        //=> 매개변수가 참조형이면 그 객체의 주소를 넘겨줄 수 있다.
    }
}

class Data2 {
    int x;
}
