StringBuffer 클래스
================

* String 처럼 문자형 배열(char[])을 내부적으로 가지고 있다.
* 그러나, String과 달리 내용을 변경할 수 있다.(mutable)


    StringBuffer sb = new StringBuffer("abc"); //abc
    sb.append("123");   //abc123 ->주소값 변환없이 객체 sb의 값만 변경됨

* 배열은 길이 변경불가. 공간이 부족하면 새로운 배열 생성해야한다.
* StringBuffer는 저장할 문자열의 길이를 고려해서 적절한 크기로 생성해야 한다.


    public StringBuffer(int length){ //legnth로 적절한 크기 지정 가능
        value = new char[length]
        sharee = false;
    }

    public StringBuffer() {
        this(16);       //버퍼의 크기를 지정하지 않으면 퍼버의 크기는 16이 된다.
    }

    public StringBuffer(String str) {
        this(str.length() + 16); //지정한 문자열의 길이보다 16이 더 크게 버퍼를 생성한다.
        sppend(str);
    }


* StringBuffer는 String과 달리 내용 변경이 가능하다.


StringBuffer의 비교
--------
*****

* StringBuffer는 equals()가 오버라이딩되어있지 않다.(주소비교)


    StringBuffer sb = new StringBuffer("abc");
    StringBuffer sb2 = new StringBuffer("abc");

    System.out.println(sb==sb2);  //false
    System.out.println(sb.equals(sb2));  //false


* StringBuffer를 String으로 변환후에 equals()로 비교해야 한다.


    String s = sb.toString();  //sb를 String으로 변환
    String s2 = sb2.toString(); 

    System.out.println(s.equals(s2)); //true


StringBuffer의 생성자와 메서드
------------
*****

* StringBuffer() : 16문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.


    StringBuffer sb = new StringBuffer();


* StringBuffer(int length) : 지정된 개수의 문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.


    StringBuffer sb = new StringBuffer(10);


* StringBuffer(String str) : 지정된 문자열 값(str)을 갖는 StringBuffer 인스턴스를 생성한다.


    StringBuffer sb = new StringBuffer("Hi"); //크기 2 +16


* StringBuffer append(매개변수) : 매개변수로 입력된 값을 문자열로 변환하여 StringBuffer 인스턴스가 저장하고 있는 문자열의 뒤에 덧붙인다.


    StringBuffer sb = new StringBuffer("abc");
    StringBuffer sb2 = sb.append(true); //abctrue


* int capacity() : StringBuffer 인스턴스의 버퍼크기(char[])를 알려준다. length()는 버퍼에 담긴 문자열의 길이를 알려준다.


    StringBuffer sb = new StringBuffer(100);
    sb.append("abcd");
    int bufferSize = sb.capacity(); //100
    int stringSize = sb.legnth(); //4


* char charAt(int index) : 지정된 위치(index)에 있는 문자를 반환한다.


    StringBuffer sb = new StringBuffer("abc");
    char c = sb.charAt(2); //c


* StringBuffer delete(int start, int end) : 시작위치(start)부터 끝 위치(end) 사이에 있는 문자를 제거한다. 단, 끝 위치의 문자는 제외

    
    StringBuffer sb = new StringBuffer("0123456");
    StringBuffer sb2 = sb.delete(3,6); //0126


* StringBuffer deleteCharAt(int index) : 지정된 위치(index)의 문자를 제거한다.


    StringBuffer sb = new StringBuffer("0123456");
    StringBuffer sb2 = sb.deleteCharAt(3); //012456


* StringBuffer insert(int pos, 매개변수) : 두 번째 매개변수로 받은 값을 문자열로 변환하여 지정된 위치(pos)에 추가한다. pos는 0부터 시작

    
    StringBuffer sb = new StringBuffer("0123456");
    sb.insert(4, '.'); //0123.456


* int length() : StringBuffer 인스턴스에 저장되어 있는 문자열의 길이를 반환한다.


    StringBuffer sb new StringBuffer("0123456");
    int length = sb.length(); //7


* StringBuffer replace(int start, int end, String str) : 지정된 범위(start~end)의 문자들을 주어진 문자열로 바꾼다.
    end 위치의 문자는 범위에 포한 되지 않는다.(start<=x<end)


    StringBuffer sb = new StringBuffer("0123456");
    sb.replace(3, 6, "AB"); //012AB6 -> "345"가 "AB"로 바뀌었다.


* StringBuffer reverse() : StringBuffer 인스턴스에 저장되어 있는 문자열의 순서를 거꾸로 나열한다.


    StringBuffer sb = new StringBuffer("0123456");
    sb.reverse(); //6543210


* void setCharAt(int index, char ch) : 지정된 위치의 문자를 주어진 문자(ch)로 바꾼다.


    StringBuffer sb = new StringBuffer("0123456");
    sb.setCharAt(5, 'o'); //01234o6


* void setLength(int newLength) : 지정된 길이로 문자열의 길이를 변경한다. 길이를 늘리는 경우에 나머지 빈 공간을 널문자 '\u0000'로 채운다.


    StringBuffer sb = new StringBuffer("0123456");
    sb.setLength(5); //"01234"

    StringBuffer sb2 = new StringBuffer("0123456");
    sb2.setLength(10); //"0123456    "
    String str = sb2.toString().trim(); //"0123456" 양끝의 빈 공백 제거


* String toString() : StringBuffer 인스턴스의 문자열을 String으로 반환


    StringBuffer sb = new StringBuffer("0123456");
    String str = sb.toString(); //"0123456"


* String substring(int start) / (int start, int end) : 지정된 범위 내의 문자열을 String으로 뽑아서 반환한다.
    시작위치(start)만 지정하면 시작위치부터 문자열 끝까지 뽑아서 반환한다.


    StringBuffer sb = new StringBuffer("0123456");
    String str = sb.substring(3); //3456
    String str2 = sb.substring(3,5); //34


StringBuilder
-----------
*****

* StringBuffer는 동기화되어 있다. 멀티 쓰레드에 안전(thread-safe)
* StringBuiler는 동기화 되어있지 않다.
* 멀티 쓰레드 프로그램이 아닌 경우, 동기화는 불필요한 성능저하가 나타날 수 있다
* 이럴 땐 StringBuffer 대신 StringBuilder를 사용하면 성능 향상에 도움이 된다.
    
*싱글 쓰레드 : 한번에 1개 작업  
*멀티 쓰레드 : 한번에 n개 작업(동시진행) - 데이터를 공유하다보면 데이터가 꼬일 수 있다. 이때 데이터를 보호하는 것이 동기화이다.  






















