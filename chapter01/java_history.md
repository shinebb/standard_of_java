자바의 특징과 JVM & JDK 설치
=========================

자바의 특징
---------
1. 배우기 쉬운 객체지향 언어
= 프로그래밍 언어 + 객체지향 개념(c++, java, python, js)
2. 자동 메모리 관리 (가비지컬렉터(GC))
3. 멀티 쓰레드 지원 (하나의 프로그램에서 동시에 여러작업을 할 수 있다.)
4. 풍부한 라이브러리로 쉽게 개발가능 (라이브러리 : 자주 쓰이는 주요한 기능을 미리 만들어 제공한다)
5. 운영체제에 독립적 (JVM)

자바 가상 머신(JVM)
----------------
- 자바 프로그램이 실행되는 가상 컴퓨터(VM)    
- 한번 작성하면, 어디서든 실행(Write once, run anywhere)

Java 애플리케이션 -> JVM(Windows/OSX/Linux) -> OS(Windows/OSX/Linux) -> 컴퓨터(하드웨어)


JDK 설치
-------
https://www.oracle.com

JDK(Java Development Kit) = JRE + 개발도구  
자바 프로그램을 개발하고 실행하기 위해 반드시 설치해야한다.

### 설치 후 환경변수편집(Path 설정)

내 pc -> 시스템속성 -> 고급시스템설정 -> 고급 -> 환경변수 -> Path 변수 -> 새 변수 생성    
변수이름 JAVA_HOME  
변수값 C:\Program Files\Java\jdk-11.0.12\bin; 추가   
cmd -> java -version 으로 자바 버전 확인
    

<img src="https://github.com/shinebb/standard_of_java/assets/94883716/589df907-11fd-4a7d-ae08-881245505dd6" width="60%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>


