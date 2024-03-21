package chapter11;

import java.util.HashMap;
import java.util.Scanner;

public class Ex_HashMap {
    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111"); //1111로 저장된 후
        map.put("asdf", "1234"); //1234로 값만 변경됨

        Scanner s = new Scanner(System.in); //화면으로부터 라인단위로 입력 받음

        while(true){
            System.out.println("id와 password를 입력해주세요");
            System.out.print("id : ");
            String id = s.nextLine().trim();

            System.out.print("password : ");
            String password = s.nextLine().trim();
            System.out.println();

            if(!map.containsKey(id)){
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                continue; //while문 다시 시작
            }

            if(!(map.get(id)).equals(password)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");

            }else {
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            }
        }
    }
}
