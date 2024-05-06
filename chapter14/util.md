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


Quiz
-------
*****

* Supplier<Integer> f = () -> (int)(Math.random()*100)+1;
: 반환값만 있기 때문에 공급자 = Supplier

* Consumer<Integer> f = i -> System.out.print(i + ", ");
: 매개변수는 있지만 반환값은 없기 때문에 소비자 = Consumer

* Predicate<Integer> f = i -> i%2 == 0;
: 조건식 = Predicate
: 원래는 Predicate<Integer, Boolean>이라고 써야하지만 반환타입이 항상 Boolean 이기 때문에 Boolean은 쓰지 않는다.

* Function<Integer,Integer> f = i -> i/10*20;
: 입력값도 있고 출력값도 있는 함수 = Function


매개변수가 2개인 함수형 인터페이스
=================

BiConsumer\<T, U>
------------
*****

* void accept(T t, U u) : 두 개의 매개변수만 있고, 반환값이 없음

BiPredicate\<T,U>
------------
*****

* boolean test(T t, U u) : 조건식을 표현하는데 사용됨. 매개변수는 둘, 반환값은 boolean

BiFunction\<T,U,R>
------------
*****

* R apply(T t, U u) : 두 개의 매개변수를 받아서 하나의 결과를 반환


매개변수가 3개 이상 필요한 경우는 직접 만들어서 사용하면 된다.
----------
*****


    @FunctionalInterface
    interface TriFunction<T,U,V,R> {
        R apply(T t, U u, V v);
    }


매개변수의 타입과 반환타입이 일치하는 함수형 인터페이스
===========

UnaryOperator\<T>
------
*****

* T apply(T t) : Function의 자손. Function과 달리 매개변수와 결과의 타입이 같다.


BinaryOperator\<T>
------
*****

* T apply(T t, T t) : BiFunction의 자손. BiFunction과 달리 매개변수와 결과의 타입이 같다.



Predicate(조건식)의 결합
---------------
*****

* and(), or(), negate()(not)로 두 Predicate를 하나로 결합(default 메서드)


    Predicate<Integer> p = i -> i<100;
    Predicate<Integer> q = i -> i<200;
    Predicate<Integer> r = i -> i%2 == 0;

    Predicate<Integer> notP = p.negate(); //i >= 100
    Predicate<Integer> all = notP.and(q).or(r); //100<=i && i<200 || i%2==0
    Predicate<Integer> all2 = notP.and(q.or(r)); //100<=i && (i<200 || i%2==0)

    System.out.println(all.test(2)); //true
    System.out.println(all2.test(2)); //false


* 등가비교를 위한 Predicate의 작성에는 isEqual()를 사용(static 메서드)


    Predicate<String> p = Predicate.isEqual(str1); //isEqual()은 static메서드
    Boolean result = p.test(str2); //str1과 str2가 같은지 비교한 결과를 반환

    boolean result = Predicate.isEqual(str1).test(str2);
    //str1.equals(str2)랑 같다.


