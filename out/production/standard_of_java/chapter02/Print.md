Print(출력)
=========================

형식화된 출력 - printf()
---------
*****

* println()의 단점 - 출력형식 지정불가
1. 실수의 자리수 조절불가 - 소수점 n자리만 출력하려면?  
System.out.println(10.0/3);  //3.3333333...
2. 10진수로만 출력된다. - 8진수, 16진수로 출력하려면?  
   System.out.println(0x1A);  //26 = 10진수

* printf()로 출력형식 지정가능  
  System.out.printf("%.2f", 10.0/3); //3.33 => 소수점둘째자리까지  
  System.out.printf("%d", 0x1A);  //26 => 10진수  
  System.out.printf("%x", 0x1A);  //1A => 1A  


printf()의 지시자("")
---------------
*****

* %b = 불리언(boolean) 형식으로 출력
* %d = 10진(decimal) 정수의 형식으로 출력
* %o = 8진(octal) 정수의 형식으로 출력
* %x, %X = 16진(hexa-decimal) 정수의 형식으로 출력
* %f = 부동 소수점(floating-point)의 형식으로 출력
* %e, %E = 지수(exponent) 표현식의 형식으로 출력
* %c = 문자(character)로 출력
* %s = 문자열(string)로 출력  

System.out.printf("age:%d year:%d\n", 14, 2017); //age:14 yaer:2017  
\n or %n : 줄바꿈 (가능하면 %n으로 사용할것(OS구분없음))  

1. 정수를 10진수, 8진수, 16진수로 출력  
   System.out.printf("%d", 15); //15  =10진수  
   System.out.printf("%o", 15); //17  =8진수  
   System.out.printf("%x", 15); //f   =16진수  
   System.out.printf("%s", Integer.toBinaryString(15));  //1111  =2진수   
<br>
2. 8진수와 16진수에 접두사 붙이기
   System.out.printf("%#o", 15); //017
   System.out.printf("%#x", 15); //0xf
   System.out.printf("%#X", 15); //0XF  
<br>  
3. 실수 출력을 위한 지시자 %f - 지수형식(%e), 간략한 형식(%g)  
   float f = 123.456789f;  
   System.out.printf("%f", f); //123.456787  =소수점 아래 6자리/정밀도 7자리로 마지막 두자리는 의미x, 그래서 정밀도가 더 높은 double을 쓰는것이 좋음  
   System.out.printf("%e", f); //1.234568e+02  =지수형식(e+02 = 10의 2승)(마지막 반올림)  
   System.out.printf("%g", 123.456789); //123.457  =간략한 형식(소수점포함 7자리/마지막 반올림)  
   System.out.printf("%g", 0.00000001); //1.00000e-8  =간략한 형식(지수형태로 나타내는게 더 간략하게 판단되면 지수형태로 나타냄)    


System.out.printf("[%5d]", 10);  //[   10] => 5자리까지 출력
System.out.printf("[%-5d]", 10);  //[10   ] => 5자리까지 출력(-왼쪽정렬)
System.out.printf("[%05d]", 10);  //[00010] => 빈자리 0으로 채움

System.out.printf("d=%14.10f%n", d);  //[전체 14자리 중 소수점 아래 10자리

System.out.printf("[%s]%n", url); 
