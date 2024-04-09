package chapter13;

public class Ex_Thread2 {
    static long startTime = 0;

    public static void main(String[] args){
        Thread2_1 th1 = new Thread2_1();
        Thread2_2 th2 = new Thread2_2();

        th1.start();
        th2.start();

        startTime = System.currentTimeMillis();

        try { //이게 없으면 아래 print 문이 먼저 실행되어 소요시간 0이 될 수 있다.
            th1.join(); //main 스레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join(); //main 스레드가 th2의 작업이 끝날 때까지 기다린다.
        } catch(InterruptedException e) {}


        //메인스레드
        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
    }
}

/* 멀티 스레드 */
class Thread2_1 extends Thread {
    public void run() {
        for(int i=0; i<300; i++){
            System.out.print(new String("-"));
        }
    }
}

class Thread2_2 extends Thread {
    public void run() {
        for(int i=0; i<300; i++){
            System.out.print(new String("|"));
        }
    }
}
