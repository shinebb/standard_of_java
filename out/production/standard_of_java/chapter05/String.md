String 클래스
=========================


String 클래스란?
---------
*****
"문자열 : 여러게 문자를 나열"

1. String 클래스는 char[]와 메서드(기능)를 결합한 것
: String 클래스 = char[] + 메서드(기능)   

2. String 클래스는 내용을 변경할 수 없다.(read only = 읽기만 가능)
: String a = "a";  
String b = "b";  
a = a+b; => "ab"로 바뀌는게 아니라 "ab"라는 새로운게 만들어지고 a참조변수의 "ab"의 주소가 저장된다.  
= 문자열을 결합하면 변경되는것이 아니라 새로운 문자열이 만들어지는 것이다.  


String클래스의 주요 메서드
-----------------
*****

char charAt(int index) : 문자열에서 해당 위치(index)에 있는 문자를 반환한다.  
: String str = "ABCDE";  
char ch = str.charAt(3);  //문자열 str의 4번째 문자 'D'를 ch에 저장.  
-------------------  
index 0 1 2 3 4  
문자 'A''B''C''D''E'  
-------------------  


int length() : 문자열의 길이를 반환한다.  
: str.legnth() == 5

String substring(int from, int to) : 문자열에서 해당 범위(from~to)의 문자열을 반환한다.(to는 포함 안됨)  
: String str = "012345";  
String tmp = str.substring(1,4);  //str에서 index범위 1~4의 문자들을 반환(4는 포함되지 않는다.)  
System.out.println(tmp); //"123"이 출력된다.  

boolean equals(Object obj) : 문자열의 내용이 같은지 확인한다. 같으면 결과는 true, 다르면 false
: tmp.equals("123") == true  

char[] toCharArray() : 문자열을 문자배열(char[])로 변환해서 반환한다.
: char[] ch = tmp.toCharArray();
ch => {'1', '2', '3'}


