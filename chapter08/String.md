String 클래스
==============

* String 클래스 = 데이터(char[]) + 메서드(문자열 관련)
* 문자열을 다루기 위한 클래스
* 내용을 변경할 수 없는 불변(immutable) 클래스


    String a="a";
    String b="b";
    a = a+b; //새로운 주소의 "ab"가 만들어지고 이 주소가 a에 저장된다. 
    // -> 불변 클래스이기때문에 계속 새로운 문자열의 객체가 만들어진다.


* 덧셈 연산자(+)를 이용한 문자열 결합은 성능이 떨어짐.  
문자열의 결합이나 변경이 잦다면, 내용을 변경 가능한 StringBuffer 를 사용


문자열 비교
---------
*****

* String str = "abc"; 와 String str = new String("abc");의 비교


    String str1 = "abc";  //문자열 리터럴 "abc"의 주소가 str1에 저장됨
    String str2 = "abc";  //문자열 리터럴 "abc"의 주소가 str2에 저장됨
    String str3 = new String("abc"); //새로운 String인스턴스를 생성
    String str4 = new String("abc"); //새로운 String인스턴스를 생성


str1과 str2는 같은 주소를 공유한다.
str3과 str4는 서로 다른 객체를 만들었기 때문에 다르다.  
=> 따라서 문자열을 비교할 때는 equals를 사용한다.


문자열 리터럴
--------
*****

* 문자열 리터럴은 프로그램 실행시 자동으로 생성된다.(new String 안써도됨)
* (constant pool(상수저장소)에 저장됨)
* 같은 내용의 문자열 리터럴은 하나만 만들어진다.(주소 공유)


빈 문자열("", empty string)
----------
*****

* 내용이 없는 문자열. 크기가 0인 char형 배열을 저장하는 문자열


    String str = "";  //str을 빈 문자열로 초기화


* 크기가 0인 배열을 생성하는 것은 어느 타임이나 가능


    char[] chArr = new char[0];  //길이가 0인 char배열
    int[] iArr = {};             //길이가 0인 int배열


* 문자(char)와 문자열(String)의 초기화


    String s = "";  //빈 문자열로 초기화
    char c = ' ';   //공백으로 초기화








