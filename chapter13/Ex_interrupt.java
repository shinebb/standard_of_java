package chapter13;

import javax.swing.*;

public class Ex_interrupt {
    public static void main(String[] args) throws Exception {
        Ex_interrupt_1 th1 = new Ex_interrupt_1();
        th1.start();

        System.out.println("isInterrupted() : " + th1.isInterrupted()); //false

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt(); //interrupt()를 호출하면, interrupted 상태가 true가 된다.
        System.out.println("isInterrupted() : " + th1.isInterrupted()); //true

        //interrupted() 또한 static 메서드로 현재 실행되는 main 스레드가 interrupt 되었는지 확인
        System.out.println("interrupted() : " + Thread.interrupted());  //false
        //th1을 확인하고 싶다면 Ex_interrupt_1 에서 확인해야함 
    }
}

class Ex_interrupt_1 extends Thread {
    public void run() {
        int i = 10;

        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            for(long x=0; x<25000000000L; x++); //시간 지연
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}
