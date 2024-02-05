클래스
=========================


클래스의 정의
---------
*****
"클래스 == 데이터+함수"

1. 설계도
2. 데이터+함수
3. 사용자정의 타입


데이터 + 함수
------------
*****

1. 변수 : 하나의 데이터를 저장할 수 있는 공간
2. 배열 : *같은 종류*의 여러 데이터를 하나로 저장할 수 있는 공간
3. 구조체 : 서로 관련된 여러 데이터(*종류 관계X*)를 하나로 저장할 수 있는 공간
4. 클래스 : *데이터와 함수의 결합*(구조체+함수)  


사용자정의 타입
-----------
*****

* 사용자 정의 타입 : 원하는 타입을 직접 만들 수 있다.

Ex) 시간을 다루는 타입이 필요하다면?  


    int hour;  
    int minute;  
    int second;   
=> (여러개필요)

    int hour1, hour2, hour3  
    int minute1, minute2, minute3  
    int second1, second2, second3  
=>   

    int[] hour = new int[3];  
    int[] minute = new int[3];  
    int[] second = new int[3];  


<br>  

* 이런식으로 표현할 수 있지만 새로운 클래스는 선언하여 사용하면 더 간결하고 효율적인 코드를 짤 수 있다.  


    class Time{
      int hour;
      int minute;
      int second;  
    }  
=>  

    Time t = new Time();  
=> (여러개필요)  

    Time t1 = new Time();  
    Time t2 = new Time();  
    Time t3 = new Time();  
=>  

    Time[] t = new Time[3];    
    t[0] = new Time();  
    t[1] = new Time();  
    t[2] = new Time();    

<br>  

* 비객체지향적 코드  


    int hour = 12;  
    int minute = 34;  
    int second = 56;  
  
* 객체지향적 코드  


    Time t = new Time();  
    t.hour = 12;  
    t.minute = 34;  
    t.second = 56;  

"전자보다 후자가 더 객체지향적인 코드이다."



