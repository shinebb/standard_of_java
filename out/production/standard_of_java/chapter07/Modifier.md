제어자(modifier)
=========================
"클래스와 클래스의 멤버(멤버 변수, 메서드)에 부가적인 의미 부여"

* 하나의 대상에 여러 제어자를 같이 사용 가능(접근 제어자는 하나만)


    public class ModifierTest {
        //접근제어자는 제일 왼쪽에
        public static final int WIDTH = 200;
        
        public static void main(String[] args) {
            System.out.println("WIDTH="+WIDTH);
        }
    }


접근제어자
---------
*****
public, protected, (default), private  
"4가지 중 하나만 사용할 수 있다."

* private
: 같은 클래스 내에서만 접근이 가능하다.

* (default)
: 같은 패키지 내에서만 접근이 가능하다.

* protected
: 같은 패키지 내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능하다.

* public
: 접근 제한이 전혀 없다.


접근제한없음 > 같은패키지+자손 > 같은패키지 > 같은클래스  
public > protected > (default) > private  

* 클래스 앞에는 public 또는 (default)만 올 수 있다.
* 멤버에서는 4가지 다 가능하나, 4가지 중 하나만 사용할 수 있다.


그 외
---------
*****
static, final, abstract, native, transient, synchronized, volatile, strictfp


static - 클래스의, 공통적인
----------
*****

* 멤버변수
: 
1. 모든 인스턴스에 공통적으로 사용되는 클래스 변수가 된다.  
2. 클래스 변수는 인스턴스를 생성하지 않고도 사용 가능하다.  
3. 클래스가 메모리에 로드될 때 생성된다.  

* 메서드
: 
1. 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다.  
2. static 메서드 내에서는 인스턴스멤버들을 직접 사용할 수 없다.  
  
<br>

    class StaticTest {
        static int width = 200; // 클래스 변수 (static 변수)
        static int height = 120; // 클래스 변수 (staitc 변수)

        static {                //클래스 초기화 블럭
            //static 변수의 복잡한 초기화 수행
        }
    
        static int max(int a, int b){ //클래스 메서드(static메서드)
            return a>b ? a : b;
        }
    }


final - 마지막의, 변경될 수 없는
------------
*****

* 클래스
: 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다. 그래서 final로 지정된 클래스는 다른 클래스의 조상이 될 수 없다.

* 메서드
: 변경될 수 없는 메서드, final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다.

* 멤버변수 & 지역변수
: 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.

<br>  

    final class FinalTest {      //조상이 될 수 없는 클래스 
        final int MAX_SIZE = 10; //값을 변경할 수 없는 멤버변수(상수)

        final void getMaxSize() { //오버라이딩할 수 없는 메서드(변경불가)
            final int LV = MAX_SIZE; //값을 변경할 수 없는 지역변수(상수)
            return MAX_SIZE;
        }
    }


abstract - 추상의, 미완성의
----------
*****

* 클래스
: 클래스 내에 추상 메서드가 선언되어 있음을 의미한다.

* 메서드
: 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알린다.

<br>

    abstract class AbstractTest { //추상 클래스(추상 메서드를 포함한 클래스)
        abstract void move();     //추상 메서드(구현부가 없는 메서드({} 몸통이 없는 메서드, 미완성 메서드))
    }

    AbstractTest a = new AbstractTest(); //##에러## -> 추상 클래스의 인스턴스 생성불가(미완성 설계도이기 때문에)


* 추상클래스를 상속받아서 완전한 클래스(구상클래스)를 만든후에 객체 생성가능.


캡슐화와 접근 제어자
------
*****

* 접근 제어자를 사용하는 이유?
: 
1. 외부로부터 데이터를 보호하기 위해서  
2. 외부에는 불필요한, 내부적으로만 사용되는 부분을 감추기 위해서

      public class Time {
          /* 접근 제어자를 private으로 하여 외부에서 직접 접근하지 못하도록 한다.*/
          private int hour;
          private int minute;
          private int second;

          /* 메서드는 public으로 하여 간접접근을 허용한다. */
          public int getHour(){ return hour; }
          public void setHour(int hour){
              if(hour < 0 || hour > 23) return;
              this.hour = hour;
          }
      }