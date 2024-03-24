컬렉션 프레임워크(collections framework)
======================


* 컬렉션(collection) : 여러 객체(테이터)를 모아 놓은 것을 의미
* 프레임워크(framework): 표준화, 정형화된 체계적인 프로그래밍 방식
* 라이브러리(library) : 미리 만들어놓은 기능들의 모음 (ex. JavaAPI(simpleDateFormat))

=> 생산성이 올라가고 유지보수도 쉬워진다.

* 컬렉션 프레임워크(collections framework) : 컬렉션(다수의 객체)를 다루기 위한 표준화된 프로그래밍 방식
* 컬렉션을 쉽고 편리하게 다룰 수 있는 다양한 클래스를 제공
* java.util 패키지에 포함

* 컬렉션 클래스(collection class) : 다수의 데이터를 저장할 수 있는 클래스(ex. Vector, ArrayList,HashSet)



컬렉션 프레임워크의 핵심 인터페이스
--------------
*****

* List
* Set
* Map
* Collection(List와 Set의 공통 부분을 뽑아낸것, Collection이 상위)


인터페이스별 특징
-----------
*****


* List : 순서가 있는 데이터의 집합. 데이터의 중복을 허용한다. (ex. 대기자 명단)
  * 구현클래스 : ArrayList, LinkedList, Stack, Vector 등
  * [저장] : 순서O, 중복O  
  

* set : 순서를 유지하지 않는 데이터의 집합. 데이터의 중복을 허용하지 않는다. (ex. 양의 정수집합, 소수의 집합)
  * 구현클래스 : HashSet, TreeSet 등
  * [집합] : 순서X, 중복X


* Map : 키(key)와 값(value)의 쌍(pair)으로 이루어진 데이터의 집합.  
    순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용한다. (ex. 아이디&패스워드, 우편번호, 지역번호(전화번호))
  * 구현클래스 : HashMap, TreeMap, Hashtable, Properties 등
  * [쌍] : 순서X, 중복(키X, 값O)  


Collection 인터페이스의 메서드
------------
*****

* [추가] boolean add(Object o) / addAll(Collection c) : 지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가한다.
* [전체삭제] void clear() : Collection의 모든 객체를 삭제한다.
* [검색] boolean contains(Object o) / containsAll(Collection c) : 지정된 객체(o) 또는 Collection의 객체들이 Collection에 포함되어 있는지 확인한다.
* boolean equals(Object o) : 동일한 Collection인지 비교한다.
* int hashCode() : Collection의 hash code를 반환한다.
* boolean isEmpty() : Collection이 비어있는지 확인한다.
* Iterator iterator() : Collection의 iterator를 얻어서 반환한다.
* [삭제] boolean remove(Object o) : 지정된 객체를 삭제한다.
* [삭제] boolean removeAll(Collection c) : 지정된 Collection에 포함된 객체들을 삭제한다.
* boolean retainAll(Collection c) : 지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다.
  이 작업으로 인해 Collection에 변화가 있으면 true를 그렇지 않으면 false를 반환한다.
* int size() : Collection에 저장된 객체의 개수를 반환한다.
* Object() toArray() : Collection에 저장된 객체를 객체배열(Object[])로 반환한다.
* Object() toArray(Object[] a) : 지정된 배열에 Collection의 객체를 저장해서 반환한다.


List 인터페이스 - 순서O, 중복O
-------
*****

(Vector) / (Stack) / ArrayList / LinkedList     


* [추가] void add(int index, Object element) / boolean addAll(int index, Collection c) 
: 지정된 위치(index)에 객체(element) 또는 컬렉션에 포함된 객체들을 추가한다.

* [읽기] Object get(int index) 
: 지정된 위치(index)에 있는 객체를 반환한다.

* [검색] int indexOf(Object o) 
: 지정된 객체의 위치(index)를 반환한다. (List의 첫 번째 요소부터 순방향으로 찾는다.)

* [검색] int LastIndexOf(Object o) 
: 지정된 객체의 위치(index)를 반환한다. (List의 마지막 요소부터 역방향으로 찾는다.)

* ListIterator listIterator() / ListIterator listIterator(int idex) 
: List의 객체에 접근할 수 있는 ListIterator를 반환한다.
* 
* [삭제] Object remove(int index) 
: 지정된 위치(index)에 있는 객체를 삭제하고 삭제된 객체를 반환한다.

* [변경] Object set(int index, Object element) 
: 지정된 위치(index)에 객체(element)를 저장한다.

* void sort(Comparator c) 
: 지정된 비교자(comparator)로 List를 정렬한다.

* List subList(int fromIndex, int toIndex) 
: 지정된 번위(fromIndex부터 toIndex)에 있는 객체를 반환한다.



Set 인터페이스 - 순서X, 중복X
-------
*****

HashSet / (SortedSet) / TreeSet   
Set 인터페이스의 메서드는 Collection 인터페이스와 동일하다.      
집합과 관련된 메서드(Collection에 변화가 있으면 true, 아니면 false를 반환.)  



* [추가] boolean add(Object o) / [합집합] addAll(Collection c) 
: 지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가한다.

* [전체삭제] void clear() 
: Collection의 모든 객체를 삭제한다.

* [검색] boolean contains(Object o) / [부분집합] containsAll(Collection c) 
: 지정된 객체(o) 또는 Collection의 객체들이 Collection에 포함되어 있는지 확인한다.

* boolean equals(Object o) 
: 동일한 Collection인지 비교한다.

* int hashCode() 
: Collection의 hash code를 반환한다.

* boolean isEmpty() 
: Collection이 비어있는지 확인한다.

* Iterator iterator() 
: Collection의 iterator를 얻어서 반환한다.

