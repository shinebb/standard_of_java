Generics(제네릭스)
==================

* 컴파일시 타입을 체크해 주는 기능(compile-time type check)
* 객체의 타입 안정성을 높이고, 형변환의 번거로움을 줄여줌


    //Tv 객체만 저할 수 있는 ArrayList를 생성
    ArrayList<Tv> tvList = new ArrayList<Tv>();

    tvList.add(new Tv()); //OK
    tvList.add( new Audio()); //컴파일 에러. Tv 외에 다른 타입은 저장 불가


제네릭스의 장점
----------
*****

* 타입 안정성을 제공한다.
* 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해 진다.


타입 변수
----------
*****

* 제네릭 클래스를 작성할 때, Object 타입 대신 타입 변수(E)를 선언해서 사용.


    public class ArrayList<E> extends AbstractList<E> { //일부 생략
        private transient E[] elementData;
        public boolean add(E o) { /* 내용생략 */ }
        public E get(int index) { /* 내용생략 */ }
    }


타입 변수에 대입하기
-------------
*****

* 객체 생성시, 타입 변수(E) 대신 실제 타입(Tv)을 지정(대입)
* 타입 변수 대신 실제 타입이 지정되면, 형변환 생략가능


    //타입 변수 E 대신에 실제 타입 Tv를 대입(참조변수와 객체에 붙여주며, 두 타입은 같아야한다.
    ArrayList<Tv> tvList = new ArrayList<Tv>();

    public class ArrayList<Tv> extends AbstractList<Tv> { //일부 생략
        private transient Tv[] elementData;
        public boolean add(Tv o) { /* 내용생략 */ }
        public Tv get(int index) { /* 내용생략 */ }
    }

