java.util.function 패키지
================

* 자주 사용되는 다양한 함수형 인터페이스를 제공

java.lang.Runnable
----------
*****

* void run() : 매개변수도 없고, 반환값도 없음

Supplier\<T>  : 공급자
----------
*****

* T get() : 매개변수는 없고, 반환값만 있음

Consumer\<T> : 소비자
--------------
*****

* void accept(T t) : Supplier와 반대로 매개변수만 있고, 반환값이 없음

Function<T,R> : 함수
-------------
******

* R apply(T t) : 일반적인 함수, 하나의 매개변수를 받아서 결과를 반환

Predicate\<T> : 조건식
-----------
*****

* boolean test(T t) : 조건식을 표현하는데 사용됨. 매개변수는 하나. 반환 타입은 boolean



    Predicate<String> isEmptyStr = s -> s.length() ==0;
    String s = "";
    
    if(isEmptyStr.test(s)) // if(s.length() == 0)
        System.out.println("This is an empty String.");
    }
