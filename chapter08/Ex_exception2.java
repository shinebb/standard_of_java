package chapter08;

public class Ex_exception2 {
    public static void main(String args[]){
        //throw new Exception(); //컴파일에러 O, try-catch문이 없으므로 error

        try {
            throw new Exception();
        } catch(Exception e) {
            //catch로 Exception 예외처리 가능.
        }

        throw new RuntimeException(); //컴파일에러 X,  try-catch문이 없어도 컴파일 ok. 그러나 실행시 error로 프로그램 종료
    }
}
