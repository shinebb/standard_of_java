package chapter11;

import java.util.Stack;

public class Ex_Stack {
    public static void main(String[] args){

        /*if(args.length != 1) {
            System.out.println("Usage:java Ex_Stack \"EXPRESSION\"");
            System.out.println("Example:java Ex_Stack \"((2+3)*1)+3\"");
            System.exit(0); //프로그램 종료
        }*/

        Stack st = new Stack();
        //String expression = args[0];
        String expression = "((3+5)*8-2)";

        System.out.println("expression: " + expression);

        try {
            for(int i=0; i<expression.length(); i++){
                char ch = expression.charAt(i); //i번때 인덱스에 있는 문자 하나를 반환

                if(ch == '('){
                    st.push(ch + ""); //'(' Stack 요소 추가
                }else if(ch == ')'){
                    st.pop(); //')' Stack 요소 제거
                }
            }

            if(st.isEmpty()) { //스택이 비어있으면 괄호가 갯수에 맞게 들어간것.
                System.out.println("괄호가 일치합니다.");
            }else {             //'('가 ')'더 많으면 스택이 비어있지 않다.
                System.out.println("괄호가 일치하지 않습니다.");
            }
        }catch (Exception e){ //')'보다 '('가 많으면  pop()할 요소가 없으므로 예외 발생
            System.out.println("괄호가 일치하지 않습니다.");
        }
    }
}
