package chapter13;

public class Ex_Thread {
    public static void main(String args[]){
        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);  //생성자 Thread(Runnable target)

        t1.start();
        t2.start();
        //번갈아가면서 실행될 수 있으며, t1이 아니라 t2가 먼저 실행될 수도 있다.
        //이 순서는 OS 스케쥴러가 결정하며, 스레드는 OS에 의존적이다.
    }
}

class ThreadEx1_1 extends Thread {  //1. Thread 클래스를 상속받아 스레드를 구현
    public void run() { //스레드가 수행할 작업
        for(int i=0; i<5; i++){
            System.out.println(getName()); //조상인 Thread의 getName()을 호출
        }
    }
}

class ThreadEx1_2 implements Runnable {  //2. Runnable 인터페이스를 구현해서 스레드를 구현
    public void run() { //스레드가 수행할 작업
        for(int i=0; i<5; i++){
            Thread.currentThread(); //현재 실행중인 Thread를 반환한다.
            System.out.println(Thread.currentThread().getName()); //조상인 Thread의 getName()을 호출
        }
    }
}


