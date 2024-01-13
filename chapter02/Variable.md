Variable(변수)
=========================

출력
---------
*****
* print() : 출력 후에 줄바꿈 안함
* println() : 출력 후에 줄바꿈 함

변수
----------------
*****

* 변수란?
: 하나의 값을 저장할 수 있는 메모리 공간 (메모리공간 = RAM)

* 변수의 선언 이유?
: 값(data)을 저장할 공간을 마련하기 위해서

* 변수의 선언 방법
: 변수타입 변수이름;  
int age; //정수(int)타입의 변수 age를 선언

* 변수에 값 저장하기
: age = 25;//변수 age에 25를 저장   
int age = 25; //위의 두 줄을 한 줄로

* 변수의 초기화
: 변수의 초기화 : 변수에 처음으로 값을 저장하는 것    
: int x = 0; //변수 x를 선언 후, 0으로 초기화    
int y = 5; //변수 y를 선언 후, 5로 초기화     
int x = 0, y = 5; //위의 두 줄을 한 줄로

###### 지역 변수는 읽기 전에 꼭! 초기화해야 함

* 변수의 값 읽어오기
: 변수의 값이 필요한 곳에 변수의 이름을 적는다.  
int x = 4, y = 2;   
System.out.println(x+y);

변수의 타입
---------
*****

* 변수의 타입은 저장할 값의 타입에 의해 결정된다. 
: int age = 25; //정수  
age = 3.14 ; //정수 = 실수 -> 불일치 error

* 저장할 값의 타입과 일치하는 타입으로 변수를 선언
: char ch = '가'; //char 문자 타입  
double pi = 3.14; //double 실수 타입

* 값의 타입
: 문자 - char  
숫자 - 정수 - byte, short, int, long  
숫자 - 실수 - float, double  
논리 - boolean(true, false)  

상수와 리터럴
--------------
*****

* 상수(constant)
: 한 번만 값을 저장 가능한 변수  
int score = 100; //정수형 변수  
    score = 200; //가능    
final int MAX = 100;  //MAX는 상수    
          MAX = 200;  //에러

* 리터럴(literal)
: 그 자체로 값을 의미하는 것   
ex) score -> 변수  
MAX -> 상수  
100 -> 리터럴

변수와 리터럴의 타입
-----------------
*****

boolean power = true; //또는 false   
char ch = 'A';  //문자형   
String str = "ABC";   //문자열  

byte b = 127; //리터럴 127의 타입은? 정수인데 접미사가 없으므로 int type  
  //바이트와 숏트타입의 리터럴은 없으므로 정수형 int 타입의 리터럴이 저장되며    
  //대신 바이트타입의 변수가 저장할 수 있는 범위여야 한다. (-128~127)   

byte b = 128; //에러발생   
int i = 100; //10진수   
int oct = 0100; //8진수  
int hex = 0x100; //16진수  

long l = 10000000000L; //100억, integer 최대값 20억 => L 꼭 붙여야함 아니면 int로 인식  
long l = 100; //OK  
float f = 3.14f; //f생략불가 -> f없으면 double로 인식  
double d = 3.14d; //d생략가능  
 
10 . => 10.0 => double  
.10 => 0.10 => double  
10f => 10.0f => float  
1e3 => 1000.0d => double  
    (e=10n승)

* 변수와 리터럴의 타입 불일치
: 
1. 범위가 '변수(그릇) > 리터럴(물건)'인 경우, OK  
* int i = 'A';   // int > char(65)  
* long l = 123;  // long > int  
* double d = 3.14f;  //double > float  
*   
2. 범위가 '변수(그릇) < 리터럴(물건)'인 경우, 에러    
* int i = 30_0000_0000;  //int의 범위(+-20억) 벗어남  
* long l = 3.14f;  //long(8byte) < float(4byte) => 실수형은 정수형보다 저장범위가 넒다. error  
* float f = 3.14;  //float < double(생략)  
*   
3. byte, short 변수는 해당 리터럴이 없기때문에 int형 리터럴 저장가능  
* byte b = 100; //OK. byte의 범위(-128~127)에 속함  
* byte b = 128; //에러. byte의 범위를 벗어남  


문자와 문자열
--------------
*****
char ch = 'A';  //문자  
char ch = 'AB'; //에러  
String s = "ABC"; //문자열 또는 문자열리터럴  

String => Class이다.  
String s1 = "AB";
String s2 = new String("AB");   
//클래스는 new 객체를 생성해야하지만, 문자열은 워낙 자주 쓰이기 때문에 기본형 변수처럼 표현 허용

String s = "A";  
String s = "";  //빈 문자열  
Char ch = '';   //에러  

String s1 = "A" + "B"; //"AB"  
String s2 = "" + "7";  //"7"

