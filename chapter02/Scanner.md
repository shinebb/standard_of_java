화면에서 입력받기 - Scanner
=========================

Scanner란?
---------
*****

* 화면으로부터 데이터를 입력받는 기능을 제공하는 클래스

Scanner를 사용하려면?
----------
*****

1. import문 추가  
* import java.util.*;

2. Scanner객체의 생성
* Scanner scanner = new Scanner(System.in);  ->화면입력

3. Scanner객체를 사용
* int num = scanner.nextInt();  //화면에서 입력받은 정수를 num에 저장
* nextFloat() //실수
* String input = scanner.nextLine();  //화면에서 입력받은 내용(줄 단위/한 행)을 input에 저장
* int num = Integer.parseInt(input);  //문자열(input)을 숫자(num)로 변환


오버플로우
---------
*****

* 오버플로우 : 표현가능한 범위를 넘는것  
최대값 +1 => 최소값(1111 => 0000)  
최소값 -1 => 최대값  

