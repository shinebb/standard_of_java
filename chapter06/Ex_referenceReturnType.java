package chapter06;

public class Ex_referenceReturnType {
    public static void main(String[] args){
        Data3 d = new Data3(); //객체생성
        d.x = 10;

        Data3 d2 = copy(d); //copy 메서드 호출하여 Date3 타입 변수에 저장
        //호출된 메서드의 반환타입과 받는 변수타입이 일치해야한다.
        //=> copy() 앞에 참조 변수가 없는 이유는(Ex_referenceReturnType e = new Ex_referenceReturnType; -> e.copy();)
        //1. copy()와 main 같은 class이기 때문에
        //2. static 메서드이기 때문에 객체 생성 없이 호출 가능하다.
        System.out.println("d.x : " + d.x);
        System.out.println("d2.x = " + d2.x); //10

    }

    //static 메서드 : 참조변수 생략가능 / 객체 생성 없이 호출 가능
    static Data3 copy(Data3 d) { //참조형 반환타입
        Data3 tmp = new Data3(); //새로운 객체 tmp를 생성한다.
        tmp.x = d.x; // d.x의 값을 tmp.x에 복사한다.

        return tmp; //복사한 객체의 주소를 반환한다.
    }

}

class Data3 {
    int x;
}
