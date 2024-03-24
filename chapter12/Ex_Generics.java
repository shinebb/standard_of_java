package chapter12;

import java.util.ArrayList;

public class Ex_Generics {
    public static void main(String[] args){
        ArrayList list = new ArrayList();

        list.add(10);
        list.add(20);
        list.add("30"); //String을 추가

        System.out.println(list);

        //Integer i = (Integer) list.get(2); //컴파일 OK (Object 형을 Integer 로 형변환하기 때문에)
        //그러나 실행하면 형변환에러 발생. -> ClassCastException -> list.get(2)는 String 이기 때문에 -> 컴파일러의 한계
        //컴파일 에러가 낫다.. 실행시 에러는 프로그램이 죽기때문에...
        String i = (String)list.get(2); //에러 안나게 하려면 이렇게 사용하면 된다.

        ArrayList<Integer> list2 = new ArrayList<Integer>(); //Integer만 저장할 수 있게 제네읽스를 설정해준다.

        list2.add(10);
        list2.add(20);
        //list2.add("30"); //Integer만 들어갈 수 있기 때문에 에러 발생. 컴파일에러 발생, 타입 체크 강화
        list2.add(30);

        System.out.println(list2);

        Integer ii = list2.get(2); //형변환 생략가능. 이미 Integer인 걸 알기 때문에.

    }
}
