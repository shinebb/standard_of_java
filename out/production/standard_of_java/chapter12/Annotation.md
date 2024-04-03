어노테이션(Annotation)
====================

* 주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보를 제공

예시

    @Test //이 메서드가 테스트 대상임을 테스트 프로그램에게 알린다.
    public void method() {
        ...
    }


표준 어노테이션
--------------
*****

JAVA에서 제공하는 어노테이션

* @Override : 컬파일러에게 오버라이딩하는 메서드라는 것을 알린다.
* @Deprecated : 앞으로 사용하지 않을 것을 권장하는 대상에 붙인다.
* @SuppressWarnings : 컴파일러의 특정 경고메시지가 나타나지 않게 해준다.
* @SafeVarargs : 제네릭스 타입의 가변인자에 사용한다.
* @FunctionalInterface : 함수형 인터페이스라는 것을 알린다.
* @Native : native 메서드에서 참조되는 상수 앞에 붙인다. 
  
  
  
메타어노테이션 : 메타어노테이션을 만들 때 사용
* @Target* : 어노테이션이 적용가능한 대상을 지정하는데 사용한다.
* @Documented* : 어노테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다.
* @Inherited* : 어노테이션이 자손 클래스에 상속되도록 한다.
* @Retention* : 어노테이션이 유지되는 범위를 지정하는데 사용한다.
* @Repeatable* : 어노테이션을 반복해서 적용할 수 있게 한다.


@Override 
------------
*****

* 오버라이딩을 올바르게 했는지 컴파일러가 체크하게 한다.
* 오버라이딩할 때 메서드 이름을 잘못적는 실수를 하는 경우가 많다.
* 오바라이딩할 때는 메서드 선언부 앞에 @Override를 붙이자.


    class Parent {
        void parentMethod() { }
    }

    class Child extends Parent {
        void parentmethod() { } //오버라이딩 하려했으나 실수로 이름을 잘못적음.
        //그럼 오버라이딩되는 것이 아니라 그냥 새로운 메서드를 생성하게 된다.
    }

    ->

    class Child extends Parent {
        @Override 
        void parentmethod() { } //##에러## 오타로 인해 오버라이딩할 메서드가 없음을 알려줌
    }


@Deprecated
--------
*****

* 앞으로 사용하지 않을 것을 권장하는 필드나 메서드에 붙인다.
* @Deprecated 의 사용 예, Date 클래스의 getDate()


    @Deprecated
    public int getDate() {
        return normalize().getDatOfMonth();
    }


* @Deprecated 가 붙은 대상이 사용된 코드를 컴파일하면 
* 에러는 아니지만 안내 메시지가 로그에 찍힌다.


@FunctionalInterface
------------
*****

* 함수형 인터페이스에 붙이면, 컴파일러가 올바르게 작성했는지 체크
* 함수형 인터페이스에는 하나의 추상메서드만 가져야 한다는 제약이 있음


    @FunctionalInterface
    public interface Runnable {
        public abstract void run();  //추상 메서드
    }


@SuppressWarnings
----------
*****

* 컴파일러의 경고메시지가 나타나지 않게 억제한다.
* 괄호()안에 억제하고자하는 경고의 종류를 문자열로 지정


    @SuppressWarnings("unchecked") //제네릭스와 관련된 경고를 억제
    ArrayList list = new ArrayList(); //제네릭 타입을 지정하지 않았음.
    list.add(obj);                  //여기서 경고가 발생


* 둘 이상의 경고를 동시에 억제하려면 다음과 같이 한다.
    

    @SuppressWarnings("unchecked", "deprecation", "varargs")


* '-Xlint'옵션으로 컴파일하면, 경고메시지를 확인할 수 있다.
* 괄호[] 안이 경고의 종류, 아래의 경우 rawtypes