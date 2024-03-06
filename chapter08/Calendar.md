날짜와 시간
==================


java.util.Date
----------
*****

* 날짜와 시간을 다룰 목적으로 만들어진 클래스
* Date의 메서드는 거의 deprecated(앞으로 사용X) 되었지만, 여전히 쓰이고 있다.


java.util.Calendar
-------------
*****

* Date 클래스를 개선한 새로운 클래스
* 여전히 단점이 존재


java.time 패키지
------
*****

* Date와 Calendar의 단점(날짜와 시간을 함께 다룸)을 개선한 새로운 클래스들을 제공
* 날짜만 다룰때는 LocalDate, 시간만 다울때는 LocalTime, 모두 다룰 때에는 LocalDateTime



Calendar 클래스
----------
*****

* 추상클래스이므로 getInstance()를 통해 구현된 객체를 얻어야 한다.


    Calendar cal = new Calendar();  //###error### 추상클래스는 인스턴스를 생성할 수 없다.
    
    //OK, getInstance()메서드는 Calendar 클래스를 구현한 클래스의 인스턴스를 반환한다.
    Calendar cal = Calendar.getInstance();


* get()으로 날짜와 시간 필드 가져오기 - int get(int field)


    Calendar cal = Calendar.getInstance();  //현재 날짜와 시간으로 셋팅됨
    int thisYear = cal.get(Calendar.YEAR);  //올해가 몇년인지 알아낸다.
    int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE); //이 달의 마지막날


* Calendar에 정의된 필드(날짜)
  * YEAR : 년
  * MONTH : 월(0부터시작 : 0=1월 11=12월)
  * WEEK_OF_YEAR : 그 해의 몇 번째 주
  * WEEK_OF_MONTH : 그 달의 몇 번째 주
  * DATE : 일
  * DAY_OF_MONTH : 그 달이 몇 번째일
  * DAY_OF_YEAR : 그 해의 몇 번째일
  * DAY_OF_WEEK : 요일(1~7 : =:일요일)
  * DAY_OF_WEEK_IN_MONTH : 그 달의 몇 번째 요일  


* Calendar에 정의된 필드(시간)
  * HOUR : 시간(0~11)
  * HOUR_OF_DAY : 시간(0~23)
  * MINUTE : 분
  * SECOND : 초
  * MILLISECOND : 천분의 일초
  * ZONE_OFFSET : GMT 기준 시차(천분의 일초 단위, 한국은 GMT 기준 +9)
  * AM_PM : 오전/오후(0=오전, 1=오후)


set()으로 날짜와 시간지정하기
---------------
*****

* void set(int field, int value)
* void set(int year, int month, int date) //년월일
* void set(int year, int month, int date, int hourOfDay, int minute)
* void set(int year, int month, int date, int hourOfDay, int minute, int second) /년월일 시분초


    Calendar date1 = Calendar.getInstance();
    date1.set(2017, 7, 15); //2017년 8월 15일(#####7월 아님 주의#####)
    //또는
    date1.set(Calendar.YEAR, 2017);
    date1.set(Calendar.MONTH, 7); //8월
    date1.set(Calendar.DATE, 15);

    //시간만 지정하는 메서드는 없으므로 필드 하나하나 넣어줘야함.(아니면 3-4번째 set이용)
    Calendar time1 = Calendar.getInstance();
    time1.set(Calendar.HOUR_OF_DAY, 10); //10시 20분 30초 설청
    time1.set(Calendar.MINUTE, 20); 
    time1.set(Calendar.SECOND, 30); 


clear()는 Calendar 객체의 모든 필드를 초기화 한다.
---------
*****


    Calendar dt = Calendar.getInstance(); //현재시간
    
    //오늘 날짜 현재 시간
    System.out.println(new Date(dt.getTimeInMillis())); //보기편하게 new Date 사용

    dt.clear(); //모든 필드를 초기화
    //EPOCH TIME
    //1970년 1월 1일 00:00:00초 초기화된다.
    System.out.println(new Date(dt.getTimeInMillis()));