* [삭제] boolean remove(Object o) 
: 지정된 객체를 삭제한다.

* [삭제][차집합] boolean removeAll(Collection c) 
: 지정된 Collection에 포함된 객체들을 삭제한다.

* [교집합] boolean retainAll(Collection c) 
: 지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다.  
  이 작업으로 인해 Collection에 변화가 있으면 true를 그렇지 않으면 false를 반환한다.

* int size() 
: Collection에 저장된 객체의 개수를 반환한다.

* Object() toArray() 
: Collection에 저장된 객체를 객체배열(Object[])로 반환한다.

* Object() toArray(Object[] a) 
: 지정된 배열에 Collection의 객체를 저장해서 반환한다.



Map 인터페이스 - 순서X, 중복(키X, 값O)
-------------
*****

(Hashtable) / HashMap / (LinkedHashMap(순서O)) / (sortedMap) / TreeMap


* void clear() 
: Map의 모든 객체를 삭제한다.

* [검색] boolean containsKey(Object key)
: 지정된 key객체와 일치하는 Map의 Key객체가 있는지 확인한다.

* [검색] boolean containsValue(Object value) 
: 지정된 value객체와 일치하는 Map의 Value객체가 있는 확인한다.

* [읽기] Set entrySet() 
: Map에 저장되어 있는 key-value 쌍을 Map.Entry 타입의 객체로 저장한 Set으로 반환한다.

* boolean equals(Object o) 
: 동일한 Map인지 비교한다.

* [검색] Object get(Object key) 
: 지정한 key객체에 대응하는 value 객체를 찾아서 반환한다.

* int hashCode() 
: 해시코드를 반환한다.

* boolean insEmpty() 
: Map이 비어있는지 확인한다.

* [읽기] Set keySet() 
: Map에 저장된 모든 key 객체를 반환한다.

* [추가] Object put(Object key, Object value) 
: Map에 value객체를 key객체에 연결(mapping)하여 저장한다.

* [추가] void putAll(Map t) 
: 지정된 Map의 모든 Key-value 쌍을 추가한다.

* [삭제] Object remove(Object key) 
: 지정한 key객체와 일치하는 key-value객체를 삭제한다.

* int size() 
: Map에 저장된 key-value 쌍의 개수를 반환한다.

* [읽기] Collection values() 
: Map에 저장된 모든 value객체를 반환한다.



Collections class
====================

* 컬렉션을 위한 메서드(static)를 제공
* 컬렉션 채우기, 복사, 정렬, 검색 - fill(), copy(), sort(), binarySearch() 등
* 컬렉션의 동기화 - synchronizedXXXX()


    static Collection synchronizedCollection(Colleciont c)
    static List synchronizedList(List list)
    static Set synchronizedSet(Set s)
    static Map synchronizedMap(Map m)
    static SortedSet synchronizedSortedSet(SortedSet s)
    static SortedMap synchronizedSortedMap(SortedMap m)


* 변경불가(readOnly) 컬렉션 만들기 - unmodifiableXXX()


    static Collection unmodifiableCollection(Colleciont c)
    static List unmodifiableList(List list)
    static Set unmodifiableSet(Set s)
    static Map unmodifiableMap(Map m)
    static NavigableSet unmodifiableNavigableSet(NavigableSet s)
    static SortedSet unmodifiableSortedSet(SortedSet s)
    static NavigableMap unmodifiableNavigableMap(NavigableMap s)
    static SortedMap unmodifiableSortedMap(SortedMap m)


* 싱글톤 컬렉션 만들기 - singletonXXX() : 객체 한개만 저장할 수 있음


    static List singletonList(Object o)
    static Set singleton(Object o)
    static Map singletonMap(Object key, Object value)


* 한 종류의 객체만 저장하는 컬렉션 만들기() - checkedXXX()


    static Collection checkedCollection(Colleciont c, Class type)
    static List checkedList(List list, Class type)
    static Set checkedSet(Set s, Class type)
    static Map checkedMap(Map m, Class keyType, Class valueType)
    static Queue checkedQueue(Queue queue, Class type)
    static NavigableSet checkedNavigableSet(NavigableSet s, Class type)
    static SortedSet checkedSortedSet(SortedSet s, Class type)
    static NavigableMap checkedNavigableMap(NavigableMap s, Class keyType, Class valueType)
    static SortedMap checkedSortedMap(SortedMap m, Class keyType, Class valueType)



컬렉션 클래스 정리 및 요약
==============


* ArrayList / Vector: (Obejct [])을 가지고 있고 여기에 객체를 저장하는 배열 기반의 컬렉션 클래스이다.
* 이걸 기본으로 만든게 Stack이다 : LIFO 구조를 가지고 있음 (List In Fiast Out)

* 배열의 단점은 추가, 삭제가 불리하다. 
* 이 단점을 보완한게 LinkedList : 연결기반의 컬렉션 클래스
* LinkedList를 기반으로 만든게 Queue : FIFO 구조 (First In First Out)

* 검색기능을 향상 시킨 게 HashMap : 배열과 LinkedList를 결합
* 배열의 장점 + LinkedList의 장점
* Key, Value를 쌍으로 저장하고 있다.

* TreeMap : 최대 2개까지 연결할 수 있는 트리구조로 되어있다.
* 검색, 범위검색, 정렬기능 향상

* HashSet / TreeSet : HashMap과 TreeMap의 Key부분을 가지고 만들어짐

* Properties : (String, String) Key와 Value인데 문자열로만 저장 가능.

* LinkedHashMap / LinkedHashSet : HashMap과 HashSet은 순서X이므로, 순서유지가 필요할 때 사용
