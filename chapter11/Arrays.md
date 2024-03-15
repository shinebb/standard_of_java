Arrays
==============

* 배열을 다루기 편리한 메서드(static) 제공


toString() - 배열의 출력
------------
*****

* static String toString(boolean[] a/int[] a/chr[] a 등)


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

    int[] arr={3,2,0,1,4};
    int idx = Arrays.binarySearch(arr,2); //idx=-5 - 잘못된 결과 - 이진탐색은 정렬된 배열에만 가능하다.
    
    Arrays.sort(arr); //binarySearch를 사용하려면 반드시 배열을 정렬해줘야한다.
    System.out.println(Arrays.toString(arr)); //[0,1,2,3,4]
    int idx = Arrays.binarySearch(arr,2); //idx=2 - 올바른 결과



    