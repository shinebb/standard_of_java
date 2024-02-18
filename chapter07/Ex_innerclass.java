package chapter07;



class AAA { //AAA는 BBB의 외부 클래스
    int i = 100;
    BBB b = new BBB();


    class BBB{  //BBB눈 AAA의 내부 클래스
        void method() {
            /*AAA a = new AAA();
            System.out.println(a.i);*/
            System.out.println(i); //내부 클래스이므로 객체 생성없이 외부 클래스의 멤버 접근가능
        }
    }
}

/*class BBB{
    void method() {
        AAA a = new AAA();
        System.out.println(a.i);
    }
}*/

class CCC {
    //BBB b = new BBB(); //BBB가 AAA의 내부 클래스로 정의되면서 사용불가.
}

public class Ex_innerclass {
    public static void main(String[] args){
       /* BBB b = new BBB();
        b.method();*/ //독립적인 클래스가 아니므로 객체 접근 불가

    }
}
