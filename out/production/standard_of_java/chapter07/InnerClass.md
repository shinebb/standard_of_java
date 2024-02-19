내부 클래스(inner class)
=========================

* 클래스 안의 클래스 

내부 클래스의 장점
---------
*****

* 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.
* 코드의 복잡성을 줄일 수 있다. (캡슐화)



내부클래스의 종류와 특징
------------
*****
* 내부 클래스의 종류와 유효범위(scope)는 변수와 동일

  1. 인스턴스 내부 클래스(instance class)
  : 외부 클래스의 멤버변수 선언위치에 선선하며, 외부 클래스의 인스턴스멤버처럼 다루어진다. 주로 외부 클래스의 인스턴스멤버들과 관련된 작업에 사용될 목적으로 선언된다.
  
  2. 스태틱 내부 클래스(static class)
  : 외부 클래스의 멤버변수 언언위치에 선언하며, 외부 클래스의 static 멤버처럼 다루어진다. 주로 외부 클래스의 static 멤버, 특히 static 메서드에서 사용될 목적으로 선언된다.

  3. 지역 내부 클래스(local class)
  : 외부 클래스의 메서드나 초기화블럭 안에 선언하며, 선언된 영역 내부에서만 사용될 수 있다.
  
  4. 익명 클래스(anonymous class)
  : 클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스(일회용)


* 내부 클래스의 제어자는 변수에 사용 가능한 제어자와 동일  
  일반 클래스는 ((default)/public)만 가능    
  내부 클래스는 ((default)/public/private/protected) 모두 가능하다.


    class Ex {
      class InstanceInner {
        int iv = 100;
        static int cv = 100;    //에러! static 변수를 선언할 수 없다.
        final static int CONST = 100;  //final static은 상수이므로 허용
      }
    
    static class StaticInner {
      int iv = 200;
      static int cv = 200;    //static 클래스만 static 멤버를 정의할 수 있다.
    }

    void myMethod() {
      class LocalInner {
        int iv = 300;         
        static int cv = 300;      //에러! static 변수를 선언할 수 없다.
        final static int CONST = 300; //final static은 상수이므로 허용
      }
    }

static은 객체 생성 없이 사용가능해야한다.











