List
====================


ArrayList 
----------
*****

* ArrayList는 기존의 Vector를 개선한 것으로 구현원리와 기능적으로 동일
* ArrayList와 달리 Vector는 자체적으로 동기화처리가 되어있다.
* List 인터페이스를 구현하므로, 저장순서가 유지되고 중복을 허용한다.
* 데이터의 저장공간으로 배열을 사용한다. (배열기반)


ArrayList의 메서드
-----------
*****

[생성자]
* ArrayList() : 기본생성자
* ArrayList(Collection c) : 컬렉션을 ArrayList로 변환
* ArrayList(initialCapacity) : 배열의 길이 넣어줌


[추가]
* boolean add(Object o) : ArrayList에 객체 Object 객체 추가 (성공 시 true / 실패시 false)
* void add(int index, Object element) :  저장위치 index 지정
* boolean addAll(Collection c) : collection 요소 전체 저장
* boolean addAll(int index, Collection c) : 저장위치 index 지정

[삭제]
* boolean remove(Object o) : Object 객체 삭제 (성공 시 true / 실패시 false)
* Object remove(int index) : 삭제위치 index 지정
* boolean removeAll(Collection c) : collection 요소 전체 삭제
* void clear() : ArrayList에 있는 모든 객체 삭제

[검색]
* int indexOf(Object o) : 객체가 몇번째 인덱스에 있는지 반환 (못 찾으면 -1 반환)
* int lastIndexOf(Object o) : 배열 맨 뒤에부터 몇번째 인덱스에 있는지 반환
* boolean contains(Object o) : 해당 객체가 존재하는지
* Object get(int index) : 특정 위치에 있는 객체 반환
* Object set(int index, Object element) : 특정 위치에 있는 객체 변경

[이외]
* List subList(int fromIndex, int toIndex) : from~to 사이에 객체들을 뽑아서 새로운 List를 만들어 반환
* Object[] toArray() : ArrayList가 가지고있는 객체배열을 반환
* Object[] toArray(Object[] a) 
* boolean isEmpty() : ArrayList가 비어있는지 확인
* void trimToSize() : 빈공간제거
* int size() : ArrayList에 저장된 객체의 갯수 반환


ArrayList에 저장된 객체의 삭제과정
-------------
*****

* ArrayList에 저장된 세 번째 데이터(data[2])를 삭제하는 과정. list.remove(2);를 호출
  * 삭제할 데이터 아래의 데이터를 한 칸씩 위로 복사해서 삭제할 데이터를 덮어쓴다.
  * 데이터가 모두 한 칸씩 이동했으므로 마지막 데이터는 null로 변경한다.
  * 데이터가 삭제되어 데이터의 개수가 줄었으므로 size의 값을 감소시킨다.
* 삽입할 때에는 반대로 아래로 복사 후 사이즈는 늘린다.
* 마지막 데이터를 삭제하는 경우 1번의 과정(배열의 복사)은 필요없다.


* ArrayList에 저장된 첫 번째 객체부터 삭제하는 경우(배열 복사 발생) : 성능상으로도 안좋고, 다 지워지지도 않음.
* ArrayList에 저장된 마지막 객체부터 삭제하는 경우(배열 복사 발생안함) : 더 빠르다.


Java API 소스 보기
----------------
*****

* /jdk설치경로/src.zip
* 인텔리제이 : ctrl+해당 api 클릭