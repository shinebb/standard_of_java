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

