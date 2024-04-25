package chapter14;

public class Ex_lambda {
    public static void main(String[] args){
        //Object obj = (a,b) -> a > b ? a : b; //람다식. 익명객체

        Object obj = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        //int value = obj.max(3,5); //호출불가. Object에는 max()가 없다. -> 그래서 필요한건 함수형 인터페이스
    }
}
