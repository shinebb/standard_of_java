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

<br>  

    class Ex {
      class InstanceInner {}
      static class StaticInner {}

      InstanceInner iv = new InstanceInner();  //OK. 인스턴스멤버끼리는 직접 접근 가능
      static StaticInner cv = new StaticInner();  //OK. static 멤버끼리는 직접 접근 가능

      static void staticMethod() {   //statc멤버는 인스턴스멤버에 직접 접근 불가
        InstanceInner obj1 = new InstanceInner();  //#에러#
        StaticInner obj2 = new StaticInner();
      }
  
      void instanceMethod() {  //인스턴스메서드에서는 인스턴스멤버와 static멤버 모두 접근 가능
        InstanceInner obj1 = new InstanceInner(); 
        StaticInner obj2 = new StaticInner();
        LocalInner ln = new LocalInner();  //#에러# 지역 내부 클래스는 외부에서 접근할 수 없다.
      }

      void meMethod() {
        class LocalInner {}
        LocalInner iv = new LocalInner();
      }
    }

<br>

    class Outer {
      private int outerIv = 0;
      static int outerCv = 0;
    
      class InstanceInner {
        int iiv = outerIv;  //외부 클래스의 private 멤버도 접근가능하다.
        int iiv2 = outerCv;
      }

      static class StaticInner {
        int siv = outerIv;  //#에러# static 클래스는 외부 클래스의 인스턴스멤버에 접근할 수 없다.
        static int scv = outerCv;
      }

      void myMethod() {
        int lv = 0;
        final int LV = 0; //final 생략 가능

        class LocalInner {
          int liv = outerIv;
          int liv2 = outerCv;
        //외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근가능하다.
          int liv3 = lv; //원래는 에러지만 현재 가능.
          int liv4 = LV;
        }
      }
    }
  
<br>

    class Outer2 {
      class InstanceInner{
        int iv = 10;;
      }

      static class StaticInner {
        int iv = 200;
        static int cv = 300;
      }

      vodi myMethod() {
        class LocalInner {
          int iv = 400;
        }
      }
    }

    class Ex {
      public static void main(String[] args){
        Outer2 oc = new Outer2(); //외부클래스의 인스턴스를 먼저 생성해야 인스턴스 클래스의
        Outer2.InstanceInner ii = oc.new InstanceInner();   //인스턴스를 생성 가능

        System.out.println(ii.iv);
        System.out.println(Outer2.StaticInner.cv);

        //static 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다.
        Outer2.StaticInner si = new Outer2.StaticInner();
        System.out.println(si.iv);
      }
    }

<br>

    class Outer3 {
      int value = 10; //Outer3.this.value

      class Inner {
        int value = 20; //this.value

        void method1() {
          int value = 30;
        
          System.out.println(value);             //30
          System.out.println(this.value);        //20
          System.out.println(Outer3.this.value); //30
        }
      }
    }
  
    class Ex {
      public static void main(String[] args){
        Outer3 outer = new Outer3();
        Outer3.Inner inner = outer.new Inner();
        inner.method();
      }
    }




