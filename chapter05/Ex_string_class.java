package chapter05;

import java.util.Scanner;

public class Ex_string_class {
    public static void main(String[] args) {

        String str = "ABCDE";
        char ch = str.charAt(3); //문자열에서 문자 하나 뽑아오기
        System.out.println(ch); //D

        String str2 = str.substring(1, 4); //문자열에 인덱스 1~(4-1)까지 뽑아오기
        System.out.println(str2); //BCD
        String str3 = str.substring(1); //to를 생략하면 인덱스 1부터 끝까지 뽑아오기
        String str4 = str.substring(1, str.length()); //위랑 같은 의미. 1부터 끝까지 뽑아오기
        //문자열의 length는 메서드이기 때문에 ()괄호를 꼭 붙여야한다.
        System.out.println(str3); //BCDE
        System.out.println(str4); //BCDE

    }
}
