package chapter04;

public class Ex_for {
    public static void main(String[] args){

        //i=1이고 i가 5보다 작거나 같은 동안 괄호{}안 문장을 실행하며 한 번 실행할 때마다 i는 1씩 증가한다.
        for(int i=1; i<=5; i++){ //i=1,2,3,4,5 => 5번 반복
            System.out.println("Hello");
        }

        for(int i=1; i<=10; i=i+2){ //i=1,3,5,7,9 => 5번 반복
            System.out.println("Hello2");
        }

        for(int i=10; i>=1; i--){ //i=10,9,8,7,6,5,4,3,2,1 => 10번 반복
            System.out.println("i="+i);
        }
        //조건식을 잘 못 입력하면 무한 반복에 빠지게 되니 주의할 것.

        for(int i=1, j=10; i<=10; i++, j--){ //변수 두개 사용시 두 변수의 타입이 같아야 한다.
            System.out.println("i="+i+",j="+j);
        }
        //System.out.println(i); //error. for문에서 선언된 변수는 for문 안에서만 사용할 수 있다.

        int i; //scope(범위) : 범위는 좁을수록 좋음
        for(i=1; i<=5; i++){ //i=1,2,3,4,5 => 5번 반복
            System.out.println("Hello");
        }
        System.out.println(i);  //이렇게 for문 밖에 선선하면 해당 코드를 쓸 수 있지만, 범위는 좁을수록 좋기 때문에 권장하지 않는다.

        //조건식을 생략하면 true로 간주되어서 무한반복문이 된다.
        /*for(;;){
            System.out.println("i="+i);
        }*/


        int sum = 0;

        for(int j=1; j<=5; j++){
            sum += j; //sum=sum+i;
            System.out.printf("1부터 %2d까지의 합 : %2d%n", j, sum);
        }
    }
}
