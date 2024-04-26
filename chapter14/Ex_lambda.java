package chapter14;

public class Ex_lambda {
    public static void main(String[] args){
        //Object obj = (a,b) -> a > b ? a : b; //람다식. 익명객체

        /*Object obj = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };*/

        //int value = obj.max(3,5); //호출불가. Object에는 max()가 없다. -> 그래서 필요한건 함수형 인터페이스


        /*MyFunction obj = new MyFunction() {
            public int max(int a, int b) { //오버라이딩규칙 = 접근제어자는 좁게 못바꾼다. public 안붙이면 default 설정되어 error
                return a > b ? a : b;
            }
        };*/

        /*람다식
        * 람다식을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
        * */
        MyFunction f = (a, b) -> a > b ? a : b; //람다식 익명 객체

        int value = f.max(3,5);
        System.out.println("value = " + value);
    }
}

//함수형 인터페이스는 단 하나의 추상 메서드만 가져야 한다.
@FunctionalInterface
interface MyFunction {
    //public abstract int max(int a, int b);
    int max(int a, int b);
}