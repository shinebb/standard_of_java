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



String 클래스의 생성자와 메서드
===========


String 생성자
----------
*****

* String(String s) : 주어진 문자열(s)을 갖는 String 인스턴스를 생성한다.
* String(char[] value) : 주어진 문자열(value)을 갖는 String 인트턴스를 생성한다.
    

    char[] c = {'H','e','l','l','o'};
    String s = new String(c); //s="Hello"
    s.toCharArray(); //반대로


* String(StringBuffer buf) : StringBuffer 인스턴스가 갖고 있는 문자열과 같은 내용의 String 인스턴스를 생성한다.  
(내용 변경 가능)



String 메서드
-------
*****

* char charAt(int index) : 지정된 위치(index)에 있는 문자를 알려준다.(index는 0부터 시작)


    String s = "Hello";
    char c = s.charAt(1); //c='e'


* int compareTo(String str) : 문자열(str)과 사전순서로 비교한다. 같으면 0을, 사전순으로 이전이면 음수를, 이후면 양수를 반환한다.


    int i  = "aa".comperaTo("aa");  //i=0    같으면
    int i2 = "aa".comperaTo("bb");  //i2=-1  왼쪽이 작으면 음수
    int i3 = "bb".comperaTo("aa");  //i3=1   오른쪽이 작으면 양수
   

* String concat(String str) : 문자열(str)을 뒤에 덧붙인다.


    String s = "Hello";
    String s2 = s.concat(" World");  //s2 = "Hello World"


* boolean contains(CharSequence s) : 지정된 문자열(s)이 포함되어있는지 검사한다.  
  (CharSequence 는 interface 이다. -> 인터페이스의 장점 중 하나는 서로 관계없는 클래스들의 관계를 맺어준다.)  
  String, StringBuffer, CharBuffer 등 char[]을 다루는 클래스들이 공통조상이 없기때문에 CharSequence 라는 인터페이스를 통해 연결된다.


    String s = "abcdefg";
    boolean b = s.contains("bc"); //"abcdefg"에 "bc"가 포함되어있으니 true


* boolean endsWith(String suffix) : 지정된 문자열(suffix)로 끝나는지 검사한다.


    String file = "Hello.txt";
    boolean b = file.endsWith("txt");  //txt로 끝나는가? true
    boolean c = file.startsWith("txt");  //txt로 시작하는? false


* boolean equals(Object obj) : 매개변수로 받은 문자열(obj)과 String 인스턴스의 문자열을 비교한다.  
obj가 String이 아닌거나 문자열이 다르면 false를 반환한다.


    String s = "Hello";
    boolean b  = s.equals("Hello"); //true
    boolean b2 = s.equals("hello"); //false (대소문자 구분)


* boolean equalsIgnoreCase(String str) : 문자열과 String 인스턴스의 문자열을 대소문자 구분없이 비교한다.


    String s = "Hello";
    boolean b  = s.equalsIgnoreCase("Hello"); //true
    boolean b2 = s.equalsIgnoreCase("hello"); //true (대소문자 구분없음)


* int indexOf(int ch) : 주어진 문자(ch)가 문자열에 존재하는지 확인하여 위치(index)를 알려준다.  
못 찾으면 -1을 반환한다.(index는 0부터 시작)


    String s = "Hello";
    int idx1 = s.indexOf('o');  /4
    int idx2 = s.indexOf('k');  /-1 (없을 때)
    

* int indexOf(int ch, int pos) : 주어진 문자(ch)가 문자열에 존재하는지 지정된 위치(pos)부터 확인하여 위치(index)를 알려준다.  
    못 찾으면 -1을 반환한다. (index는 0부터 시작)


    String s = "Hello";
    int idx1 = s.indexOf('e', 0); //idx1 = 1
    int idx2 = s.indexOf('e', 2); //idx2 = -1


* int indexOf(String str) : 주어진 문자열이 존재하는지 확인하여 그 위치(index)를 알려준다. 없으면 -1을 반환한다. (index는 0부터 시작)


    String s = "ABCDEFG";
    int idx = s.indexOf("CD"); //idx = 2


* int lastIndexOf(int ch) : 지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서부터 찾아서 위치(index)를 알려준다.  
    못 찾으면 -1을 반환한다.


    String s = "java.lang.Object";
    int idx1 = s.lastIndexOf('.');   //idx1 = 9
    int idx2 = s.indexOf('.');       //idx2 = 4


* int lastIndexOf(String str) : 지정된 문자열을 인스턴스의 문자열 끝에서 부터 찾아서 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.


    String s = "java.lang.java";
    int idx1 = s.lastIndexOf("java");   //idx1 = 10
    int idx2 = s.indexOf("java");       //idx2 = 0


* int length() : 문자열의 길이를 알려준다.


    String s = "Hello";
    int length = s.length(); //length = 5


* String[] split(String regex) : 문자열을 지정된 분리자(regex)로 나누어 문자열 배열에 담아 반환한다.


    String animals = "dog, cat, bear";
    String[] arr = animals.split(","); //arr[0]="dog", arr[1]="cat", arr[2]="bear"


* String[] split(String regex, int limit) : 문자열을 지정된 분리자(regex)로 나누어 문자열배열에 담아 반환한다.  
    단, 문자열 전체를 지정된 수(limit)로 자른다.


    String animals = "dog, cat, bear";
    String[] arr = animals.split(",",2); //arr[0]="dog", arr[1]="cat, bear"


* boolean startWith(String prefix) : 주어진 문자열(prefix)로 시작하는지 검사한다.


    String s = "java.lang.Object";
    boolean b  = s.startsWith("java"); //b = true
    boolean b2 = s.startsWith("lang"); //b2 = false


* String substring(int begin) / String substring(int begin, int end) : 주어진 시작위치(begin)부터  
    끝 위치(end)범위에 포함된 문자열을 얻는다. 이 때, 시작위치의 문자는 범위에 포함되지만,  
    끝 위치의 문자는 포함되지 않는다.(begin <= x < end)


    String s = "java.lang.Object";
    String c = s.substring(10);   //c="Object" (인덱스 10부터 끝까지)
    String p = s.substring(5, 9); //p="lang"


* String toLowerCase() : String 인스턴스에 저장되어있는 모든 문자열을 소문자로 변환하여 반환한다.

    
    String s = "Hello";
    Stirng s1 = s.toLowerCase(); // s1 = "hello"


* String toUpperCase() : String 인스턴스에 저장되어있는 모든 문자열을 대문자로 변환하여 반환한다.


    String s = "Hello";
    Stirng s1 = s.toUpperCase(); // s1 = "HELLO"


* String trim() : 문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과를 반환한다.  
    이 때 문자열 중간에 있는 공백은 제거되지 않는다.


    String s = "         Hello World    ";
    String s1 = s.trim();  //s1 = "Hello World";


* static String valueOf(boolean b)(char c)(int i)(long l)(float f)(double d)(Object o) :  
    지정된 값을 문자열로 변환하여 반환한다. 참조변수의 경우, toString()을 호출한 결과를 반환한다.

    
    String b = String.valueOf(true); // b = "true"
    java.util.Date dd = new java.Util.Date();
    String date = String.valueOf(dd); // date="Wed Jan 27 21:26:29 KST 2024"

