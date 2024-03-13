package chapter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_Queue {
    static Queue q = new LinkedList();
    static final int MAX_SIZE = 5; //Queue에 최대 5개까지만 저장되도록 한다.

    public static void main(String[] args){
        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

        while(true) {
            System.out.print(">>");

            try {
                //화면으로부터 라인단위로 입력받는다.
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim(); //trim() : 앞 뒤 공백 삭제

                if("".equals(input)) continue; //빈값이면 다시 처음으로 돌아가서 실행

                //equalsIgnoreCase : 대소문자 구분없이 비교
                if(input.equalsIgnoreCase("q")){
                    System.exit(0); //프로그램 종료
                }else if(input.equalsIgnoreCase("help")){
                    System.out.println("help - 도움말을 보여줍니다.");
                    System.out.println("q 또는 Q - 프로그램을 종료합니다.");
                    System.out.println("history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
                }else if(input.equalsIgnoreCase("history")){
                    save(input); //입력받은 명령어를 저장하고,

                    //LinkedList의 내용을 보여준다.
                    LinkedList list = (LinkedList) q;

                    final int SIZE = list.size();

                    //for(int i=0; i<list.size(); i++){
                    for(int i=0; i<SIZE; i++){ //가능하면 이 방법을 사용하는것이 좋다.
                        System.out.println((i+1)+"."+list.get(i));
                    }
                }else{
                    save(input);
                    System.out.println(input);
                }
            }catch(Exception e){
                System.out.println("입력오류입니다.");
            }
        }
    }

    public static void save(String input){
        //queue에 저장한다.
        if(!("".equals(input))){ //빈문자열이 아닐 때 저장
            q.offer(input); //큐에 명령어 저장
        }

        //queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
        if(q.size() > MAX_SIZE) { //size()는 Collection인터페이스에 정의
            q.remove(); //제일 처음에 입력된 요소가 삭제된다. remove() == poll()
        }
    }
}
