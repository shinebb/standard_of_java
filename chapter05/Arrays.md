Arrays 클래스로 배열 다루기
=========================


배열의 비교와 출력 - equals(), toString()
---------
*****

Math클래스 : 수학관련 메서드 모아놓음  
(ex.round() : 반올림, random() : 난수)

"Arrays클래스 : 배열을 다루는데 유용한 메서드를 모아놓음"

1. toString(),  deepToString()
: 
int[] arr = {0,1,2,3,4};  
int[][] arr2D = {{11,12}, {21,22}};  
System.out.pringln(Arrays.toString(arr)); //[0, 1, 2, 3, 4]  -> 1차원
System.out.pringln(Arrays.deepToString(arr2D)); //[[11,12], [21,22]]  -> 2차원, 다차원

2. equals(), deepEquals()
: 
String[][] str2D = {{"aaa","bbb"},{"AAA","BBB"}};  
String[][] str2D2 = {{"aaa","bbb"},{"AAA","BBB"}};  
   System.out.println(Arrays.equals(str2D, str2D2)); //false -> 1차원 비교이기때문에
   System.out.println(Arrays.deepEquals(str2D, str2D2)); //true



배열의 복사 - copyOf(), copyOfRange()
----------------
*****

1. Arrays.copyOf(복사할배열, 복사할요소의갯수)
: int[] arr = {0,1,2,3,4};    
int[] arr2 = Arrays.copyOf(arr, arr.length); //arr2=[0,1,2,3,4]  
int[] arr3 = Arrays.copyOf(arr, 3); //arr3=[0,1,2]  
int[] arr4 = Arrays.copyOf(arr, 7); //arr3=[0,1,2,3,4,0,0]  

2. Array.copyOfRange(복사할배열, from, to); (to는 제외됨)
: int[] arr5 = Arrays.copyOfRange(arr, 2, 4); //arr5=[2,3] <-4는 불포함  
int[] arr6 = Arrays.copyOfRange(arr, 0, 7); //arr6=[0,1,2,3,4,0,0]  


배열의 정렬 - sort()
---------------------
*****

1. sort() - 오름차순
: 
int[] arr ={3, 2, 0, 1, 4};  
arrays.sort(arr);  //배열을 정렬한다.(오름차순)  
System.out.println(Arrays.toString(arr)); //[0, 1, 2, 3, 4]  


