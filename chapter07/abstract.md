추상클래스(abstract class)
=========================
* 미완성 설계도. 미완전 메서드를 갖고 있는 클래스


    abstract class Player { //추상클래스(미완성클래스)
        abstract void play(int pos); //추상메서드(몸통{}이 없는 미완성 메서드)
        abstract void stop();
    }


* 다른 클래스 작성에 도움을 주기 위한 것. 인스턴스 생성 불가


    Player p = new Player(); //###에러### 추상 클래스의 인스턴스 생성 불가


* 상속을 통해 추상 메서드를 완성해야 인스턴스 생성가능


    class AudioPlayer extends Player {
        void play(int pos) { /*내용 생략*/ } //추상메서드를 구현
        void stop() { /*내용 생략*/ }        //추상메서드를 구현
    }

    AudioPlayer ap = new AudioPlayer(); //OK 인스턴스 생성 가능
    Player ap2 = new AudioPlayer();      //OK 객체가 완성 클래스이기때문에 생성가능    


* 미완성 메서드. 구현부(몸통, {})가 없는 메서드


    /* 주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다. */
    abstract 리턴타입 메서드이름(); //{}생략


* 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우 추상클래스를 사용한다.
* 추상메서드가 하나라도 있다면 abstract 붙여야 한다.
* Player를 상속받았을 때 play()메서드만 구현하고 stop()은 구현하지 않았다면
stop()은 아직 abstract 메서드이기 때문에 클래스에도 abstract가 붙여야 한다.


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


    


추상클래스의 작성
---------
*****
* 여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나
기존 클래스의 공통 부분을 뽑아서 추상클래스를 만든다.

* 추상화 <-> 구체화
* 추상화된 코드는 구체화된 코드보다 유연하다. = 변경에 유리하다.










