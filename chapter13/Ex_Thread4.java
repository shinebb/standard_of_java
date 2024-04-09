package chapter13;

import javax.swing.*;

public class Ex_Thread4 {
    public static void main(String[] args) throws Exception {
        Thread4_1 th1 = new Thread4_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input);

        /* 멀티스레드의 장점 : Thread4_1가 별도의 스레드로 존재하기 때문에 값을 입력하지 않아도 Thread4_1 작업이 수행된다.
        * 싱글스레드였다면, 사용자가 값을 입력하기 전까지 blocking 상태로 다른 작업을 수행하지 못하고 멈춰있게 된다.*/
    }
}

class Thread4_1 extends Thread {
    public void run() {
        for(int i = 10; i > 0; i--){
            System.out.println(i);
            try {
                sleep(1000);
            } catch(Exception e) {}
        }
    }
}
