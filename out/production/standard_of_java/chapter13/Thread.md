스레드(thread)
===================


프로세스와 스레드(process & thread)
---------------
*****

* 프로세스 : 실행중인 프로그램, 자원(resources)(메모리,CPU 등)과 스레드로 구성
* 스레드 : 프로세스 내에서 실제 작업을 수행. 모든 프로세스는 최소한 하나의 쓰레드를 가지고 있다.


    프로세스 : 스레드 = 공장 : 일꾼


* 싱글 스레드 프로세스 = 자원+스레드
* 멀티 스레드 프로세스 = 자원+스레드+스레드+스레드+...+스레드

"하나의 새로운 프로세스를 생성하는 것보다 하나의 새로운 스레드를 생성하는 것이 더 적은 비용이 든다."


멀티스레드의 장단점
--------------
*****

"대부분의 프로그램이 멀티스레드로 작성되어있다. 그러나, 멀티스레드 프로그래밍이 장점만 있는 것은 아니다."

[장점]
* 시스템 자원을 보다 효율적으로 사용할 수 있다.
* 사용자에 대한 응답성(response)이 향상된다.
* 작업이 분리되어 코드가 간결해 진다

여러모로 좋다.

[단점]
* 동기화(synchronization)에 주의해야 한다.
* 교착생태(dead-lock)가 발생하지 않도록 주의해야 한다.
* 각 스레드가 효율적으로 고르게 실행될 수 있게 해야 한다.

프로그래밍할 때 고려해야할 사항들이 많다.


스레드의 구현과 실행
-------
*****

1. Thread 클래스를 상속


    class MyThread extends Thread { 
        public void run() { //Thread 클래스의 run()을 오버라이딩)
            /* 작업 내용 */
        }
    }

    MyThread t1 = new MyThread(); // 스레드의 생성
    t1.start(); //스레드의 실행


2. Runnable 인터페이스를 구현
    

    class MyThread2 implements Runnable {
        public void run() { //Thread 클래스의 run()을 오버라이딩)
            /* 작업 내용 */
        }
    }

    Runnable r = new MyThread2;
    Thread t2 = new Thread(r);  //Thread(Runnable r)
    // Thread t2 = new Thread(new MyThread2());
    t2.start();


* 자바 클래스는 하나만 상속받을 수 있으므로 Thread 클래스를 상속받기 보다는   
Runnable 인터페이스를 구현하는 방식을 더 많이 사용한다.