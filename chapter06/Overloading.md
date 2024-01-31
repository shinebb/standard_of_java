오버로딩(overloading)
=========================


오버로딩이란?
---------
*****
"한 클래스 안에 같은 이름의 메서드 여러 개 정의하는 것"  


오버로딩이 성립하기 위한 조건
--------------
*****

1. 메서드 이름이 같아야 한다.
2. 매개변수의 개수 또는 타입이 달라야 한다.
3. 반환 타입은 영향없다.

보기1.  
int add(int a, int b) { return a+b; }  
int add(int x, int y) { return x+y; }  
=> 오버로딩 X -> 중복정의 ####error#### -> 매개변수의 개수와 타입이 모두 같다.

보기2.  
int add(int a, int b) { return a+b; }  
long add(int a, int b) { return (long)a+b; }  
=> 오버로딩 X ->  중복정의 ####error#### -> 매개변수의 개수와 타입이 모두 같으며, 반환 타입은 영향없다.

보기3.  
long add(int a, long b) { return a+b; }  
long add(long a, int b) { return a+b; }  
=> 오버로딩 O -> 메서드 이름이 같고, 매개변수 타입이 다르다.  
=> 만약 add(3,3) 으로 호출한다면? -> ambiguous(모호하다, 명확하지 않다.) -> ####error####  
=> 이러한 경우 정의는 가능하지만 호출시 주의가 필요하다.

