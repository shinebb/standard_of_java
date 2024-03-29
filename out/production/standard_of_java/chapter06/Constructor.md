생성자(constructor)
=========================


생성자란?
---------
*****
"인스턴스가 생성될 때마다 호출되는 '인스턴스 초기화 메서드'"  
"인스턴스 생성시 수행할 작업(iv 초기화)에 사용"


    Time t = new Time();  //Time() <- 기본 생성자 호출
    t.hour = 12;  
    t.minute = 34;  
    t.second = 56;  
=>  

    Time t = new Time(12, 34, 56);  


생성자 규칙
--------------
*****

1. 이름이 클래스 이름과 같아야 한다.
2. 리턴값이 없다.(void 안붙임)
3. 모든 클래스는 반드시 생성자를 가져야 한다.


    클래스이름(타입 변수명, 타입 변수명, ...){
        //인스턴스 생성 시 수행될 코드,
        //주로 인스턴스 변수의 초기화 코드를 적는다.
    }  
=>  

    class Card{   
        ...
        Card() { //생성자 오버로딩
            //매개변수 없는 생성자.
            //인스턴스 초기화 작업
        }
        Card(String kind, int number) { //생성자 오버로딩
            //매개변수 있는 생성자
            //인스턴스 초기화 작업
        }
    } 


기본 생성자(default constructor)
------------
*****
"매개변수가 없는 생성자"  
"생성자가 하나도 없을 때만, 컴파일러가 자동 추가"  

    클래스이름() {} //기본생성자  
    Point() {}    //Point 클래스의 기본생성자  

=> 생성자가 하나라도 있자면 기본생성자 직접 작성해줘야 함  
=> 다른 생성자가 없더라고 기본생성자를 작성하는 습관을 들이자.


매개변수가 있는 생성자
----------------
*****

    class Car {  
        String color;  //색상  
        String gearType;  //변속기 종류 - auto(자동), manual(수동)  
        int door;  //문의 개수  

        Car(){}  //기본생성자  
        Car(String c, String g, int d){   //매개변수가 있는 생성자  
            color = c;  
            gearType = g;  
            door =d;  
        }
    }

<br>

    Car c = new Car();  //기본 생성자 호출
    c.color = "white";  
    c.gearType = "auto";  
    c.door = 4;  
=>  
    
    Car c = new Car("white", "auto", 4);  //매개변수가 있는 생성자 호출

    //Car c = 참조변수생성  
    //new -> 객체생성  
    //Car("white", "auto", 4) -> 객체초기화=생성자호출


생성자 this()
----------------------
*****
"생성자에서 다른 생성자 호출할 때 사용"  
"다른 생성자 호출 시 첫 줄에서만 사용가능"  

=> 코드의 중복을 제거하기 위해 서로를 호출한다.  


참조변수 this 
------------------------
*****
"인스턴스 자신을 가리키는 참조변수"  
"인스턴스 메서드(생성자 포함)에서 사용가능"  
"지역변수(lv)와 인스턴스 변수(iv)를 구별할 때 사용"


참조변수 this와 생성자 this()
------------------------
*****

this
: 인스턴스 자신을 가리키는 참조변수. 인스턴스의 주소가 저장되어 있다.  
모든 인스턴스메서드에 지역변수로 숨겨진 채로 존재한다.

this(), this(매개변수)
: 생성자. 같은 클래스의 다른 생성자를 호출할 때 사용한다.

참고
: this와 this()는 비슷하게 생겼을 뿐 완전히 다른 것이다. this는 '참조 변수'이고, this()는 '생성자'이다.



