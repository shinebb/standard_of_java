package chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex_Arrays {
    public static void main(String[] args) {
        /*List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream(); //list를 Stream으로 변환
        intStream.forEach(System.out::print); //forEach() 최종연산

        //stream은 1회용. stream에 대해 최종연산을 수행하면 stream이 닫힌다.
        intStream = list.stream(); //list로부터 stream을 생성
        intStream.forEach(System.out::print);*/


        String[] strArr = {"a","b","c","d"};
        //Stream<String> strStream = Stream.of(strArr);
        Stream<String> strStream = Arrays.stream(strArr); //둘 중 편한걸로 사용
        strStream.forEach(System.out::println);

        int[] intArr = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArr);
        intStream.forEach(System.out::println);

        Integer[] intArr2 = {1,2,3,4,5};
        Stream<Integer> intStream2 = Arrays.stream(intArr2);
        intStream2.forEach(System.out::println);


    }
}
