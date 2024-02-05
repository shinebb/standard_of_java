메서드
=========================


메서드란?
---------
*****
"문장들을 묶어놓은 것 - 작업 단위로 문장들을 묶어서 이름 붙인 것"  
"값(입력)을 받아서 처리하고, 결과를 반환(출력)"  

//메서드는 클래스 안에 들어가 있어야한다.  
//함수는 클래스에 제약이 없다.   
//그러나 메서드 = 함수 같은 역할  


    반환타입 메서드이름(타입 변수명, 타입 변수명, ...){ //선언부
        메서드 호출시 수행 될 코드 //구현부
    }

=> 

    int add(int x, int y) {   
        int result = x + y;  
        return result; //결과를 반환
    }  
  
int = 반환타입(출력)  
add = 메서드 이름  
(int x, int y) = 매개변수선언(입력) : 0~n개  
= 지역변수(lv) : 메서드 내에 선언된 변수


메서드의 장점
---------------------
*****

* 코드의 중복을 줄일 수 있다.
* 코드의 관리가 쉽다.
* 코드를 재사용할 수 있다.
* 코드가 간결해서 이해하기 쉬워진다.


메서드의 호출
------------------
*****

메서드이름(값1, 값2, ...);  //메서드를 호출하는 방법  

    print99danAll();  //void print99danAll()을 호출  
    int result = add(3,5);  //int add(int x, int y)를 호출하고 결과를 result에 저장  
 


return문
---------------------------
*****
* 실행 중인 메서드를 종료하고 호출한 곳으로 되돌아간다.
* 반환타입이 void가 아닌 경우, 반드시 return문 필요.


    void printGugudan(int dan){
        if(!(2<=dan && dan <=9)){
            return; //dan의 값이 2~9가 아닌 경우, 호출한 곳으로 그냥 되돌아간다.(아래 코드 진행안됨)
        }

        for(int i=1; i<=9; i++){
            System.out.printf("%d * %d = %d%n", dan, i, dan*i);
        }
        return; //반환 타입이 void이므로 생략가능. 컴파일러가 자동추가
    }





반환값
-------------------
*****

* 반환타입이 void가 아닐 때 return 반환값의 타입이 일치해야하며 또는 자동형변환이 가능해야한다. 



static 메서드와 인스턴스 메서드
----------------------
*****

* 구별법  
static 메서드  = 클래스 메서드  
인스턴스 메서트 = static 안붙은 메서드  

  
"인스턴스 메서드"
1. 인스턴스 생성 후, '참조변수.메서드이름()'으로 호출
2. 인스턴스 멤버(iv, im)와 관련된 작업을 하는 메서드
3. 메서드 내에서 인스턴스 변수(iv) 사용가능

"static 메서드(클래스메서드)"
1. 객체생성없이 '클래스이름.메서드이름()'으로 호출
2. 인스턴스 멤버(iv, im)와 관련없는 작업을 하는 메서드
3. 메서드 내에서 인스턴스 변수(iv) 사용불가

ex) Math.random() => 객체 생성x => static 메서드

    class MyMath2 {
        long a, b; //iv 인스턴스 변수

        long add() { //인스턴스 메서드
            return a+b;
        }

        static long add(long a, long b) { //클래스메서드(static메서드)
            return a+b; //lv 지역변수 a, b
        }
    }


static을 언제 붙여야 할까?
------------------
*****

* 속성(멤버 변수) 중에서 공통 속성에 static을 붙인다.(포커카드 예시:무늬,숫자 공통속성 x, 카드의 폭, 높이 공통속성 o -> static)
* 인스턴스 멤버(iv, im)을 사용하지 않는 메서드에 static을 붙인다.


메서드 간의 호출과 참조
----------------
*****

* static 메서드는 인스턴스 변수(iv)를 사용할 수 없다.


    class TestClass2 {
        int iv; //인스턴스 변수
        static int cv; //클래스 변수

        void instanceMethod() { //인스턴스 메서드 : 객체 생성 후 호출 가능
            System.out.println(iv);  //인스턴스 변수를 사용할 수 있다.
            System.out.println(cv);  //클래스 변수를 사용할 수 있다.
        }

        static void staticMethod() { //static 메서드 : 객체 생성 없이 호출 가능
            System.out.println(iv); //*****에러***** 인스턴스 변수를 사용할 수 없다. (iv는 객체 생성 후 사용할 수 있기 때문에)
            System.out.println(cv); //클래스 변수는 사용할 수 있다.
        }
    }

* static 메서드는 인스턴스 메서드(im)를 호출할 수 없다.


    class TestClass {
        void instanceMethod() {} //인스턴스 메서드
        static void staticMethod() {} //static 메서드

        void instanceMethod2(){ //인스턴스 메서드
            instanceMethod(); //다른 인스턴스 메서드 호출 가능
            staticMethod(); //다른 static 메서드 호출 가능
        }

        static void staticMethod2() { //static 메서드
            instanceMethod(); //*****에러***** 인스턴스 메서드 호출 불가.
            staticMethod(); //다른 static 메서드 호출 가능
        }
    }




