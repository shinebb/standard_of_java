package chapter13;

public class Ex_join {
    static long startTime = 0;

    public static void main(String args[]){
        Ex_join_1 th1 = new Ex_join_1();
        Ex_join_2 th2 = new Ex_join_2();
        th1.start();
        th2.start();

        startTime = System.currentTimeMillis(); //시작시간

        try {
            th1.join(); //main 스레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join(); //main 스레드가 th2의 작업이 끝날 때까지 기다린다.
        } catch(InterruptedException e) {}

        System.out.print("소요시간 : " + (System.currentTimeMillis() - startTime));
        //종료시간 - 시작시간
    }
}

class Ex_join_1 extends Thread {
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("-");
        }
    }
}

class Ex_join_2 extends Thread {
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("|");
        }
    }
}