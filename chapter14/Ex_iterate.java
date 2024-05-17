package chapter14;

import java.util.stream.Stream;

public class Ex_iterate {
    public static void main(String[] args){

        //iterate(T seed, UnaryOperator f) (초기값, 단항연산자)
        Stream<Integer> intStream = Stream.iterate(0, n->n+2); //seed가 시작(n)
        intStream.limit(10).forEach(System.out::println);
        //limit없으면 무한 반복됨

        //generate(Supplier s) : 주기만 하는 것(입력x, 출력o)
        Stream<Integer> oneStream = Stream.generate(()->1); //계속해서 1만 반환
        oneStream.limit(10).forEach(System.out::println);


    }
}
