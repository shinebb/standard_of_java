프로그램 오류
=========================


* 컴파일 에러(compile-time error) : 컴파일 할 때 발생하는 에러
* 런타임 에러(runtime error) : 실행 할 때 발생하는 에러
* 논리적 에러(logical error) : 작성 의도와 다르게 동작  


컴파일에러와 런타임에러는 프로그램이 종료 되지만 논리적 에러는 종료되지 않는다.


예제
---------
*****

    public class ExceptionTest {
        public static void main(String[] args) {
            system.out.println(args[0]); //s 소문자로 컴파일 에러(javac.exe)
            
            System.out.println(args[0]); //수정 후 런타임 에러 발생
            /* Exception int thread "main" java.lang.ArrayIndexOutOfBoundsException 
               : 매개변수로 넘어온 값이 없는데 사용하려고해서 에러 발생 */
        }
    }


javac.exe 자바컴파일러
---------
*****

1. 구문체크
2. 번역체크
3. 최적화


java의 런타임 에러
-----
*****

* 에러(error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류 (ex.OutOfMemoryError)
* 예외(exception) : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류 (실행 중 발생 에러)

-> 에러(error)는 어쩔 수 없지만, 예외(exception)는 처리하자.  


예외처리(exception handling)의 정의와 목적
-----
*****

* 정의 : 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는것
* 목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것


Exception 과 RuntimeException
------
*****

* Exception클래스(+자손)들 : 사용자의 실수과 같은 외적인 요인에 의해 발생하는 예외(ex. IOException 입출력예외 / ClassNotFound 클래스 존재X)
* RuntimeException클래스(+자손)들 : 프로그래머의 실수로 발생하는 예외(ex.Arithmetic 산술계산예외 / ClassCast 형변환 / NullPointer 널포인터 / IndexOutOfBounds 배열 범위 벗어남)



예외 처리하기. try-catch문
------
*****


    try {
        // 예외가 발생할 가능성이 있는 문장들을 넣는다.
    } catch(Exception1 e1) {
        // Exception1이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
    } catch(Exception2 e2) {
        // Exception2이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
    } catch(ExceptionN eN) {
        // ExceptionN이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
    }


* try 블럭 내에서 예외가 발생한 경우
  1. 발생한 예외와 일치하는 catch 블럭이 있는지 확인한다.
  2. 일치하는 catch 블럭을 찾게 되면, 그 catch 블럭 내의 문장들을 수행하고 전체 try-catch 문을 빠져나가서
  그 다음 문장을 계속해서 수행한다. 만일 일치하는 catch 블럭을 찾기 뭇하면, 예외는 처리되지 못한다.


* try 블럭 내에서 예외가 발생하지 않은 경우.
  1. catch 블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.
  


printStackTrace()와 getMessage()
---------
*****

* printStackTrace() : 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
* getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.


멀티 catch 블럭
--------------
*****

* 내용이 같은 catch 블럭을 하나로 합친 것


    try {
      ...
    } catch (ExceptionA | ExceptionB e) { //부모 자식관계면 안됨.(부모 예외로 해결되기때문에)
        e.methodA(); //#에러# ExceptionA에 선언된 methodA()는 호출불가

        //사용하려면
        if(e instaceof ExceptionA) {
            ExceptionA e1 = (ExceptionA)e; //형변환
            e1.methodA(); //Ok.
        }else{
          ...
        }
        e.printStackTrace();
    }



예외 발생시키기
----------
*****

1. 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음
: exception e = new Exception("고의로 발생시켰음");

2. 키워드 throw를 이용해서 예외를 발생시킨다.
: throw e;

<br>

    try {
        exception e = new Excepiotn("고의로 발생시켰음."); //객체 생성
        throw e; //예외 발생시킴
        //throw new Exception("고의로 발생시켰음."); //위의 두 줄을 한 줄로 줄여 쓸 수 있다.
    
    } catch (Exception e) { //일치
        System.out.println("에러 메시지 : " + e.getMessage());
        e.printStackTrace();
    }
    System.out.println("프로그램이 정상 종료되었음.");
        


예외 종류 : checked 예외, unchecked 예외
-----------
*****

* checked 예외 : 컴파일러가 예외 처리 여부를 체크(예외 처리 필수)(Exception과 자손)
* unchecked 예외 : 컴파일라가 예외 처리 여부를 체크 안함(예외 처리 선택)(RuntimeException과 자손)


    public static void main(String[] args) {
        throw new Exception();
    }
    // => 컴파일에러 발생. 예외 처리 필수.

    public static void main(String[] args) {
        thorw new RuntimeException(); 
    }
    // => try-catch문 없어도 컴파일 OK. 그러나 명확한 RuntimeException이기 때문에 에러 발생. 예외 처리 선택.
    //두 구문 다 비정상 프로그램 종료.




메서드에 예외 선언하기
----------
*****

* 예외를 처리하는 방법 : try-catch문, 예외 선언하기
* 메서드가 호출시 발생가능한 예외를 호출하는 쪽에 알리는 것
* 예외를 발생시키는 키워드 throw와 예외를 메서드에 선선할 때 쓰이는 throws와 잘 구별하다.


    void method() throws Exceoption1, Exceoption2, ... ExceoptionN {
      //메서드 내용
    }

    //method()에서 Exception과 그 자손 예외 발생 가능
    void method() throw Exception { //모든 종류의 예외가 발생 가능
      //메서드 내용
    }


참고. 오버라이딩 조건
1. 선언부 일치
2. 접근제어자 좁게 X
3. 조상보다 많은 예외 선언 X


    static void startInstall() throws SpaceException, MemoryException {
    /* startInstall() 메서드를 호출하면 SpaceException, MemoryException 가 발생할 수 있다는 것을 알려주는 것. 
       그래서 startInstall() 메서드를 호출해서 사용하는쪽에서는 이 exception들에 대한 try-catch문이 필요하다.*/
      if(!enoughSpace())  // 충분한 설치 공간이 없으며 예외를 발생시켜서 자신을 호출한 메서드에게 알려주는 것
        throw new SpaceException("설치할 공간이 부족합니다.");
      if(!enoughMemory())
        throw new MemoryException("메모리가 부족합니다.");
    }


finally 블럭
---
*****

* 예외 발생여부와 관계없이 수행되어야 하는 코드를 넣는다.


    try {
        //예외가 발생할 가능성이 있는 문장들을 넣는다.
    } catch (Exception1 e1) {
        //예외처리를 위한 문장을 적는다.
    } finally {
        //예외의 발생여부에 관계없이 항상 수행되어야하는 문장들을 넣는다.
        //finally블럭은 try-catch문의 맨 마지막에 위치해야한다.
    }

참고 : try블럭 안에 return문이 있어서 try블럭을 벗어날 때도 finally블럭이 실행된다.


    try {
        startInstall();
        copyFile();
        deleteTempFiles(); //임시파일삭제
    } catch(Exception e) {
        e.printStackTrace();
        deleteTempFiles(); //중복 : 에외가 발생하던 안하던 임시파일삭제는 이루어져야한다.
    }

=>

    try {
        startInstall();
        copyFile();
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        deleteTempFiles(); //코드 중복 제거
    }





