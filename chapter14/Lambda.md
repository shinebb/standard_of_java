람다식(Lambda Expression)
====================

* 함수(메서드)를 간단한 '식(expression)'으로 표현하는 방법


    int max(int a, int b){
        return a>b? a : b;
    }
    
    =>
    
    (a, b) -> a > b? a : b


* 익명 함수(이름이 없는)함수, anonymous function)
* 함수와 메서드의 차이
  * 근본적으로 동일. 함수는 일반적 용어, 메서드는 객체지향개념 용어
  * 함수는 클래스에 독립적, 메서드는 클래스에 종속적


람다식 작성하기
----------
*****

1. 메서드의 이름과 반환타입을 제거하고 '->'를 블록{} 앞에 추가한다.
2. 반환값이 있는 경우, 식이나 값만 적고 return 문 생략 가능(끝에 ';' 안 붙임)
3. 매개변수의 타입이 추론 가능하면 생략가능(대부분의 경우 생략가능)

람다식 작성하기 - 주의사항
---------
*****

1. 매개변수가 하나인 경우, 괄호() 생략가능(타입이 없을 때만)
2. 블록 안의 문장이 하나뿐 일 때, 괄호{} 생략가능(끝에 ';' 안 붙임)
3. 단, 하나뿐인 문장이 return 문이면 괄호{} 생략불가


람다식의 예
---------
*****


    int printVar(String name, int i) {
        System.out.println(name+"="+i);
    }
  
    =>

    (name, i) -> System.out.println(name+"="+i)

---------

    int square(int x) {
        return x * x;
    }

    =>

    x -> x*x
    //매변수가 하나라면 ()괄호 생략 가능


람다식은 익명 함수? 익명 객체!
----------
*****

* 람다식은 익명 함수가 아니라 익명 객체이다.
* 람다식(익명 객체)을 다루기 위한 참조변수가 필요. 참조변수의 타입은? 


함수형 인터페이스
---------
*****

* 단 하나의 추상 메서드만 선언된 인터페이스


    interface MyFunction {
        public abstract int max(int a, int b);
    }

    =>

    MyFunction f = new MyFunction () { //익명 클래스. 클래스의 선언 및 객체 생성을 동시에
        public int max(int a, int b) {
            return a > b ? a : b;
        }
    }

    int value = f.max(3,5);  //OK. MyFunction에 max()가 있음


* 함수형 인터페이스 타입의 참조변수로 람다식을 참조할 수 있음.
* (단, 함수형 인터페이스의 메서드와 람다식의 매개변수 개수와 반환타입이 일치해야 함.)


    MyFunction f = (a,b) -> a > b ? a : b;
    int value = f.max(3,5); //실제로는 람다식(익명 함수)이 호출됨


함수형 인터페이스 - example
----------
*****

* 익명 객체를 람다식으로 대체


    List<String> list = Arrays.asList("abc","aaa","bbb","ddd","aaa");
    Collections.sort(lsit, new Comparator<String> () {
                      public int compare(String s1, String s2) {
                          return s2.compareTo(s1);
                      }
                });

    =>

    interface Comparator<T> {
        int compare(T o1, T o2);
    }

    Collections.sort(list, (s1, s2) -> s2.compareTo(s1);