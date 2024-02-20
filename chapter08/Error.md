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








