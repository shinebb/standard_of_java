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


제네릭스 용어
----------
*****

* Box<T> : 제네릭 클래스. 'T의 Box' 또는 'T Box' 라고 읽는다.
* T : 타입 변수 또는 타입 매개변수. (T는 타입 문자)
* Box : 원시 타입(raw type)


제네릭 타입과 다형성
-----------
*****

* 참조 변수와 생성자의 대입된 타입은 일치해야 한다.


    ArrayList<Tv>      list = new ArrayList<Tv>();  //OK. 일치
    ArrayList<Product> list = new ArrayList<Tv>();  //##에러## 불일치


* 제레닉 클래스간의 다형성은 성립.(여전히 대입된 타입은 일치해야)


    List<Tv> list = new ArrayList<Tv>(); //OK. 다형성. ArrayList가 List를 구현
    List<Tv> list = new LinkedList<Tv>(); //OK. 다형성. LinkedList가 List를 구현


* 매개변수의 다형성도 성립.


    ArrayList<Product> list = new ArrayList<Product>();
    list.add(new Product());
    list.add(new Tv());     //Product의 자손도 OK
    list.add(new Audio());  //Product의 자손도 OK


Iterator<E>
--------------
*****

* 클래스를 작성할 때, Object 타입 대신 T와 같은 타입 변수를 사용


    public interface Iterator<E> {
        boolean hasNext();
        E next();
        void remove();
    }


    Iterator<Student> it = list.iterator();
    while(it.hasNext()) {
        Student s = it.next(); //형변환 필요X
        ...
    }


HashMap<K,V>
--------
*****

* 여러 개의 타입 변수가 필요한 경우, 콤마(,)를 구분자로 선언


    HashMap<String, Student> map = new HashMap<String, Student>();
    map.put("자바왕", new Student("자바왕", 1,1); //데이터 저장


    public class HashMap<K,V> entends AbstractMap<K,V> { //일부 생략
        public V get(Object key) { /* 내용 생략 */ }
        public V put(K key, V value) { /* 내용 생략 */ }
        public V remove(Obejct key) { /* 내용 생략 */ }
            ...
    }

    ->

    public class HashMap<K,V> entends AbstractMap<K,V> { //일부 생략
        public Student get(Object key) { /* 내용 생략 */ }
        public Student put(String key, Student value) { /* 내용 생략 */ }
        public Student remove(Obejct key) { /* 내용 생략 */ }
            ...
    }


제한된 제네릭 클래스
---------
*****

* extends 로 대입할 수 있는 타입을 제한


    class FruitBox<T extends Fruit> { //Fruit(포함)의 자손만 타입으로 지정가능
        ArrayList<T> list = new ArrayList<T>();
        ...
    }

    FruitBox<Apple> appleBox = new FruitBox<Apple>(); //OK
    FruitBox<Toy> appleBox = new FruitBox<Toy>();     //에러. Toy는 Fruit의 자손이 아님


* 인터페이스인 경우에도 extends 를 사용


    interface Eatable {}
    class FruitBox<T extends Detable> {...}










