package chapter08;

import java.util.NoSuchElementException;

public class Ex_exception {
    public static void main(String args[]){
        System.out.println(1);
        System.out.println(2);

        try{
            System.out.println(3);
            System.out.println(0/0); //예외 발생
            System.out.println(4); //실행되지 않는다.
        }catch(ArithmeticException ae){
            if(ae instanceof ArithmeticException){
                System.out.println("true");
            }
            ae.printStackTrace(); //예외정보확인
            System.out.println("예외메시지 : " + ae.getMessage());
            //System.out.println("ArithmeticException");
        }catch(Exception e){ //모든 예외의 최고조상으로 위에 catch문이 실행되지않는다면 해당 catch문 실행
            System.out.println("exception");

            //예외처리가 안된다면 에러 발생으로 프로그램이 비정상적으로 종료된다.
        }
        
    }
}
