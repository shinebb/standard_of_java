TreeSet
=============

* 범위 탐색, 정렬
* 이진 탐색 트리(binary search tree)로 구현. 범위 탐색과 정렬에 유리
* 이진 트리는 모든 노드가 최대 2개의 하위 노드를 갖음
* 각 요소(node)가 나무(tree) 형태로 연결(LinkedList의 변형)


이진 탐색 트리(binary search tree)
---------
*****

* 부모보다 작은 값은 왼쪽, 큰 값은 오른쪽에 저장
* 데이터가 많아질수록 추가, 삭제에 시간이 더 걸림(비교 횟수 증가)


TreeSet - 데이터 저장과정 
--------
*****

* boolean add(Object o)


* TreeSet에 7,4,9,1,5의 순서로 데이터를 저장하면, 루트부터 트리를 따라 내려가며 값을 비교.
* 작으면 왼쪽 크면 오른쪽에 저장.
* 루트는 처음 시작되는 7 그 밑에 4,9 그 다음 4밑에 1,5


TreeSet - 주요 생성자와 메서드
-------
*****

(Collection 인터페이스에서 제공하는 add(), size(), remove(), isEmpty(), iterator() 같은 건 제외)  


[생성자]

* TreeSet() : 기본생성자
* TreeSet(Collection c) : 주어진 컬렉션을 저장하는 TreeSet을 생성
* TreeSet(Comparator comp) : 주어진 정렬기준(비교기준)으로 정렬하는 TreeSet을 생성


[메서드]
* Object first() : 정렬된 순서에서 첫 번째 객체를 반환한다.
* Object last() : 정렬된 순서에서 마지막 객체를 반환한다.
* Object ceiling(Object o) : 지정된 객체와 같은 객체를 반환. 없으면 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환. 없으면 null
* Object floor(Object o) : 지정된 객체와 같은 객체를 반환. 없으면 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환. 없으면 null
* Object higher(Object o) : 지정된 객체보다 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환. 없으면 null
* Object lower(Object o) : 지정된 객체보다 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환. 없으면 null

* SortedSet subSet(Object fromElement, Object toElement) : 범위 검색(fromElement와 toElement사이)의 결과를 반환한다.
  (끝 번위인 toElement는 범위에 포함되지 않음)
* SortedSet headSet(Object toElement) : 지정된 객체보다 작은 값의 객체들을 반환한다.
* SortedSet tailSet(Object toElement) : 지정된 객체보다 큰 값의 객체들을 반환한다.


