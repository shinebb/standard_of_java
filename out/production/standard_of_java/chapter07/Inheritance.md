상속(Inheritance)
=========================

"기존의 클래스로 새로운 클래스를 작성하는 것.(코드의 재사용)"  
"두 클래스를 부모와 자식으로 관계를 맺어주는 것."


    class 자식클래스 extends 부모클래스 {  
        //..  
    }  

=>

    class Parent {} //부모클래스  
    class Child extends Parent {} //자식클래스  



상속의 특징
---------
*****

* 자손은 조상(부모의 부모)의 모든 멤버를 상속받는다. (생성자, 초기화블럭 제외)
* 자손의 멤버 개수는 조상보다 적을 수 없다. (같거나 많다.)
* 자손의 변경은 조상에 영향을 미치지 않는다.


포함관계 : 포함(composite)이란?
----------------
*****

"클래스의 멤버로 참조변수를 선언하는 것"

    class Point {
        int x;
        int y;
    }

=>

    class Circle {
        Point c = new Point();  //원점
        int r; //반지름(radius)
    }

=> Circle은 Point를 포함하고 있다.


클래스 간의 관계 결정하기
-------------
*****

"상속관계 : ~은 ~이다.(is-a)"  
"포함관계 : ~은 ~을 가지고 있다.(has-a)"  

원(Circle)은 점(Point)이다.  
원(Circle)은 점(Point)을 가지고 있다.  
=> 포함관계가 더 적합합니다.  


단일 상속(Single Inheritance)
---------------------
*****

* JAVA는 단일(하나의 부모만 상속) 상속만을 허용한다. (C++은 다중상속 허용)
: class TvDVD extends Tv, DVC {} //####에러#### 조상은 하나만 허용된다.  

* 비중이 높은 클래스 하나만 상속관계로, 나머지는 포함관계로 한다.
: class TvDEV extends Tv { DVD dvd = new DVD(); }


Object클래스 - 모든 클래스의 조상
------------
*****
"부모가 없는 클래스는 자동적으로 Object클래스를 상속받게 된다."

class Tv {} => class Tv extends Object {}  
=> 부모가 없을 때 컴파일러가 extends Object 코드를 자동 추가해준다.

"모든 클래스는 Object 클래스에 정의된 11개의 메서드를 상속받는다."  
(ex. toString(), equals(Object obj), hashCode(). ...)


* 상속 계층도
: Object < Tv < SmartTv (가장 상위에는 Object 클래스가 있다.)








