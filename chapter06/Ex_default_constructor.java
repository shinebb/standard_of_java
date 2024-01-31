package chapter06;

class Data_1 {
    int value;

    //생성자가 없으므로 기본 생성자 자동 추가됨
}
class Data_2 {
    int value;

    Data_2() {} //기본생성자
    //생성자가 있므로 기본 생성자 자동 추가 X

    Data_2(int x) {
        value= x;
    }
}

public class Ex_default_constructor {
    public static void main(String[] args){
        Data_1 d1 = new Data_1();
        Data_2 d2 = new Data_2(); //Data_2의 기본 생성자가 없으면 compile error 발생.
    }
}
