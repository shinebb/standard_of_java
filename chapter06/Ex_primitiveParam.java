package chapter06;

public class Ex_primitiveParam {
    public static void main(String[] args){
        Data d = new Data(); //객체생성
        d.x = 10;
        System.out.println("main() : x = " + d.x); //10

        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x); //10

    }

    static void change(int x) { //기본형 매개변수
        x = 1000;
        System.out.println("change() : x = " + x); //1000

        //기본형 매개변수는 읽기만 가능하다
        //=> 지역변수 x를 바꾼거지 Data의 x를 바꾼것이 아니기때문에.
    }
}

class Data {
    int x;
}
