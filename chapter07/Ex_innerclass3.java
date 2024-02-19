package chapter07;


public class Ex_innerclass3 {

    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        int iiv = outerIv;  //1. 외부 클래스의 private 멤버도 접근가능하다.
        int iiv2 = outerCv;
    }

    static class StaticInner{
        //int siv = outerIv;  //#에러# static 클래스는 외부 클래스의 인스턴스멤버에 접근할 수 없다.
        static int scv = outerCv;
    }

    void myMethod() {
        int lv = 0;
        final int LV = 0; //final 생략 가능

        //lv = 1; // 값을 바꾸면 상수가 아닌 변수로 인식하기 때문에 liv3 에러

        class LocalInner { //2. 지역 내부 클래스. 지역 내부 클래스를 감싸고 있는 메서드의 상수만 사용가능
            int liv = outerIv;
            int liv2 = outerCv;
            //외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근가능하다.
            int liv3 = lv; //원래는 에러지만 현재 가능.(값이 바뀌지 않는 변수는 상수로 간주하기때문에)
            int liv4 = LV;
        }
    }

    public static void main(String[] args){

    }
}