""+7+7 => "7"+7 => "7"+"7" => "77"  
7+7+"" => 14+"" => "14"+"" => "14"  
* 문자열+any type => 문자열  
* any type+문자열 => 문자열


두 변수의 값 교환하기
------------------
*****

* int x = 10, y = 20;  => x,y의 두 값을 서로의 값으로 바꾸려한다.
: int x = 10, y =20;  
int tmp; //빈 컵  
tmp = x; //x의 값을 tmp에 저장  
x = y;   //x의 값을 y에 저장  
y = tmp; //tmp의 값을 y에 저장  


기본형과 참조형
-------------------
*****

* 값의 타입(기본형(Primitive type)-8개)
: =>실제 값을 저장  
문자 : char  
정수 : byte, short, int, long  
실수 : float, double  
논리 : boolean   


* 값의 타입(참조형(Reference type)-무한개)
: => 메모리 주소를 저장(4byte 또는 8byte)  
기본형을 제외한 나머지(String, System 등)    
Date today;  //참조형 변수 today를 선언  
today = new Date(); //객체를 생성하고 today에 객체의 주소를 저장  
//만약 생성된 객체의 주소가 100번지라면 today에는 100이 저장된다.

기본형(Primitive type)
----------------------
*****

* 종류와 크기
: 
 논리형  
* boolean : true와 false 중 하나를 값으로 갖으며, 조건식과 논리적 계산에 사용된다.  
문자형   
* char : 문자를 저장하는데 사용되며, 변수 당 하나의 문자만을 저장할 수 있다.  
정수형 : 정수 값을 저장하는데 사용된다.    
* int : 주로 사용된다. (default)
* long : 아주 큰 정수일 때 사용된다.  
* byte : 이진 데이터를 다루는데 사용된다.  
* short : c언어와의 호환을 위해 사용되지만 잘 사용되지 않는다.  
실수형 : 소수점을 가진 실수 값을 저장하는데 사용된다.  
* float : 실수 값을 저장한다.
* double : 실수 값을 저장한다. (default)

1bit = 2진수 1자리  
1byte = 8bit

-----
- boolean = 1byte 
-----
- char = 2byte(유니코드)  
- -----
- byte = 1byte    
- short = 2byte  
- **int = 4byte**  
- **long = 8byte** 
- -----
- **float = 4byte**  
- **double = 8byte**  
- -----


기본형(Primitive type) - 표현범위
----------------------
*****

* byte
: byte b;  
d = 3;  
: 
byte = 1byte = 8bit = 2진수(0,1로만 이루어짐)  
b [][][][][][][][]  
b [0][0][0][0][0][0][1][1]  
3(10)=11(2)
: 
1bit [] -> 1,0 -> 2개 => 2의1승  
2bti [][] -> 00,01,10,11 -> 4개 => 2의2승    
* n비트를 표현할 수 있는 값의 개수 : 2의 n승개 => 256  
* n비트를 표현할 수 있는 부호없는 정수의 범위 : 0 ~ 2의n승의 -1 => 0~255(0부터 시작하기 때문에 256이 아닌 255)  
* n비트를 표현할 수 있는 부호있는 정수의 범위 : -2의n-1승 ~ 2의2-1승의 -1 => -128~127  
* (양수와 음수 모두 표현해야하기 때문에 범위의 절반을 음수로 사용한다.) 
*   
* 자바에서 정수형은 모두 부호가 있다.
* [S] -> 부호비트(Sign bit) -> 0=양수 / 1=음수

* byte
: ![수식](https://latex.codecogs.com/svg.latex?-2%5E7) ~ ![수식](https://latex.codecogs.com/svg.latex?2%5E7-1)  
[S][7bit]  
* [0][7bit]  
* [1][7bit]
*   
*  
범위 : -128~127 => 128+128 => 총 256개(2의 8승의 값을 표현할 수 있다.

* short
  : ![수식](https://latex.codecogs.com/svg.latex?-2%5E{15}) ~ ![수식](https://latex.codecogs.com/svg.latex?2%5E{15}-1)  
  [S][15bit]  
  * [0][15bit]  
  * [1][15bit]  
-32768~32768 => 


![수식](https://latex.codecogs.com/svg.latex?x%5E2)  
![수식](https://latex.codecogs.com/svg.latex?2%5En)  
![수식](https://latex.codecogs.com/svg.latex?2%5E7)  
![수식](https://latex.codecogs.com/svg.latex?2%5E{15})   
![수식](https://latex.codecogs.com/svg.latex?-2%5E7)  
![수식](https://latex.codecogs.com/svg.latex?-2%5E{15})


인텔리제이 단축키
--------------
*****
* 한줄 복사 : ctrl + d
* 한줄 삭제 : ctrl + y
* RUN : shift + F10

