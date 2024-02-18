인터페이스(interface)
=========================

* 추상 메서드의 집합
* 구현된 것이 전혀 없는 설계도. 껍데기(모든 멤버가 public)

    
    interface 인터페이스이름 {
        /* 모두 public */
        public static final 타입 상수이름 = 값; //상수 #iv, cv 불가
        public abstract 메서드이름(매개변수목록);  //추상메서드
    }
<br>

    interface PlayingCard {
        public static final int SPADE = 4;
        final int DIAMOND = 3;  //public static final int DIAMOND = 3;
        static int HEART = 2;   //public static final int HEART = 2;
        int CLOVER = 1;         //public static final int CLOVER = 1;   
        /* 인터페이스는 무조건 public static final 상수이기때문에 생략가능*/

        public abstract String getCardNumber();
        String getCardKind();   //public abstract String getCardKind();  
        /* 인터페이스는 무조건 public abstract 이기때문에 생략가능*/
    }
    
<br>  

* 인터페이스의 조상은 인터페이스만 가능(Object가 최고 조상 아님)
* 다중 상속이 가능.(추상메서드는 충돌해도 문제 없음)


    interface Fightable extends (1)Movable, (2)Attackable {}


인터페이스의 구현
---------
*****

* 인터페이스에 정의된 추상 메서드를 완성하는 것


    class 클래스이름 implements 인터페이스이름 {
        //인터페이스에 정의된 추상메서드를 모두 구현해야 한다.
    }

<br>

    interface Fightable {
        void move(int x, int y);
        void attack(Unit u);
    }


    class Fighter implements Fightable {
        public void move(int x, int y) { /* 내용 생략 */ }
        public void attack(Unit u) { /* 내용 생략 */ }
    }

    => Fighter 클래스는 Fightable 인터페이스를 구현했다.

<br>  

* 일부만 구현하는 경우, 클래스 앞에 abstract 를 붙여야 함.


    abstract class Fighter implements Fightable {
        public void move(int x, int y) { /* 내용 생략 */ }
        /* 안보이지만 attack이 있기 때문에*/
    }





추상클래스와 인터페이스의 차이점
---------
*****

추상클래스는 일반 클래스(생성자, iv와 같은 멤버변수를 가지고 있는) 인데 추상메서드를 가지고 있는 것이다.  
인터페이스는 아무것도 없이 추상메서드만 가지고 있다. real 껍데기



Q&A
---------
*****

Q. 인터페이스란?  
A. 추상 메서드의 집합  

Q. 인터페이스의 구현이란?  
A. 인터페이스의 추상메서드 몸통{} 만들기(미완성 설계도 완성하기)  

Q. 추상클래스와 인터페이스의 공통점은?  
A. 추상 메서드를 가지고 있다. (미완성 설계도)

Q. 추상클래스와 인터페이스의 차이점은?  
A. 인터페이스는 iv를 가질 수 없다. 






인터페이스를 이용한 다형성
----------
*****

* 인터페이스도 구현 클래스의 부모? YES!



    class Fighter extends Unit implements Fightable {
    //Unit을 상속받고 Fightable을 구현한다.
        public void move(int x, int y) { /* 내용 생략 */ }
        public void attack(Fightable f) { /* 내용 생략 */ }
    }

    Unit      u = new Fighter();
    Fightable f = new Fighter(); //대신 Fightable 인터페이스에 정의된 메소드만 사용 가능하다.

    interface Fightable {
        public void move(int x, int y); 
        public void attack(Fightable f); //매개변수의 Fightable은
                                         //Fightable 인터페이스를 구현한 클래스의 인스턴스만 가능
    }


<br>  

* 인터페이스를 메서드의 리턴타입으로 지정할 수 있다.


    Fightable method() {
    //Fightable 인터페이스를 구현한 클래스의 인스턴스를 반환
        ...
        Fighter f = new Fighter(); 
        return f;   //인터페이스를 구현한 객체
        //위 두 문장을 하나로 합치면
        //return new Fighter();
    }

    /* 메소드 호출시에는 타입이 일치해야한다.(또는 형변환이 가능해야한다.) */
    Fightable f = method();




인터페이스의 장점
---------
*****

* 두 대상(객체) 간의 '연결, 대화, 소통'을 돕는 '중간 역할'을 한다.
* 선언(설계)과 구현을 분리시킬 수 있게 한다.
* 인터페이스 덕분에 B가 변경되어도 A는 안바꿀 수 있게 된다.(느슨한 결함) : A가 B를 사용(A가 B에 의존)
* 개발 시간을 단축할 수 있다.
* 변경에 유리한 유연한 설계가 가능하다.
* 표준화가 가능하다.
* 서로 관계없는 클래스들의 관계를 맺어줄 수 있다.


디폴트 메서드와 static 메서드
=========================

* 인터페이스에 디폴트 메서드, static메서드 추가 기능
* 인터페이스에 새로운 메서드(추상 메서드)를 추가하기 어려움  
  -> 해결책 => 디폴트 메서드(default method)
* 디폴트 메서드는 인스턴스 메서드(인터페이스 원칙 위반 - 예외)
* 디폴트 메서드가 기존의 메서드와 충돌할 때의 채결책
1. 여러 인터페이스의 디폴트 메서드간의 충돌 : 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩 해야한다.
2. 디폴트 메서드와 조상 클래스의 메서드간의 충돌 : 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.
   => 그냥 직접 오버라이딩하면 해결 된다.










