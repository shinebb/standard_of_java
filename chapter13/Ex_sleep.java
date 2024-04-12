package chapter13;

public class Ex_sleep {
    public static void main(String[] args) {
        Ex_sleep_1 th1 = new Ex_sleep_1();
        Ex_sleep_2 th2 = new Ex_sleep_2();

        th1.start();
        th2.start();

        /*try {
            Thread.sleep(2000); //th1을 2초동안 잠자게
            //th1.sleep(2000); // th1이어도 th1을 실행하는건 main 스레드이기 때문에 main이 잠들게 된다.
        } catch (InterruptedException e) {}*/

        delay(2*1000); //메서드를 만들어 사용하면 훨씬 깔끔한 코드를 작성할 수 있다.
        System.out.println("<<main 종료>>");
    }

    static void delay(long millis) {
        try {
            Thread.sleep(millis); //try-catch로 예외처리를 해주지않으면 오류 발생
        } catch (InterruptedException e) {}
    }
}

class Ex_sleep_1 extends Thread {
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("-");
        }
        System.out.println("<<th1 종료>>");
    }
}

class Ex_sleep_2 extends Thread {
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("|");
        }
        System.out.println("<<th2 종료>>");
    }
}