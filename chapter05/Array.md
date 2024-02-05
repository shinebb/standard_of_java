배열
=========================


배열이란?
---------
*****

"배열은 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것"    

    int score1, score2, score3, score4, score5  
=>  

    int[] score = new int[5]

    [score] -> [0][1][2][3][4] (index)


배열의 선언과 생성
----------------
*****
"배열의 선언 - 배열을 다루기 위한 참조변수의 선언"  

* 선언방법

1. 타입[] 변수이름;  


    int[] score;  
    String[] name;  

2. 타입 변수이름[];  


    int score[];  
    String name [];  

타입[] 변수이름;  //배열을 선언(배열을 다루기 위한 참조변수 선언)    
변수이름 = new 타입[길이];  //배열을 생성(실제 저장공간을 생성)  


    int[] score;  //int타입의 배열을 다루기 위한 참조변수 score 선언  
    score = new int[5];  //int타입의 값 5개를 저장할 수 있는 배열 생성  

    score(참조변수) // => (2)socre[0], socre[1], socre[2], socre[3], socre[4] (저장공간 5개)  
    // = 참조변수에는 그 저장공간의 주소값이 저장된다.  


배열의 인덱스
----------------
*****
"배열의 인덱스 - 각 요소(저장공간)에 자동으로 붙는 (일련)번호"  
"인덱스(index)의 범위는 0부터 '배열길이-1'까지이다."  


배열의 길이
----------------
*****
"배열이름.length - 배열의 길이(int형 상수)"  

    int[] arr = new int[5]; //길이가 5인 int 배열  
    int tmp = arr.length;  //arr.length의 값은 5이고 tmp에 5가 저장된다.  

"배열은 한 번 생성하면 실행 동안 그 길이를 바꿀 수 없다."  
1. why? 왜 못바꿀까?  
배열은 연속적인 메모리가 필요하므로 공간이 부족하면 추가시킬 수 없다.    
2. 그렇다면 부조할 때 어떻게 해야하는가?  
부족하면 새로운 배열은 만들어서 기존 배열값을 복붙해서 사용해야한다.  


배열의 초기화
----------------------
*****
"배열의 각 요소에 처음으로 값을 저장하는 것"
    
    int[] score = new int[5];  //길이가 5인 int형 배열을 생성
    //int=0 자동초기화  

    score[0] = 50; //각 요소에 직접 값을 저장 -> 이것 또한 초기화  
    score[1] = 60;  
    score[2] = 70;  
    score[3] = 80;  
    score[4] = 90;  

    => 
    int[] score = {50, 60, 70, 80, 90};  
    (int[] score;
    score = {50, 60, 70, 80, 90};) 
    //-> 두 줄로 나누면 error가 날 수 있으므로 위 방법으로 사용할 것.)


배열의 출력
-----------------------
*****

    int[] iArr = {100, 95, 80, 70, 60};  

    //배열을 가리키는 참조변수 iArr의 값을 출력한다.  
    System.out.println(iArr); //[I@14318bb와 값은 형식의 문자열 출력된다. (주소값)  
    //(char[] 일 때에만 저장된 문자 출력)  

    for(int i=0; i<iArr.length; i++){  
        System.out.println(iArr[i]);  
    }

or

    //배열 iArr의 모든 요소를 출력한다. [100, 95, 80, 70, 60] 이 출력 된다.
    System.out.println(Array.toString(iArr));


String 배열의 선언과 생성
-----------------------
*****

    String[] name = new String[3]; //3개의 문자열을 담을 수 있는 배열을 생성한다.  
    //(참조형 기본값 = null)  

    name[0] = "Kim";  
    name[1] = "Park";  
    name[2] = "Yi";  
    or  
    String[] name = {"Kim", "Park", "Yi"};  



커맨드 라인을 통해 입력받기
----------------
*****
"커맨드 라인에 입력한 값이 문자열 배열에 담겨서 전달된다."
 
intelliJ 커맨드창 사용법    
> Edit Configurations > Application 추가  
> Main Class 에 패키지.클래스 네임 입력(chapter05.Ex_commend)  
> 아래 Program arguments에 원하는 값 입력


*****Window 커맨트창 사용법  
기존방법 :  
> 해당 클래스 폴더 위치 확인(.java가 아닌 .class파일)(D:\devMusign\standard_of_java\out\production\standard_of_java\chapter05) 복사  
> Window cmd 창 오픈 > cd 경로 (해당경로 이동) > java Ex_commend abc 1234 "Hello" 입력하면 실행됨

본인 방법 :
> 해당 클래스 폴더 위치 확인(.java가 아닌 .class파일)(D:\devMusign\standard_of_java\out\production\standard_of_java) 복사  
> (chapter05 패키지를 포함한 이전 경로에서 실행 가능)   
> D드라이브로 이동이 안돼서 "cd /d D:\" 로 다른 드라이브 이동후 다시 D드라이브 이동    
> Window cmd 창 오픈 > cd 경로 (해당경로 이동) > java chapter05.Ex_commend abc 1234 "Hello" 패키지명까지 입력하면 실행됨.


2차원 배열
--------------
*****
"테이블 형태의 데이터를 저장하기 위한 배열"  

int[][] score = new int[4][3]; //4행 3열의 2차원 배열을 생성한다. int값 12개 = 저장공간 12개

열 index(0 ~ 열의길이-1)
행 index(0 ~ 행의길이-1)

score[0][0] score[0][1] score[0][2]  
score[1][0] score[1][1] score[1][2]  
score[2][0] score[2][1] score[2][2]  
score[3][0] score[3][1] score[3][2]  

score[0][0] = 100;  //배열 score의 1행 1열에 100을 저장  
System.out.println(score[0][0]);  //배열 score의 1행 1열의 값을 출력 -> 100  


2차원 배열의 초기화
---------------
*****

    int[][] arr = {{1,2,3}, {4,5,6}};   
    int[][] score = {
        {100, 100, 100} -> 이것 하나가 1차원 
        {20, 20, 20}
        {30, 30, 30}
        {40, 40, 40}  
    } 
=> 1차원 배열의 배열이라고도 표현한다.

score -> score[0] -> score[0][0] score[0][1] score[0][2] => 이것 한 줄 이 1차원배열 이름은 score[0]  
score -> score[1] -> score[1][0] score[1][1] score[1][2] => 이것 한 줄 이 1차원배열 이름은 score[1]  
score -> score[2] -> score[2][0] score[2][1] score[2][2] => 이것 한 줄 이 1차원배열 이름은 score[2]  
score -> score[3] -> score[3][0] score[3][1] score[3][2] => 이것 한 줄 이 1차원배열 이름은 score[3]  

score.length == 4  
score[0].length == 3
