clear(int field)는 Calendar 객체의 특정 필드를 초기화
---------
*****


    Calendar dt = Calendar.getInstance(); //현재시간
    
    //오늘 날짜 현재 시간
    System.out.println(new Date(dt.getTimeInMillis())); //보기편하게 new Date 사용

    dt.clear(Calendar.SECOND); //0초로 초기화
    dt.clear(Calendar.MINUTE); //0분으로 초기화
    dt.clear(Calendar.HOUR_OF_DAY); //0시로 초기화
    dt.clear(Calendar.HOUR); //0시로 초기화


add()는 특정 필드의 값을 증가 또는 감소(다른 필드에 영향O)
--------------
*****

  
    Calendar date = Calendar.getInstance(); //현재시간
    date.clear(); //모든 필드를 초기화
    date.set(2020, 7, 31); //2020년 8월 31일로 설정

    date.add(Calendar.DATE, 1); //날짜 일(DATE)에 1을 더한다. = 9월1일 
    date.add(Calendar.MONTH, -8); //날짜 월(MONTH)에 8을 뺀다. = 1월1일


roll()은 특정필드의 값을 증가 또는 감소(다른 필드에 영향X)
---------
*****

    
    date.set(2020, 7, 31); //2020년 8월 31일로 설정

    date.roll(Calendar.DATE, 1); //날짜 일(DATE)에 1을 더한다. = 8월1일 
    date.roll(Calendar.MONTH, -8); //날짜 월(MONTH)에 8을 뺀다. = 2020년 12월 31일


Date와 Calendar간의 변환
-----
*****

* Date의 메서드는 대부분 deprecated(사용하지 않을 것을 권장)되었지만 여전히 사용


    //Calendar를 Date로 변환
    Calendar cal = Calendar.getInstance();
    ...
    Date d = new Date(cal.getTimeInMillis()); //Date(long date)

    //Date를 Calendar로 변환
    Date d = new Date();
    ...
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);



형식화 클래스
======================

* java.text 패키지의 DecimalFormat(숫자), SimpleDateFormat(날짜)
* 숫자와 날짜를 원하는 형식으로 쉽게 출력 가능(숫자, 날짜 -> 형식 문자열)
* 형식 문자열에서 숫자와 날짜를 뽑아내는 기능(형식 문자열 -> 숫자, 날짜)


DecimalFormat
------------------
*****

* 숫자(10진수)를 형식화할 때 사용(숫자->형식문자열)


    double number = 1234567.89;
    DecimalFormat df = new DecimalFormat("#.#E0"); //지수형식 표현
    String result = df.format(number); //result = "1.2E6"

* 특정 형식의 문자열을 숫자로 변환할 때도 사용(형식문자열->숫자)


    DecimalFormat df = new DecimalFormat("#,###.##"); 
    Number num = df.parse("1,234,567.89"); //Number : 모든 숫자 래퍼클래스의 최고 조상
    double d = num.doubleValue(); //1234567.89


* [참고] Integer.parseInt(), Float.parseFloat()는 콤마(,)가 포함된 문자열을 숫자로 변환 못함


SimpleDateFormat
----------
*****

* 날짜와 시간을 다양한 형식으로 출력할 수 있게 해준다.

  
    Date today = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    //오늘 날짜를 yyyy-MM-dd 형태로 변환하여 반환한다.
    String result = df.format(today);

    
<br>

* G : 연대(BC, AD)
* y : 년도 
* M : 월(1~12 또는 1월~12월)
* w : 년의 몇 번째 주(1~53)
* W : 월의 몇 번째 주(1~5)
* D : 년의 몇 번째 일(1~366)
* d : 월의 몇 번째 일(1~31)
* F : 월의 몇 번째 요일(1~5)
* E : 요일

<br>

* 특정 형식으로 되어 있는 문자열에서 날짜와 시간을 뽑아낼 수도 있다.


    DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
    DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd);
    Date d = df.parse("2025년 11월 23일); //문자열을 Date로 변환
    String reuslt = df2.format(d);


<br>

* a : 오전/오후(AM,PM)
* H : 시간(0~23)
* k : 시간(1~24)
* K : 시간(0~11)
* h : 시간(1~12)
* m : 분(0~59)
* s : 초(0~59)
* S : 천분의 일초(0~999)
* z : Time zone(General time zone)
* Z : Time zone(RFC 822 time zone)
* ' : escape 문자(특수문자를 표현하는데 사용)




