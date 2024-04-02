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


제네릭스의 제약
--------
*****

* 타입 변수에 대입은 인스턴스 별로 다르게 가능


    Box<Apple> appleBox = new Box<Apple>(); //OK. Apple 객체만 저장가능
    Box<Grape> grapeBox = new Box<Grape>(); //OK. Grape 객체만 저장가능


* static 멤버에 타입 변수 사용 불가(static은 모든 인스턴스에서 공통으로 쓸 수 있기 때문에)


    class Box<T> {
        static T item; //에러
        static int compare(T t1, T t2) { ... } //에러
        ...
    }


* 배열 생성할 때 타입 변수 사용불가. 타입 변수로 배열 선언은 가능


    class Box<T> {
        T[] itemArr; //OK. T타입의 배열을 위한 참조변수
            ...
        T[] toArray() {
            T[] tmpArr = new T[itemArr.length]; //에러. 제네릭 배열 생성 불가
            ... //new 다음에 'T'가 오면 안된다. new다음에는 확정 객체가 와야한다.
        }
    }


와일드 카드 <?>
----------
*****

* 하나의 참조 변수로 대입된 타입이 다른 객체를 참조 가능


    ArrayList<? extends Product> list = new ArrayList<Tv>(); //OK
    ArrayList<? extends Product> list = new ArrayList<Audio>(); //OK
    ArrayList<Product> list = new ArrayList<Tv>(); //##에러## 대입된 타입 불일치

    <? extends T> 와일드 카드의 상한 제한. T와 그 자손들만 가능
    <? super T>   와일드 카드의 하한 제한. T와 그 조상들만 가능
    <?>           제한 없음. 모든 타입이 가능. <? extends Object>와 동일


* 메서드의 매개변수에 와일드 카드를 사용


    static Juice makeJuice(FruitBox<? extends Fruit> box) {
        String tmp = "";
        for(Fruit f : box.getList()) tmp += f + " ";
        return new Juice(tmp);
    }


제네릭 메서드
------
*****

* 제네릭 타입이 선언된 메서드(타입 변수는 메서드 내에서만 유효)


    static <T> void sort(List<T> list, Comparator<? super T> c)


* 클래스의 타입 매개변수<T>와 메서드의 타입 매개변수 <T>는 별개


    class FruitBox<T> {
        ...
        static <T> void sort(List<T> list, Comparator<? super T> c) {
            ...
        }
    }


* 메서드를 호출할 때마다 타입을 대입해야(대부분 생략 가능)


    FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
    FruitBox<Apple> fruitBox = new FruitBox<Apple>();
        ...
    System.out.println(Juicer.<Fruit>makeJuice(fruitBox));
    System.out.println(Juicer.<Apple>makeJuice(appleBox));


    static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
        String tmp = "";
        for(Fruit f : box.getList()) tmp += f + " ";
        return new Juice(tmp);
    }


* 메서드를 호출할 때 타입을 생략하지 않을 때는 클래스 이름 생략 불가


    System.out.println(<Fruit>makeJuice(fruitBox)); //##에러## 클래스 이름 생략불가
    System.out.println(this.<Fruit>makeJuice(fruitBox));   //OK
    System.out.println(Juicer.<Fruit>makeJuice(fruitBox)); //OK


제네릭 타입의 형변환
--------
*****

* 제네릭 타입과 원시 타입 간의 형변환은 바람직 하지 않다. (경고 발생)


    Box<Object> objBox = null;
    Box box = (Box)objBox;     //Ok. 제네릭 타입 -> 원시타입. 경고 발생
    objBox = (Box<Object>)box; //Ok. 원시 타입 -> 제네릭타입. 경고 발생

    objBox = (Box<Object>)strBox; //##에러## Box<String> -> Box<Object>
    strBox = (Box<String>)strBox; //##에러## Box<Object> -> Box<String>


* 와일드 카드가 사용된 제네릭 타입으로는 형변환 가능


    Box<Object>  objBox = (Box<object>)new Box<String>(); //##에러## 형변환 분가능
    Box<? extends Object> wBox = (Box<? extends Object>)new Box<String>(); //OK
    Box<? extends Object> wBox = new Box<String>(); //OK. 위문장에서 형변환 코드 생략 가능

    //매개변수로 FruitBox<Fruit>, FruitBox<Apple>, FruitBox<Grape> 등이 가능
    static Juice makeJuice(FruitBox<? entends Fruit> box) {...}

    FruitBox<? extends Fruit> box = new FruitBox<Fruit>(); //OK
    FruitBox<? extends Fruit> box = new FruitBox<Apple>(); //OK


