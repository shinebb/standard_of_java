package chapter13;

public class Ex_suspend {
    public static void main(String args[]) {
        //Ex_suspend_1 r = new Ex_suspend_1();
        MyThread th1 = new MyThread("*");
        MyThread th2 = new MyThread("**");
        MyThread th3 = new MyThread("***");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend(); //스레드 th1을 잠시 중단시킨다.
            Thread.sleep(2000);
            th2.suspend(); //스레드 th2을 잠시 중단시킨다.
            Thread.sleep(3000);
            th1.resume();  //스레드 th1이 다시 동작하도록 한다.
            Thread.sleep(3000);
            th1.stop();    //스레드 th1을 강제종료시킨다.
            th2.stop();    //스레드 th2을 강제종료시킨다.
            Thread.sleep(2000);
            th3.stop();    //스레드 th3을 강제종료시킨다.
        } catch (InterruptedException e) {}
    }
}

class MyThread implements Runnable {
    volatile boolean suspended = false;
    volatile boolean stopped = false;
    /*
    * volatile : 쉽게 바뀌는 변수.
    * 이게 안붙으면 계속 실행상태이며, 붙으면 모든 스레드가 stop 됐을 때 프로그램이 종료된다.
    * */

    Thread th;

    MyThread(String name) {
        th = new Thread(this, name);  //Thread(Runnable r, String name)
    }

    void start() {
        th.start();
    }

    void stop() {
        stopped = true;
    }

    void suspend() {
        suspended = true;
    }

    void resume() {
        suspended = false;
    }

    public void run() {
        while(!stopped) {
            if(!suspended){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {}
            }
        }
    }
}

/*class Ex_suspend_1 implements Runnable {
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
        }
    }
}*/
