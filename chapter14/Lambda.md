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