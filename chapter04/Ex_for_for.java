package chapter04;

public class Ex_for_for {
    public static void main(String[] args){

        //2중 for문 구구단
        for(int i=2; i<=9; i++){
            for(int j=1; j<=9; j++){
                System.out.println(i+"*"+j+"="+(i*j));
            }
            System.out.println();
        }

        //별찍기(별 10개씩 5줄)
        for(int i=1; i<=5; i++){
            for(int j=1; j<=10; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //별하나씩 늘어나기
        for(int i=1; i<=10; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
