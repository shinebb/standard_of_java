package chapter14;

import java.util.Random;
import java.util.stream.IntStream;

public class Ex_Random {
    public static void main(String[] args) {
        //IntStream intStream = new Random().ints(); //무한스트림
        //intStream.limit(5).forEach(System.out::println);


        IntStream intStream = new Random().ints(5); //유한스트림
        intStream.forEach(System.out::println);

        IntStream intStream2 = new Random().ints(5,10); //유한스트림
        intStream2.limit(5).forEach(System.out::println);

        IntStream intStream3 = new Random().ints(10,5,10); //유한스트림
        intStream3.forEach(System.out::println);

    }
}
