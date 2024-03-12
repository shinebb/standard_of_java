package chapter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex_Stack_Queue {
    public static void main(String[] args){
        Stack st = new Stack();
        Queue q = new LinkedList(); //Queue 인터페이스 구현체인 LinkedList 객체 생성

        st.push("0");
        st.push("1");
        st.push("2");

        q.offer("0");
        q.offer("1");
        q.offer("2");

        System.out.println("= Stack =");
        while (!st.empty()) { //Stack이 비어있지 않으면
            System.out.println(st.pop()); //스택에서 맨 위에 저장된 요소를 꺼낸다. (해당 요소 반환)
        }

        System.out.println("= Queue =");
        while (!q.isEmpty()) {
            System.out.println(q.poll()); //큐에서 가장 밑에 저장된 요소를 꺼낸다. (해당 요소 반환)
        }
    }
}
