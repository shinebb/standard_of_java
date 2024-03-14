Iterator(new), ListIterator, Enumeration(old)
==================

* 컬렉션에 저장된 데이터를 접근하는데 사용되는 인터페이스
* Enumeration은 Iterator의 구버전
* ListIterator는 Iterator의 접근성을 향상시킨 것(단방향 -> 양방향)


Iterator 메서드
----------
*****

* boolean hasNext() : 읽어 올 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환한다.
* Object next() : 다음 요소를 읽어 온다. next()를 호출하기 전에 hasNext()를 호출해서 읽어 올 요소가 있는지
    확인하는 것이 안전하다.


Enumeration 메서드
-----------
*****

* boolean hasMoreElements() : 읽어 올 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환한다.
* Object nextElement() : 다음 요소를 읽어 온다. nextElement()를 호출하기 전에 hasMoreElements()를 
  호출해서 읽어 올 요소가 있는지 확인하는 것이 안전하다.



Iterator 
------------
*****

* 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화한 것
* 컬렉션에 iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용.


    List list = new ArrayList(); //다른 컬렉션으로 변경할 때는 이 부분만 고치면 된다.
    Iterator it = list.iterator();

    while(it.hasNext()) { //읽어올 요소가 있는지 확인
        System.out.println(it.next()); 요소 일어오기
    }