package chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex_stream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream(); //list를 Stream으로 변환(정확히는 변환이 아니라 list를 데이터 소스로 하는 새로운 스트림을 생성
        intStream.forEach(System.out::print);
        //intStream.forEach(System.out::print); //한번 더 실행하면 에러발생. 이미 stream이 닫혔기 때문에

        //stream은 1회용. stream에 대해 최종연산을 수행하면 stream이 닫힌다.
        intStream = list.stream(); //list로부터 stream을 생성
        intStream.forEach(System.out::print);
    }
}
