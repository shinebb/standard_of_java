Math 클래스
===============

* 수학관련 static 메서드의 집합


복습!
* round()로 원하는 소수점 아래 세 번 째 자리에서 반올림하기


1. 원래 값에 100을 곱한다.
2. 위의 결과에 Math.round()를 사용한다.
3. 위의 결과를 다시 100.0으로 나눈다.

    
    1. 90.7552 * 100 -> 9075.52
    2. Math.round(9075.52) -> 9076
    3. 9076 / 100.0 -> 90.76   (9076/100 int로 나누면 90나옴 -> 소수점이하의 결과를 얻고싶다면 double로 나눌 것)


Math 클래스의 메서드
----------
*****

* static double abs(double a)
* static float  abs(float f)
* static int    abs(int f)
* static long   abs(long f) : 주어진 값의 절대값을 반환한다.


    int i = Math.abs(-10); //10
    double d = Math.abs(-10.0); //10.0


* static double ceil(double a) : 주어진 값을 올림하여 반환한다.


    double d = Math.ceil(10.1); //11.0
    double d2 = Math.ceil(-10.1); //-10.0
    double d3 = Math.ceil(10.000015); //11.0


* static double floor(double a) : 주어진 값을 버림하여 반환한다.


    double d = Math.ceil(10.8); //10.0
    double d2 = Math.ceil(-10.8); //-11.0


* static double max(double a, double b)
* static float  max(float a, float b)
* static int    max(int a, int b)
* static long   max(long a, long b) : 주어진 두 값을 비교하여 큰 쪽을 반환한다.


    double d = Math.max(9.5, 9.50001); //9.50001
    int i = Math.max(0, -1); //0


* static double min(double a, double b)
* static float  min(float a, float b)
* static int    min(int a, int b)
* static long   min(long a, long b) : 주어진 두 값을 비교하여 작은 쪽을 반환한다.


    double d = Math.min(9.5, 9.50001); //9.5
    int i = Math.min(0, -1); //-1


* static double random() : 0.0~1.0범위의 임의의 double 값을 반환한다.(1.0은 범위에 포함되지 않는다.)


    double d = Math.random(); //0.0<=d<1.0
    int i = (int)(Math.random()*10)+1 // 1<=i<11


* static double rint(double a) : 주어진 double 값과 가장 가까운 정수값을 double 형으로 반환한다.  
    단 두 정수의 정가운데 있는 값(1.5, 2.5, 3.5 등)은 짝수를 반환.


    double d = Math.rint(1.2) //1.0
    double d2 = Math.rint(2.6) //3.0
    double d3 = Math.rint(3.5) //4.0
    double d4 = Math.rint(4.5) //4.0


* static long round(double a) / (float a) : 소수점 첫째자리에서 반올림한 정수값(long)을 반환한다.  
    두 정수의 정가운데 있는 값은 항상 큰 정수를 반환.(rint()의 결과와 비교)


    long l = Math.round(1.2); //1
    long d2 = Math.round(2.6) //3
    long d3 = Math.round(3.5) //4
    long d4 = Math.round(4.5) //5
    double d = 90.7552;
    double d2 = Math.round(d*100)/100.0; //90.76







