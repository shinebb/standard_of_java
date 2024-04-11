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


스레드의 실행 - start()
-----------
*****

* 스레드를 생성한 후에 start()를 호출해야 스레드가 작업을 시작한다.


    ThreadEx1_1 t1 = new ThreadEx1_1(); 
    ThreadEx1_1 t2 = new ThreadEx1_1();

    t1.start(); //스레드 t1을 실행시킨다.
    t2.start(); //스레드 t2을 실행시킨다.

    /* start() 했다고 스레드가 바로 실행되는 것은 아님. 그리고 뭐가 실행 될지 모름.
    t1을 먼저 start()했기때문에 확률은 높지만 무조건은 아님.

    start()하면 '실행가능'상태가 되는것으로, 바로 실행되는 것은 아님
    이 순서는 OS의 스케쥴러가 정한다. */


start()와 run()
------------
*****

* 실행 내용을 작성하는 건 run()이지만 start()로 실행하여 새로운 스택을 만들어주어야 run()을 실행한다.


main 스레드
------
*****

* main 메서드의 코드를 수행하는 스레드
* 스레드는 '사용자 스레드'(메인)와 '데몬 스레드'(보조) 두 종류가 있다.


"실행 중인 사용자 스레드가 하나도 없을 때 프로그램은 종료된다."


싱글스레드와 멀티스레드
-----------
*****

* 싱글스레드


    public class Ex_Thread3 {
        static long startTime = 0;

        public static void main(String[] args){
            for(int i=0; i<300; i++){
                System.out.print(new String("-"));
            }

            for(int i=0; i<300; i++){
                System.out.print(new String("|"));
            }
        }
    }


* 멀티스레드

    
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


스레드의 I/O(Input/Output) 블락킹(blocking)
---------------
*****


* 싱글스레드 일 때 blocking : 사용자로부터 입력을 기다리는 구간동안 아무 일도 하지 않는다.
* 멀티스레드 일 때 blocking : 사용자로부터 입력을 기다리는 구간동안 다른 스레드가 수행된다.


스레드의 우선순위(priority of thread)
----------
*****

* 작업의 중요도에 따라 스레드의 우선순위를 다르게 하여 특정 스레드가 더 많은 작업시간을 갖게 할 수 있다.


    void setPriority(int newPriority) //스레드의 우선순위를 지정한 값으로 변경한다.
    int getPriotiry(); //스레드의 우선순위를 반환한다.

    public static final int MAX_PRIOTITY = 10; //최대우선순위
    public static final int MIN_PRIOTITY = 1; //최소우선순위
    public static final int NORM_PRIOTITY = 5; //보통우선순위


스레드 그룹
---------
*****

* 서로 관련된 스레드를 그룹으로 묶어서 다루기 위한 것
* 모든 스레드는 반드기 하나의 스레드 그룹에 포함되어 있어야 한다.
* 스레드 그룹을 지정하지 않고 생성한 스레드는 'main 스레드 그룹'에 속한다.
* 자신을 생성한 스레드(부모 스레드)의 그룹과 우선순위를 상속받는다.


데몬 스레드(daemon thread)
--------
*****

* 일반 스레드(non-daemon thread)의 작업을 돕는 보조적인 역할을 수행
* 일반 스레드가 모두 종료되면 자동적으로 종료된다.
* 가비지 컬렉터(GC), 자동저장, 화면 자동갱신 등에 사용된다.
* 무한루프와 조건문을 이용해서 실행 후 대기하다가 특정조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.


    boolean isDaemon() -  스레드가 데몬 스레드인지 확인한다. 데몬 스레드이면 true를 반환
    void setDaemon(boolean on) - 스레드를 데몬 스레드로 또는 사용자 스레드로 변경. 매개변수 on을 true로 지정하면 데몬 스레드가 된다.

* setDaemon(boolean on)은 반드시 start()를 호출하기 전에 실행되어야 한다.
* 그렇지 않으면 IllegalThreadStateException 이 발생한다.


스레드의 상태
-----------
*****

* NEW : 스레드가 생성되고 아직 start()가 호출되지 않은 상태
* RUNNABLE : 실행 중 또는 실행 가능한 상태
* BLOCKED : 동기화 블럭에 의해서 일시정지된 상태(lock이 풀릴 때까지 기다리는 상태)
* WAITING, TIMED_WAITING : 스레드의 작업이 종료되지는 않았지만 실행가능하지 않은(unRunnable) 일시정지상태.
    TIMED_WAITING 은 일시정지시간이 지정된 경우를 의미
* TERMINATED : 스레드의 작업이 종료된 상태


* 잠시 정지되는 상태 : suspend()(일시정지), sleep()(쉼), wait(), join()(기다리기), I/O block(입출력 대기)
* 다시 재개 : resume()(재개), time-out(시간종료), notify(), interrupt()


스레드의 실행제어
-----------
*****

* 스레드의 실행을 제어할 수 있는 메서드가 제공된다.


* static void sleep(long millis) / (long millis, int nanos) : 지정된 시간(천분의 일초 단위) 동안
    스레드를 일시정지(잠들게) 시킨다. 지정한 시간이 지나고 나면, 자동적으로 다시 실행대기상태가 된다.
* void join() / (long millis) / (long millis, int nanos) : 지정된 시간동안 스레드가 실행되도록 한다.
    지정된 시간이 자나거나 작업이 종료되면 join()을 호출한 스레드로 다시 돌아와 실행을 계속한다.
* void interrupt() : Sleep()이나 join()에 의해 일시정지상태인 스레드를 깨워서 실행대기상태로 만든다.
    해당 스레드에서는 Interrupted Exception이 발생함으로써 일시정지 상태를 벗어나게 된다.
* void stop() : 스레드를 즉시 종료시킨다.
* void suspend() : 스레드를 일시정시시킨다. resume()을 호출하면 다시 실행대기상태가 된다.
* void resume() : suspend()에 의해 일시정지상태에 있는 스레드를 실행대기상태로 만든다.
* static void yield() : 실행 중에 자신에게 주어진 실행시간을 다른 스레드에게 양보(yield)하고 자신은 실행대기상태가 된다.


* static이 붙은 sleep()과 yield() : 스레드 자기 자신에게만 호출 가능. (내가 sleep()할 수는 있어도 다른 스레드를 sleep()시킬 순 없다.)