제네릭 타입의 제거
---------
*****

* 컴파일러는 제네릭 타입을 제거하고, 필요한 곳에 형변환을 넣는다.
1. 제네릭 타입의 경계(bound)를 제거 -> 하위호환성 때문에
2. 제네릭 타입 제거 후에 타입이 불일치하면, 형변환을 추가
3. 와일드 카드가 포함된 경우, 적절한 타입으로 형변환 추가


열거형(enum)
===============================

열거형(enum)
--------------
*****

* 관련된 상수들을 같이 묶어 놓은 것. Java는 타입에 안전한 열거형을 제공


    class Card { 
        enum Kind { CLOVER, HEART, DIAMOND, SPADE } //열거형 Kind를 정의 //0,1,2,3
        enum Value { TWO, THREE, FOUR }             //열거형 Value를 정의

        final Kind kind; //타입이 int가 아닌 Kind임에 유의하자.
        final Value value; 
    }


* Java의 열거형은 값과 타입을 모두 체크한다.


    if(Card.Kind.CLOVER == Card.Value.TWO) { //##컴파일 에러## 타입이 달라서 비교 불가.


열거형의 정의와 사용
-------
*****

* 열거형을 정의하는 방법
  

    enum 열거형이름 { 상수명1, 상수명2, ... }
    
    enum Direction { EAST, SOUTH, WEST, NORTH }


* 열거형 타입의 변수를 선언하고 사용하는 방법


    class Unit {
        int x, y; //유닛의 위치
        Direction dir; //열거형 인스턴스 변수를 선언

        void init() { 
            dir = Direction.EAST; //유닛의 방향을 EAST로초기화
        }
    }


* 열거형 상수의 비교에 ==와 compareTo() 사용가능

    
    if(dir==Direction.EAST) {  //true
        x++;
    } else if(dir > Direction.WEST) { //##에러## 열거형 상수에 비교연산자 사용불가
        ...
    } else of(dir.compareTo(Direction.WEST) > 0 ) { //compareTo()는 가능
        
    //CompareTo() : 왼쪽크면 양수 / 같으면 0 / 오른쪽이 크면 음수


열거형의 조상 - java.lang.Enum
----------
*****

모든 열거형은 Enum의 자손이며, 아래의 메서드를 상속받는다.

* Class<E> getDeclaringClass() : 열거형의 Class객체를 반환
* String name() : 열거형 상수의 이름을 문자열로 반환
* int ordinal() : 열거형 상수가 정의된 순서를 반환(0부터 시작)
* T valueOf(Class<T> enumType, String name) : 지정된 열거형에서 name과 일치하는 열거형 상수를 반환

values(), valueOf()는 컴파일러가 자동으로 추가


    static E[] values()
    static E valueOf(String name)

    Direction[] dArr = Direction.values();
    //Direction d = Direction.valueOf("WEST");

    for(Direction d : dArr) 
        System.out.printf("%s=%d%n", d.name(), d.ordinal());


열거형에 멤버 추가하기
-------------
*****

* 불연속적인 열거형 상수의 경우, 원하는 값을 괄호()안에 적는다.


    enum Direction { EAST(1), SOUTH(5), WEST(-1), NORTH(10) }


* 괄호()를 사용하려면, 인스턴스 변수와 생성자를 새로 추가해 줘야한다.


    enum Direction {
        EAST(1), SOUTH(5), WEST(-1), NORTH(10); //끝에 ';'를 추가해야 한다.
        
        //값을 저장할 iv 변수를 선언 및 생성자를 정의해줘야 값을 저장할 수 있다.
        private final int value; //정수를 저장할 필드(인스턴스 변수)를 추가
        Direction(int value) { this.value = value; } //생성자를 추가
        //생성자는 항시적으로 private 이므로, 생략되어있음
        
        public int getValue() { return value; }
    }


* 열거형의 생성자는 묵시적으로 private 이므로, 외부에서 객체생성 불가


    Direction d = new Direction(1); //##에러## 열거형의 생성자는 외부에서 호출불가





    