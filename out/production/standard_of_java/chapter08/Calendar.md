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













