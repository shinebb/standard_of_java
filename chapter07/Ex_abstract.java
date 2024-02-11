package chapter07;

public class Ex_abstract {
    public static void main(String[] args){

        //Player p = new Player();  //추상 클래스의 객체를 생성 ###에러###
        AudioPlayer ap = new AudioPlayer(); //추상클래스를 상속받아 직접구현한 자손클래스로 객체 생성 가능
        Player ap2 = new AudioPlayer(); //다형성
        ap2.play(100);
        ap2.stop();
    }
}

abstract class Player { //추상메서드를 하나라도 가지고 있다면 무조건 추상클래스이므로 abstract를 붙여주어야 한다.
    boolean pause;  //일시정지 상태를 저장하기 위한 변수
    int currentPos; //현재 Play 되고 있는 위치를 저장하기 위한 변수

    Player() {      //추상클래스도 생성자가 있어야 한다.
        pause = false;
        currentPos = 0;
    }

    /* 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 한다. */
    abstract void play(int pos);    //추상메서드

    /* 재생을 즉시 멈추는 기능을 수행하도록 작성되어야 한다. */
    abstract void stop();           //추상메서드

    void play() {   //인스턴스메서드 -> 상속받은 자손이 메서드추상 메서드 구현시 객체 생성후 사용 가능
        play(currentPos);           //추상메서드를 사용할 수 있다.
    }
}

class AudioPlayer extends Player {

    void play(int pos) {
        System.out.println(pos +"위치부터 play합니다.");
    }

    void stop() {
        System.out.println("재생을 멈춥니다.");
    }   //하나라도 구현을 하지 않는 다면 ###에러###
        //아니면 클래스에 abstract를 붙여야 하며, 그렇게 되면 객체 생성이 불가하다.
}