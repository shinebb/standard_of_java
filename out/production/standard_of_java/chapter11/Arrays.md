Arrays
==============

* 배열을 다루기 편리한 메서드(static) 제공


toString() - 배열의 출력
------------
*****


    static String toString(boolean[] a/int[] a/chr[] a 등) //[1,2,3,4,5]


copyOf(), copyOfRange() - 배열의 복사
-------
*****

    int[] arr = {0,1,2,3,4};
    int[] arr2 = Arrays.copyOf(arr, arr.length); //arr2=[0,1,2,3,4]
    int[] arr2 = Arrays.copyOf(arr, 3); //arr2=[0,1,2]
    int[] arr2 = Arrays.copyOf(arr, 7); //arr2=[0,1,2,3,4,0,0]
    int[] arr2 = Arrays.copyOfRange(arr, 2, 4); //arr2=[2,3]
    int[] arr2 = Arrays.copyOfRange(arr, 0, 7); //arr2=[0,1,2,3,4,0,0]


fill(), setAll() - 배열 채우기
--------
*****

    int[] arr = new int[5];
    Arrays.fill(arr, 0); //arr=[9,9,9,9,9]
    Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1); //arr=[1,5,2,1,1]
    //랜덤값 난수 1<=x<6


sort(), binarySearch()
---------------
*****

* binarySearch()는 정렬 된 배열에만 사용 가능하다.


    int[] arr={3,2,0,1,4};
    int idx = Arrays.binarySearch(arr,2); //idx=-5 - 잘못된 결과 - 이진탐색은 정렬된 배열에만 가능하다.
    
    Arrays.sort(arr); //binarySearch를 사용하려면 반드시 배열을 정렬해줘야한다.
    System.out.println(Arrays.toString(arr)); //[0,1,2,3,4]
    int idx = Arrays.binarySearch(arr,2); //idx=2 - 올바른 결과


deepToString() - 다차원 배열의 출력
---------
*****


    int[] arr = {0,1,2,3,4};
    int[][] arr2D = {{11,12}, {21,22}};
    
    System.out.println(Arrays.toString(arr)); // [0,1,2,3,4]
    System.out.println(Arrays.deepToString(arr2D)); // [[11,12], [21,22]]


deepEquals() - 다차원 배열의 비교
------------
*****


    String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
    String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};

    System.out.println(Arrays.equals(str2D, str2D2)); // false - 잘못된 결과
    System.out.println(Arrays.deepEquals(str2D, str2D2)); //true
    

asList(Object... a) - 배열을 List로 변환
--------
*****

    
    List list = Arrays.asList(new Integer[]{1,2,3,4,5}); //list = [1,2,3,4,5]
    List list = Arrays.asList(1,2,3,4,5); //list = [1,2,3,4,5]
    list.add(6);  //UnsupportedOperationException 예외 발생 -> 지원하지 않는 기능(List는 읽기 전용이다.)

    List list = new ArrayList(Arrays.asList(1,2,3,4,5)); //새로운 ArrayList 생성하면 변경 가능

