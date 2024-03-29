객체지향 언어
=========================


배경
---------
*****

80년대 초 소프트웨어의 위기 - 빠른 변화를 못 쫓아감  
해결책으로 객체지향 언어를 도입(절차적 -> 객체지향)   
객체지향 언어 = 프로그래밍 언어 + 객체지향개념(규칙)  


- 장점 : 코드의 재사용성이 높고 유지보수가 용이, 중복 코드 제거


oop(Object-oriented programming)
----------------
*****

* 4가지 핵심개념
: 1. 캡슐화  
2. 상속  
3. 추상화  
4. 다형성  


클래스와 객체
----------------
*****

"클래스의 정의 : 클래스란 객체를 정의해 놓은 것"  
"클래스의 용도 : 클래스는 객체를 생성하는데 사용"  

"객체의 정의 : 실제로 존재하는 것. 사물 또는 개념"  
"객체의 용도 : 객체가 가지고 있는 기능과 속성에 따라 다름"  

ex)  
클래스 : 제품 설계도, TV 설계도, 붕어빵 기계  
객체  :  제품, TV, 붕어빵  

객체 = 속성(변수) + 기능(메서드)  


    class Tv{ //클래스 Tv = 설계도
        String color; //변수 색깔
        boolean power; //변수 전원상태
        int channer; //변수 채널    

        void power() {power = !power;}  //메서드
        void channelUp() {channel++} //메서드
        void channelDown() {channel--} //메서드
    }


객체와 인스턴스
-------------
*****
"객체 : 모든 인스턴스를 대표하는 일반적 용어"  
"인스턴스 : 특정 클래스로부터 생성된 객체"  
객체=인스턴스 같다고 생각해도됨   
  
클래스 -> 인스턴스화 -> 인스턴스(객체)  

* 클래스(설계도)가 왜 필요할까?
  : 객체(제품)를 생성하기 위해

* 객체(제품)가 왜 필요한가?
: 객체(제품)를 사용하기 위해

* 객체(제품)를 사용한다는 것은?
: 객체(제품)가 가진 속성(변수)과 기능(메서드)을 사용하려고  



하나의 소스파일에 여러 클래스 작성
----------
*****

1. 하나의 소스파일에 둘 이상의 public class가 존재하면 안된다.
2. 소스파일의 이름이 public class의 이름과 일치하지 않으면 안된다.
3. 소스파일 이름과 public class 이름은 대소문자를 구분한다.


객체의 생성과 사용
--------------
*****

1. 객체의 생성


    클래스명 변수명; //클래스의 객체를 참조하기 위한 참조변수를 선언    
    변수명 = new 클래스명(); //클래스의 객체를 생성 후, 객체의 주소를 참조변수에 저장  
->  

    Tv t;  //Tv클래스 타입의 참조변수 t를 선언  
    t = new Tv();  //Tv인스턴스를 생성한 후, 생성된 Tv인스턴스의 주소를 t에 저장  


2. 객체의 사용


    t.channel = 7;  //Tv인스턴스의 멤버변수 channel의 값을 7로 한다.  
    t.channelDown();  //Tv인스턴스의 메서드 channelDown()를 호출한다.  
    System.out.println("현재 채널은 " + t.channel + " 입니다.");    


* 가비지컬렉터(GC)
: 주기적으로 메모리를 확인하고 있다가 사용불가한 객체들을 메모리에서 제거해준다.   
(불필요하게 메모리를 낭비하는일이 없도록 해준다.)  


  
객체 배열
--------------
*****

객체 배열 == 참조변수 배열  
    

    Tv tv1, tv2, tv3  
=>   
    
    Tv[] tvArr = new Tv[3]; //길이가 3인 Tv타입의 참조변수 배열
    //tvArr[0][1][2]는 현재 null  
    //(참조변수배열만 선언하면 null값이 들어가므로 하나씩 객체를 넣어줘야한다.)   

    //객체를 생성해서 배열의 각 요소에 저장    
    TvArr[0] = new Tv();  
    TvArr[1] = new Tv();  
    TvArr[2] = new Tv();  
=>  

    Tv[] tvArr = { new Tv(), new Tv(), new Tv() };  






