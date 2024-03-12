스택과 큐(Stack & Queue)
====================


스택(Stack) : 클래스
-------------
*****

* LIFO 구조 (Last In First Out) : 마지막에 저장된 것을 제일 먼저 꺼내게 된다.
* 저장(push) / 추출(pop) : 저장할 때와 추출할 때의 순서가 반대이다.
* ex) 밑이 막힌 상자 박스(위로만 넣고 빼는게 가능하다.)
* 배열에 적합
* Stack s = new Stack();


큐(Queue) : 인터페이스
--------
*****

* FIFO 구조 (First In First Out) : 제일 먼저 저장한 것을 제일 먼저 꺼내게 된다.
* 저장(offer) / 추출(poll) : 저장할 때와 추출할 때의 순서가 같다.
* ex) 양 끝이 뚫린 상자, 줄서기(위에서 넣고 아래로 뺀다.)
* 링크드리스트에 적합
* 큐는 인터페이스이기 때문에 객체를 만들 수 없다. 따라서 Queue를 구현한 클래스를 사용해야한다.
* ex) Queue q = new LinkedList();


스택과 큐(Stack & Queue)의 메서드
------------
*****

[스택(Stack)의 메서드]
* boolean empty() : Stack이 비어있는지 알려준다.
* Object peek() : Stack의 맨 위에 저장된 객체를 반환. pop()과 달리 Stack에서 객체를 꺼내지 않음.  
  (비어있을 때는 EmptyStackException 발생)
* Object pop() : Stack의 맨 위에 저장된 객체를 꺼낸다.  
  (비어있을 때는 EmptyStackException 발생)
* Object push(Object item) : Stack에 객체(item)를 저장한다.
* int search(Object o) : Stack에서 주어진 객체(o)를 찾아서 그 위치를 반환. 못찾으면 -1을 반환.  
  (배열과 달리 위치는 0이 아닌 1부터 시작(위에서부터 1))

[큐(Queue)의 메서드]
* boolean add(Object o) : 지정된 객체를 Queue에 추가한다. 성공하면 true를 반환.
  (저장공간이 부족하면 IllegalStateException 발생)
* Object remove() : Queue에서 객체를 꺼내 반환.  
  (비어있으면 NoSuchElementException 발생)
* Object element() : 삭제없이 요소를 읽어온다.
  (peek와 달리 Queue가 비었을 때 NoSuchElementException 발생)
* boolean offer(Object o) : Queue에 객체를 저장. 성공하면 true, 실패하면 false를 반환
* Object poll() : Queue에서 객체를 꺼내서 반환. 비어있으면 null을 반환
* Object peek() : 삭제없이 요소를 읽어 온다. Queue가 비어있으면 null을 반환


