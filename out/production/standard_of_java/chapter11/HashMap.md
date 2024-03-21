HashMap와 Hashtable
==============

* 순서X, 중복(키X, 값O)
* Map 인터페이스를 구현. 데이터를 키와 값의 쌍으로 저장
* Map -> Hashtable, HashMap, SortedMap -> LinkedHashMap, TreeMap

[HashMap]
* Map 인터페이스를 구현한 대표적인 컬렉션 클래스
* 순서를 유지하려면, LinkedHashMap클래스를 사용하면 된다.

[TreeMap] - TreeSep과 비슷
* 범위 검색과 정렬에 유리한 컬렉션 클래스
* HashMap보다 데이터 추가, 삭제에 시간이 더 걸림



HashMap의 키(key)와 값(value)
--------------
*****

* 해싱(hashing)기법으로 데이터를 저장. 데이터가 많아도 검색이 빠르다.
* Map인터페이스를 구현. 데이터를 키와 값의 쌍으로 저장


[키(key)] : 컬렉션 내의 키(key)중에서 유일해야 한다.  
[값(value)] : 키(key)와 달리 데이터의 중복을 허용한다.


해싱(hashing)
----------
*****

* 해시함수(hash function)로 해시테이블(hash table)에 데이터를 저장, 검색
* 해시테이블은 배열과 링크드리스트가 조합된 형태
* 해시테이블에 저장된 데이터를 가져오는 과정
  * 키로 해시함수를 호출해서 해시코드를 얻는다.
  * 해시코드(해시함수의 반환값)에 대응하는 링크드리스트를 배열에서 찾는다.
  * 링크드리스트에서 키와 일치하는 데이터를 찾는다.
  * 해시함수는 같은 키에 대해 항상 같은 해시코드를 반환해야 한다.
  * 서로 다른 키일지라도 같은 값의 해시코드를 반환할 수도 있다.


HashMap - 주요 메서드
--------
*****

[생성자]
* HashMap()
* HashMap(int initialCapacity) : 배열 초기 용량 지정
* HashMap(int initialCapacity, float loadFactor) : 
* HashMap(Map m) : 다른 Map을 HashMap으로 


[메서드]
* Object put(Object key, Object value) : 키, 벨류 쌍으로 추가
* void putAll(Map m) : Map 추가
* Object remove(Object key) : 삭제
* Object replace(Object key, Object value) : 변경
* boolean replace(Object key, Object oldValue, Object newValue) : 변경

* Set entrySet(): 키, 벨류 쌍 하나가 엔트리
* Set keySet() : 키만 가져옴
* Collection values() : 값만 가져옴

* Object get(Object key) : 키에 해당하는 값 반환
* Object getOrDefault(Object key, Object defaultValue) : 키가 없을 때 defaultValue 지정된 값 반환
* boolean containsKey(Object key) : 키 중에 지정된 값이 있는지
* boolean containsValue(Object value) : 벨류 중에 지정된 값이 있는지

* int size() : 맵사이즈 반환
* boolean isEmpty() : 비어있는지
* void clear() : 모두 삭제
* Object clone() : 복제