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
----------------
*****

* Collection 인터페이스의 stream()으로 컬렉션을 스트림으로 변환


    Stream<E> stream() //Collection 인터페이스의 메서드

    
    List<Integer> list = Arrays.asList(1,2,3,4,5);
    Stream<Integer> intStream = list.stream(); //list를 스트림으로 변환

    //스트림의 모든 요소를 출력
    intStream.forEach(System.out::print); //12345
    intStream.forEach(System.out::print); //에러. 스트림이 이미 닫혔다.


스트림 만들기 - 배열
--------------
*****

* 객체 배열로부터 스트림 생성하기


    Stream<T> Stream.of(T... values) //가변 인자
    Stream<T> Stream.of(T[])
    Stream<T> Arrays.stream(T[])
    Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive)

    Stream<String> str Stream = Stream.of("a","b","c"); //가변인자
    Stream<String> str Stream = Stream.of(new String[]{"a","b","c"});
    Stream<String> str Stream = Arrays.Stream(new String[]{"a","b","c"});
    Stream<String> str Stream = Arrays.Stream(new String[]{"a","b","c"},0,3);


* 기본형 배열로부터 스트림 생성하기

    
    IntStream InsStream.of(int... values)  //Stream이 아니라 IntStream
    IntStream InsStream.of(int[])  
    IntStream Arrays.Stream(int[])  
    IntStream Arrays.Stream(int[] array, int startInclusive, int endExclusive)  
    

스트림 만들기 - 임의의 수
----------------
************

* 난수를 요소로 갖는 스트림 생성하기


    IntStreamintStream = new Random().ints(); //무한 스트림
    intStream.limit(5).forEach(System.out::println); //5개의 요소만 출력한다.

    IntStream intStream = new Random().ints(5); //크기가 5인 난수 스트림을 반환

    Integer.MIN_VALUE <= ints() <= Integer.MAX_VALUE  //최소값과 최댓값 사이
    Long.MIN_VALUE <= longs() <= Long.MAX_VALUE
    0.0 <= doubles() <= 1.0


* 지정된 범위의 난수를 요소로 갖는 스트림을 생성하는 메서드(Random클래스)


    IntStream ints(int begin, int end)    //무한 스트림
    LongStream Longs(Long begin, Long end)   
    DoubleStream doubles(double begin, double end)    


    IntStream ints(long streamSize, int begin, int end)    //유한 스트림
    LongStream Longs(long streamSize, Long begin, Long end)   
    DoubleStream doubles(long streamSize, double begin, double end)    
    

스트림 만들기 - 특정 범위의 정수
-------
*****

* 특정 범위의 정수를 요소로 갖는 스트림 생성하기(IntStream, LongStream)


    IntStream IntStream.range(int begin, int end)       //end 미포함
    IntStream IntStream.rangeClosed(int begin, int end) //end 포함

    IntStream intStream = IntStream.range(1, 5); //1,2,3,4
    IntStream intStream = IntStream.rangeClosed(1, 5); //1,2,3,4,5


스트림 만들기 - 람다식 iterate(), generate()
-------
*****

* 람다식을 소스로 하는 스트림 생성하기


    static <T> Stream<T> iterate(T seed, UnaryOperator<T> f) //이전 요소에 종속적 , 무한스트림
    static <T> Stream<T> generate(Supplier<T> s) //이전 요소에 독립적


* iterate()는 이전 요소를 seed로 해서 다음 요소를 계산한다.


    Stream<Integer> evenStream = Stream.iterate(0, n->n+2); //0,2,4,6,... 무한스트림


* generate()는 seed를 사용하지 않는다.


    Straem<Double> randomStream = Stream.generate(Math::random);
    Stream<Integer> oneStream = Stream.generate(()->1);


스트림 만들기 - 파일과 빈 스트림
--------
*****

* 파일을 소스로 하는 스트림 만들기


    Stream<Path> Files.list(Path.dir)  //Path는 파일 또는 디렉토리


    Stream<String> Files.lines(Path path) //파일 내용을 라인 단위로 읽어서 Stream<String>으로 만든다.
    Stream<String> Files.lines(Path path, Charset cs)
    Stream<String> lines()  //BufferedReader 클래스의 메서드 
    

스트림의 연산
========================

