package chapter02;

public class Ex_typeChange {
    public static void main(String[] args){

        String str = "3";

        System.out.println(str.charAt(0) - '0'); //문자 3 : charAt(0) 문자열을 문자로
        System.out.println("3".charAt(0) - '0'); //문자 3 : charAt(0) 문자열을 문자로
        System.out.println('3' - '0');          //숫자 3 : 문자 '3'을 숫자 3으로
        System.out.println('3' - '0' + 1);      //숫자 4 : 문자 '3'을 숫자 3으로 변환 뒤 +1
        System.out.println(Integer.parseInt("3") + 1);  //숫자 4 : 문자열을 숫자 3으로 변환 뒤 +1
        System.out.println(Integer.parseInt(str) + 1);  //숫자 4 : 문자열을 숫자 3으로 변환 뒤 +1
        System.out.println("3" + 1); //문자열 31 : 문자열+숫자 -> 좌측우선
        System.out.println(3 + '0'); //숫자 51 : '0'은 숫자 48
        System.out.println((char)(3 + '0')); //문자 3
    }
}
