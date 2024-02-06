import 문
=========================

"클래스를 사용할 때 패키지이름을 생략할 수 있다."  
"컴파일러에게 클래스가 속한 패키지를 알려준다."  

* java.lang 패키지의 클래스는 import하지 않고도 사용할 수 있다.
: String, Object, System, Thread, ...


import 문의 선언
---------
*****

"import 문은 패키지문과 클래스선언의 사이에 선언한다."  

ex) import 패키지명.클래스명; 또는 import 패키지명.*;  
->  

    import java.util.Date;

    class ImportTest {  
        Date today = new Date();  
        //new java.util.Date() 에서 패키지이름 생략  
    }  


static import 문
------------
*****

"static 멤버를 사용할 때 클래스 이름을 생략할 수 있다."

    import static java.lang.Math.random; //Math.random()만 괄호 안붙임  
    System.out.println(random());