스트림
======================

* 다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것

----------------

* List<Integer> list = Arrays.asList(1,2,3,4,5);
* Stream<Integer> intStream = list.stream(); //컬렉션
* Stream<String> strStream = Stream.of(new String[] {"a","b","c"}); //배열
* Stream<Integer> evenStream = Stream.iterate(0, n->n+2); //0, 2, 4, 6, ...
* Stream<Double> randomStream = Stream.generate(Math::random); //람다식
* IntStream intStream = new Random().ints(5); //난수 스트림(크기가 5)

 ----------------------

스트림이 제공하는 기능 - 중간 연산과 최종 연산
-------
*****

* 중간 연산 - 연산결과가 스트림인 연산. 반복적으로 적용가능
* 최종 연산 - 연산결과가 스트림이 아닌 연산. 단 한번만 적용가능(스트림의 요소를 소모)


    stream.distinct().limit(5).sorted().forEach(System.out::println)

[중간 연산]  
distinct() : 중복제거  
limit(5) : 5개 자르기  
sorted() : 정렬  

[최종 연산]  
forEach(System.out::println) : 출력


    String[] strArr = {"dd","aaa","CC","cc","b"};
    Stream<String> stream = Stream.of(strArr); //문자열 배열이 소스인 스트림
    Stream<String> filteredStream = stream.filter(); //걸러내기(중간 연산)
    Stream<String> distinctedStram = stream.distinct(); //중복제거(중간 연산)
    Stream<String> sortedStream = stream.sort(); //정렬(중간 연산)
    Stream<String> limitedStream = stream.limit(5); //스트림 자르기(중간 연산)
    int total = stream.count(); //요소 개수 세기(최종연산)


스트림(Stream)의 특징
------------
*****

* 스트림은 데이터 소스로부터 데이터를 읽기만할 뿐 변경하지 않는다.


    List<Integer> list = Arrays.asList(3,1,5,4,2);
    List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
    //list를 정렬해서 새로운 List에 저장

    System.out.println(list);       //[3,1,5,4,2]
    System.out.println(sortedList); //[1,2,3,4,5]


* 스트림은 Iterator 처럼 일회용이다.(필요하면 다시 스트림을 생성해야 함)


    strStream.forEach(System.out::println); //모든 요소를 화면에 출력(최종연산)
    int numOfStr = strStream.count();       //에러. 스트림이 이미 닫혔음.


* 최종 연산 전까지 중간연산이 수행되지 않는다. - 지연된 연산


    IntStream intStream = new Random().ints(1,46); //1~45 범위의 무한 스트림
    intStream.distinct().limit(6).sorted()         //중간연산
            .forEach(i->System.out.print(i+","));  //최종연산
    //코드는 말이 안되나, 지연된 연산을 처리하기 때문에 가능하다.


* 스트림은 작업을 내부 반복으로 처리한다.


    for(String str : strList) {
        System.out.println(str);
    }
->

    stream.forEach(System.out::println);


* 스트림의 작업을 병렬로 처리 - 병렬스트림


    Stream<String> strStream = Stream.of("dd","aaa","CC","cc","b");
    int sum = str.Stream.parallel() //병렬스트림으로 전환(속석만 변경)
                        .mapToInt(s -> s.length()).sum(); //모든 문자열의 길이의 합


* 기본형 스트림 - IntStream, LongStream, DoubleStream
  * 오토박싱&언박싱의 비효율이 제거됨(Stream<Integer> 대신 IntStream 사용)
  * 숫자와 관련된 유용한 메서드를 Stream<T>보다 더 많이 제공


스트림 만들기 - 컬렉션
==========================

* Collection 인터페이스의 stream()으로 컬렉션을 스트림으로 변환


    Stream<E> stream() //Collection 인터페이스의 메서드

    
    List<Integer> list = Arrays.asList(1,2,3,4,5);
    Stream<Integer> intStream = list.stream(); //list를 스트림으로 변환

    //스트림의 모든 요소를 출력
    intStream.forEach(System.out::print); //12345
    intStream.forEach(System.out::print); //에러. 스트림이 이미 닫혔다.
