HashSet
========

* 순서X, 중복X
* Set - HashSet, SortedSet - TreeSet


HashSet
: Set 인터페이스를 구현한 대표적인 컬렉션 클래스  
순서를 유지하려면, LinkedHashSet 클래스를 사용하면 된다.

TreeSet
: 범위 검색과 정렬에 유리한 컬렉션 클래스(from~to)  
HashSet 보다 데이터 추가, 삭제에 시간이 더 걸림


HashSet - 주요 메서드
--------
*****

[생성자]

* HashSet() : 기본 생성자
* HashSet(Collection c) : 지정된 컬렉션의 모든 객체를 저장 
* HashSet(int initialCapacity) : 초기 용량 설정
* HashSet(int initialCapacity, float loadFactor) : 초기 용량을 언제 2배로 올리는가?  
  ex) loadFactor = 0.8 이면 -> 초기 용량이 80% 찼을 때 x2가 된다.


[메서드]

* boolean add(Object o) : 추가
* boolean addAll(Collection c) : 추가(합집합)
* boolean remove(Object c) : 삭제
* boolean removeAll(Collection c) : 삭제(교집합)
* boolean retainAll(Collection c) : 조건부 삭제(차집합 - Collection c를 제외하고 삭제)
* void clear() : 모두 삭제   
    

* boolean contains(Object o) : 포함여부
* boolean containsAll(Collection c) : 컬렉션에 담긴 여러 객체가 모두 포함되어있는가
* Iterator iterator() : 컬렉션 요소 읽어오기


* boolean isEmpty() : 비어있는지
* int size() : 저장된 객체의 개수
* Object[] toArray() : 객체 배열로 반환
* Object[] toArray(Object[] a)


HashSet 특징
-----
*****

* HashSet은 객체를 저장하기전에 기존에 같은 객체가 있는지 확인한다. (순서X, 중복X 이기 때문에)
* 같은 객체가 없으면 저장하고, 있으면 저장하지 않는다.
* boolean add(Object o)는 저장할 객체의 equals()와 hashCode()를 호출한다.
* equals()와 hashCode()가 오버라이딩 되어있어야 함.