package chapter07;


class A  {
    public void method(B b) {
        b.method();
    }
}
class B {
    public void method() {
        System.out.println("B클래스의 메서드");
    }
}

class C {
    public void method() {
        System.out.println("C클래스의 메서드");
    }
}

interface I {
    public void method();
}

class AA  {
    public void method(I i) { //인터페이스 I를 구현한 매개변수만 들어올 수 있다.
        i.method();
    }
}

class BB implements I {
    public void method() {
        System.out.println("BB클래스의 메서드");
    }
}

class CC implements I {
    public void method() {
        System.out.println("CC클래스의 메서드");
    }
}


public class Ex_interface2 {
    public static void main(String[] args){
        A a = new A();
        a.method(new B()); //A가 B를 사용(의존)

        /* 인터페이스가 없을 때, B가 아닌 C로 바꿔야한다면. main()에서 호출 객체도 new B()가 아닌 new C()로
        * 바꿔줄 뿐만아니라 A의 Method()의 매개변수도 C로 바꿔줘야한다. */

        AA aa = new AA();
        aa.method(new BB()); //AA가 BB를 사용(의존)
        aa.method(new CC()); //AA가 CC를 사용(의존)

        /* 인터페이스를 사용하면 A의 method()에 인터페이스 I(I를 구현한 클래스)만 들어올 수 있으므로
        * AA를 건드리지 않고, I를 구현한 BB에서 CC로 손쉽게 바꿀 수 있다. */

    }
}
