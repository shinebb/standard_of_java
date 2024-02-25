Object 클래스
==================

* 모든 클래스의 최고 조상. 오직 11개의 메서드만을 가지고 있다.
* notify(), wait() 등은 쓰레드와 관련된 메서드이다.


Object 클래스의 메서드
---------------------
*****

* protected Object clone() : 객체 자신의 복사본을 반환한다.
* public boolean equals(Object obj) : 객체 자신과 객체 obj가 같은 객체인지 알려준다.(같으면 true)
* protected void finalize() : 객체가 소멸될 때 사비지 컬렉터에 의해 자동적으로 호출된다.  
        이때 수행되어야하는 코드가 있을 때 오버라이딩한다.(거의 사용안함)
* public Class getClass() : 객체 자신의 클래스 정보를 담고 있는 Class 인스턴스를 반환한다.(C가 대문자여야함)
* public int hashCode() : 객체 자신의 해시코드를 반환한다.
* public String toString() : 객체 자신의 정보를 문자열로 반환한다.
* public void notify() : 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다.
* public void notifyAll() : 객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨운다.
* public void wait() / (long timeout) / (long timeout, int nanos) : 다른 쓰레드가
        notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간(timeout, nanos) 동안
        기다리게 한다. (timeout은 천 분의 1호, nanos는 10(9승)분의 1초)



(protected 메서드들은 오버라이딩하여 public으로 변경해야한다.)


equals(Object obj)
---------------------
*****

* 객체 자신(this)과 주어진 객체(obj)를 비교한다. 같으면 ture 다르면 false
* Object 클래스의 equals()는 객체의 주소를 비교한다.(참조변수 값 비교)


        public boolean equals(Object obj) {
                return (this==obj);
        }















