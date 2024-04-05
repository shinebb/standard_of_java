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
* 에러는 아니지만 경고 메시지가 찍힌다.


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
                        //그러나 @SuppressWarnings로 경고 발생 안함


* 둘 이상의 경고를 동시에 억제하려면 다음과 같이 한다.
    

    @SuppressWarnings("unchecked", "deprecation", "varargs")


* '-Xlint'옵션으로 컴파일하면, 경고메시지를 확인할 수 있다.
* 괄호[] 안이 경고의 종류


메타어노테이션
=================

메타어노테이션
----------
*****

메타 어노테이션은 '어노테이션을 위한 어노테이션'
메타 어노테이션은 java.lang.annotation 패키지에 포함

* @Target : 어노테이션이 적용가능한 대상을 지정하는데 사용한다.
* @Documented : 어노테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다.
* @Inherited : 어노테이션이 자손 클래스에 상속되도록 한다.
* @Retention : 어노테이션이 유지되는 범위를 지정하는데 사용한다.
* @Repeatable : 어노테이션을 반복해서 적용할 수 있게 한다.


@Target
-------
*****

* 어노테이션을 정의할 때, 적용대상 지정에 사용


    @Target({TYPE, TIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SuppressWarningd {
        String[] value();
    }

* ANNOTATION_TYPE : 어노테이션
* CONSTRUCTOR : 생성자
* FIELD : 필드(멤버변수, enum 상수)
* LOCAL_VARIABLE : 지역 변수
* METHOD : 메서드
* PACKAGE : 패키지
* PARAMETER : 매개변수
* TYPE : 타입(클래스, 인터페이스, enum)
* TYPE_PARAMETER : 타입 매개변수
* TYPE_USE : 타입이 사용되는 모든 곳


    import static java.lang.annotaion.ElementType.*;

    @Target({FIELD, TYPE, TYPE_USE})   //적용대상이 FIELD, TYPE, TYPE_USE
    public @interface MyAnnotation { } //MyAnnotation을 정의

    @MyAnnotaion        //적용대상이 TYPE인 경우
    class MyClass {
        @MyAnnotation   //적용대상이 FIELD인 경우
        int i;

        @MyAnnotation   //적용대상이 TYPE_USE인 경우
        MyClass mc;
    }

@Retention
---------
*****

* 어노테이션이 유지(retention)되는 기간을 지정하는데 사용
  

* SOURCE : 소스 파일에만 존재. 클래스파일에는 존재하지 않음.
* CLASS : 클래스 파일에 존재. 실행시에 사용불가. 기본값
* RUNTIME : 클래스 파일에 존재. 실행시에 사용가능.


* 컴파일러에 의해 사용되는 어노테이션의 유지 정책은 SOURCE 이다.


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Override { }


* 실행시에 사용 가능한 어노테이션의 정책은 RUNTIME 이다.
    

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface FunctionalInterface { }
        

@Documented, @Inherited
----------
*****

* javadoc 으로 작성한 문서에 포함시키려면 @Documented 를 붙인다.


    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface FunctuinalInterface { }


* 어노테이션을 자손 클래스에 상속하고자 할 때, @Inherited 를 붙인다.


    @Inherited      //@SuperAnno가 자손까지 영향 미치게
    @interface SuperAnno { }

    @SuperAnno
    class Parent { }

    class Child extends Parent { }  //Child에 어노테이션이 붙은 것으로 인식


@Repeatable
--------
*****

* 반복해서 붙일 수 있는 어노테이션을 정의할 때 사용


    @Repeatable(ToDos.class)    //ToDo 어노테이션을 여러 번 반복해서 쓸 수 있게 한다.
    @interface ToDo {
        String value();
    }


* @Repeatable 이 붙은 어노테이션은 반복해서 붙일 수 있다.

    
    @ToDo("delete test codes.")
    @ToDo("override inherited methods")
    class MyClass {
        ...
    }


* @Repeatable 인 @ToDo 를 하나로 묶을 컨테이너 어노테이션도 정의해야 함.


    @interface ToDos { //여러 개의 ToDo 어노테이션을 담을 컨테이너 어노테이션 ToDosssssss
        ToDo[] value(); //ToDo 어노테이션 배열타입의 요소를 선언. 이름이 반드시 value 이어야 함.
    }


어노테이션 만들기
================

어노테이션 타입 정의하기
------------
*****

* 어노테이션을 직접 만들어 쓸 수 있다.


    @interface 어노테이션이름 { //'@'안붙이면 그냥 인터페이스가 되니 주의
        타입 요소이름();  //어노테이션의 요소를 선언한다.
        ...
    }


* 어노테이션의 메서드는 추상 메서드이며, 어노테이션을 적용할 때 지정(순서X)


    @interface DateTime {
        String yymmdd();
        String hhmmss();
    }


    @interface TestInfo {
        int count();
        String testedBy();
        String[]  testTools();
        TestType testType();  //enum TestType { FIRST, FINAL }
        DateTime testDate();  //자신이 아닌 다른 어노테이션(@DateTime)을 포함할 수 있다.
    }
    
    
    /* 만들어 놓은 어노테이션 사용 시 */
    @TestInfo( count=3, testedBy="kim", testTools={"Junit", "AutoTester"},
            testType=TestType.FIRST, testDat=@DateTime(yymmdd="160101", hhmmss="235959") )
    public class NewClss { ... }


어노테이션의 요소
-----------
*****

* 적용시 값을 지정하지 않으면, 사용될 수 있는 기본값 지정 가능(null제외)

    
    @interface TestInfo {
        int count() default 1; //기본값을 1로 지정
    }

    @TestInfo //TestInfo(count=1)과 동일
    public class NewClass { ... }


* 요소가 하나이고 이름이 value일 때는 요소의 이름 생략가능


    @interface TestInfo {
        String value(); //이름이 'value'일 때만 가능
    }

    @TestInfo("passed")  //@TestInfo(value="passed") 와 동일
    class NewClass { ... }


* 요소의 타입이 배열인 경우, 괄호{}를 사용해야 한다.
    
    
    @interface TestInfo {
        String[] testTools()
    }

    @TestInfo(testTools={"JUnit", "AutoTester"})
    @TestInfo(testTools="Junit") //하나일 때 생략가능
    @TestInfo(testTools={}) //값이 없을 때는 괄호{}가 반드시 필요


모든 어노테이션의 조상
----------------------
*****

* Annotation은 모든 어노테이션의 조상이지만 상속은 불가


    @interface TestInfo extends Annotation { //##에러## 허용되지 않는 표현
        int count();
        String testedBy();
    }


* 사실 Annotation은 인터페이스다.


    package java.lang.annotation;

    public interface Annotation { //Annotation 자신은 인터페이스이다.
        boolean equals(Object obj); //추상 메서드들
        int hashCode();
        String toString();
        //추상 메서드들은 구현할 필요는 X, but 사용가능

        Class<? extends Annotation> annotationType(); //어노테이션의 타입을 반환
    }

마커 어노테이션(Marker Annotation)
------------
*****

* 요소가 하나도 정의되지 않은 어노테이션

        
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Override {} //마커 어노테이션. 정의된 요소가 하나도 없다.


어노테이션 요소의 규칙
----------
*****

* 어노테이션의 요소를 선언할 때 아래의 규칙을 반드시 지켜야 한다.
  * 요소의 타입은 기본형, String, enum, 어노테이션, Class만 허용됨
  * 괄호()안에 매개변수를 선언할 수 없다.
  * 예외를 선언할 수 없다.
  * 요소를 타입 매개변수(제네릭 <T>같은)로 정의할 수 없다.

* 아래 코드에서 잘못된 부분은 무엇인지 생각해보자


    @interface AnnoTest {
        int id = 100; //상수OK. default메서드X
        String major(int i, int j);  //##에러## 매개변수허용 X
        String minor() throws Exception; //##에러## 예외선언 X
        ArrayList<T> list();  //##에러## 타입변수 정의 X
    }



