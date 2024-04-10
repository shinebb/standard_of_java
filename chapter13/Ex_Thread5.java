package chapter13;

public class Ex_Thread5 {
    public static void main(String args[]){
        Thread5_1 th1 = new Thread5_1();
        Thread5_2 th2 = new Thread5_2();

        th2.setPriority(7); //기본 5
        //우선순위가 높을수록 더 빨리 끝난다.
        //그러나 확률만 높아질뿐, 무조건을 기대하긴 어렵다.
        //우선순위는 상대적

        System.out.println("Priority of th1(-) : " + th1.getPriority());
        System.out.println("Priority of th2(-) : " + th2.getPriority());
        th1.start();
        th2.start();
    }
}

class Thread5_1 extends Thread {
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("-");
            for(int x=0; x<10000; x++);
        }
    }
}

class Thread5_2 extends Thread {
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("|");
            for(int x=0; x<10000; x++);
        }
    }
}