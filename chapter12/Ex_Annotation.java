package chapter12;

class Parent {
    void parentMethod() {  }
}

class Child extends Parent {

    @Deprecated
    void parentmethod() { } //오버라이딩하려 있으나 실수로 이름을 잘못적음
                            //그러나 에러 발생X, 그냥 새로운 메서드 생성
    
    @Override
    void parentMethod() {  } //@Override 어노테이션을 붙이면 에러 잡아줌
}

@FunctionalInterface //함수형 인터페이스는 하나의 추상 메서드만 가능하다
interface Testable{
    void test(); //추상메서드
    //void check(); //추상메서드 하나만 가능
}

public class Ex_Annotation {

    @SuppressWarnings("deprecation") //Deprecated된 메서드 사용 했지만 알고있다. 경고 억제.
    public static void main(String[] args){
        Child c = new Child();
        c.parentmethod(); //@Deprecated 된 메서드 사용
    }
}
