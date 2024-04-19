package chapter13;

public class Ex_synchronized {
    public static void main(String args[]){
        Runnable r = new Runnable_ex();
        new Thread(r).start(); //ThreadGroup에 의해 참조되므로 gc 대상이 아니다.
        new Thread(r).start(); //ThreadGroup에 의해 참조되므로 gc 대상이 아니다.
    }
}

class Account {
    private int balance = 1000; //private으로 해야 동기화가 의미가 있다.

    public int getBalance() {
        return balance;
    }

    //synchronized가 없으면 음수가 나오는것처럼 오류가 발생할 수 있다.
    public synchronized void withdraw(int money) { //synchronized로 메서드를 동기화
        if(balance >= money) {
            try { Thread.sleep(1000); } catch(InterruptedException e) {}
            balance -= money;
        }
    }
}

class Runnable_ex implements Runnable {
    Account acc = new Account();

    public void run() {
        while(acc.getBalance() > 0) {
            //100, 200, 300중에 한 값을 임의로 선택해서 출금(withdraw)
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance : " + acc.getBalance());
        }
    }
}
