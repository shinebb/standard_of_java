package chapter03;

public class Ex_Increase {
    public static void main(String args[]){
        int i=5, j=0;

        j = i++; //후위형
        System.out.println("j=i++; 실행 후, i=" + i + ", j=" + j);

        //결과 비교를 위해, 다시 5, 0 으로 변경
        i=5;
        j=0;

        j = ++i; //전위형
        System.out.println("j=++i; 실행 후, i=" + i + ", j=" + j);
    }
}
