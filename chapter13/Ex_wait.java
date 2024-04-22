package chapter13;

import java.util.ArrayList;

public class Ex_wait {
    public static void main(String[] args) throws Exception {
        Table table = new Table();

        new Thread(new Cook(table), "COOK").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();
        Thread.sleep(2000);
        System.exit(0);
    }
}

class Customer implements Runnable {
    private Table table;
    private String food;

    Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    public void run() {
        while(true) {
            try{
                Thread.sleep(100);
            } catch(InterruptedException e) {}

            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }

    boolean eatFood() { return table.remove(food); }
}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) { this.table = table; }

    public void run() {
        //임의의 요리를 하나 선택해서 table에 추가한다.
        int idx = (int)(Math.random()*table.dishNum());
        table.add(table.dishNames[idx]);
        try{
            Thread.sleep(10);
        } catch(InterruptedException e) {}
    }
}

class Table {
    String[] dishNames = { "donut", "donut", "burger" }; //donut의 확률을 높인다.
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) { //synchronized를 추가
        while(dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting.");
            try {
                wait(); //COOK 스레드를 기다리게 한다.
                Thread.sleep(500);
            } catch(InterruptedException e) {}
        }

        dishes.add(dish);
        notify(); //기다리고 있는 CUST를 깨우기 위함.
        System.out.println("Dishes : " + dishes.toString());
    }

    public boolean remove(String dishName){
        synchronized (this){
            String name = Thread.currentThread().getName();

            while(dishes.size()==0){
                System.out.println(name+" is waiting.");
                try {
                    wait(); //CUST 스레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            }


            while(true){
                //지정된 요리와 일치하는 요리를 테이블에서 제거한다.
                for(int i=0; i<dishes.size(); i++){
                    if(dishName.equals(dishes.get(i))){
                        dishes.remove(i);
                        notify(); //잠자고 있는 COOK을 깨우기 위함.
                        return true;
                    }
                }

                try{
                    System.out.println(name + " is waiting.");
                    wait(); //원하는 음식이 없는 CUST 스레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            }
        }
    }

    public int dishNum() {
        return dishNames.length;
    }
}

