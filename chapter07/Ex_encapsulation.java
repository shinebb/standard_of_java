package chapter07;

class Time {
    int hour; //hour는 0~23 사이의 값을 가져야함
    int minute;
    int second;
}

class Time2 {
    /* 접근 제어자를 private으로 하여 외부에서 직접 접근하지 못하도록 한다.*/
    private int hour; //hour는 0~23 사이의 값을 가져야함
    private int minute;
    private int second;

    /* 메서드는 public으로 하여 간접접근을 허용한다. */
    public int getHour(){ return hour; }
    
    private boolean isValidHour(int hour){ //이 안에서만 사용하기 때문에 private으로 설정하는것이 좋다.
        return hour < 0 || hour > 23;
    }
    public void setHour(int hour){
        //if(hour < 0 || hour > 23) return;
        if(isValidHour(hour)) return; //더 알아보기 쉽게 변경
        this.hour = hour;
    }
}

public class Ex_encapsulation {
    public static void main(String[] args){
        Time t = new Time();
        t.hour = -100;
        System.out.println(t.hour);

        Time2 t2 = new Time2();
        //t2.hour = -100; //private 변수이기때문에 직접 접근 불가.
        t2.setHour(100);
        System.out.println(t2.getHour());
        t2.setHour(21);
        System.out.println(t2.getHour());
    }
}
