hashCode()
===================

* 객체의 해시코드(hash code)를 반환하는 메서드
* Object 클래스의 hashCode()는 객체의 주소를 int를 변환해서 반환


    public class Object {
        ...
        public native int hashCode(); //네이티브 메서드:OS의 메서드(c언어)

* equals()를 오버라이딩하면, hashCode()도 오버라이딩해야 한다.  
=> equals()의 결과가 true인 두 객체의 해시코드는 같아야 하기 때문이다.


    String str1 = new String("abc");
    String str2 = new String("abc");
    System.out.println(str1.equals(str2)); //true
    System.out.println(str1.hashCode()); //96354
    System.out.println(str2.hashCode()); //96354

* System.identityHashCode(Object obj)(객체마다 다른 해시코드를 반환하는 메서드)는 Object 클래스의 hashCode()와 동일


    System.out.println(System.identityGashCode(str1)); //3526198
    System.out.println(System.identityGashCode(str2)); //7699183


toString(), toString()의 오버라이딩
===============

* toString(): 객체를 문자열(String)으로 변환하기 위한 메서드


    public String toString() { //Object 클래스의 toString()
        return getClass().getName()+"@"+Integer.toHexString(hashCode());
                //설계도객체.클래스이름.at(위치).16진수.객체주소
    }

=> 오버라이딩


    public String toString() {
        return "kind : " + kind + ", number : " + number; //이전 카드 예시
    }