스트림이 제공하는 기능 - 중간 연산과 최종 연산
--------
*****

* 중간 연산 - 연산결과가 스트림인 연산. 반복적으로 적용가능
* 최종 연산 - 연산결과가 스트림이 아닌 연산. 단 한번만 적용가능(스트림의 요소를 소모)


    stream.distinct().limit(5).sorted().forEach(System.out::println)
    //.distinct().limit(5).sorted() -> 중간연산
    //.forEach(System.out::println) -> 최종연산


    String[] strArr = {"dd","aaa","CC","cc","b"};
    Stream<String> stream = Stream.of(strArr); //문자열 배열이 소스인 스트림
    Stream<String> filteredStream = stream.filter(); //걸러내기(중간 연산)
    Stream<String> distinctedStram = stream.distinct(); //중복제거(중간 연산)
    Stream<String> sortedStream = stream.sort(); //정렬(중간 연산)
    Stream<String> limitedStream = stream.limit(5); //스트림 자르기(중간 연산)
    int total = stream.count(); //요소 개수 세기(최종연산)


스트림의 연산 - 중간 연산
------------
*****

* Stream<T> distinct() : 중복을 제거
* Stream<T> filter(Predicate<T> predicate) : 조건에 안 맞는 요소 제거
* Stream<T> limit(long maxSize) : 스트림의 일부를 잘라낸다.
* Stream<T> skip(long n) : 스트림의 일부를 건너뛴다.
* Stream<T> peek(Consumer<T> action) : 스트림의 요소에 작업수행
* Stream<T> sorted(), sorted(Comparator<T> comparator) : 스트림의 요소를 정렬한다.


* 스트림의 요소를 변환한다.
* Stream<R> map(Function<T,R> mapper)
* DoubleStream mapToDouble(ToDoubleFunction<T> mapper)
* IntStream mapToInt(ToIntFunction<T> mapper)
* LongStream mapToLong(ToLongFunction<T> mapper)

* Stream<R> flatMap(Function<T,Stream<R>> mapper)
* DoubleStream flatMapToDouble(Function<T,DoubleStream> m)
* IntStream flatMapToInt(Function<T,intStream> m)
* LongStream flatMapLong(Function<T,LongStream> m) 


스트림의 연산 - 최종 연산
---------
*****

* void forEach(Consumer<? super T> action) : 각 요소에 지정된 작업 수행
* void forEachOrdered(Consumer<? super T> action) : 각 요소에 지정된 작업 수행(순서유지,병렬스트림)


* long count() : 스트림의 요소의 개수 반환
* Optional<T> max(Comparator<? super T> comparator) : 스트림의 최대값 반환
* Optional<T> min(Comparator<? super T> comparator) : 스트림의 최소값 반환


* Optional<T> findAny() : 스트림의 요소 하나를 반환(병렬 - 아무거나 하나)
* Optional<T> findFirst() : 스트림의 요소 하나를 반환(직렬 - 첫 번째 요소)


* boolean allMatch(Predicate<T> p) : 주이진 조건을 모든 요소가 만족시키는지 확인(모두 만족하는지)
* boolean anyMatch(Predicate<T> p) : 주이진 조건을 모든 요소가 만족시키는지 확인(하나라도 만족하는지)
* boolean noneMatch(Predicate<T> p) : 주이진 조건을 모든 요소가 만족시키는지 확인(모두 만족하지 않는지)


* Object[] toArray() : 스트림의 모든 요소를 배열로 반환
* A[] toArray(IntFunction<A[]> generator) : 스트림의 모든 요소를 배열로 반환(특정타입의 배열로 반환 가능)  

  
<reduce() & collect() -> 최종연산의 핵심>

* Optional<T> reduce(BinaryOperator<T> accumulator) : 스트림의 요소를 하나씩 줄여가면서(리듀싱) 계산한다.
* T reduce(T identity, BinaryOperator<T> accumulator)
* U reduce(U identity, BiFunction<U,T,U> accumulator, BinaryOperator<T> combiner)


* R collect(Collector<T,A,R> collector) : 스트림의 요소를 수집한다. 주로 요소를 그룹화하거나 분할한 결과를 컬렉션에 담아 반환하는데 사용된다.
* R collect(Supplier<R> supplier, BiConsumer<R,T> accumulator, BiConsumer<R,R> combiner)