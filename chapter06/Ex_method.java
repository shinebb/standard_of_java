package chapter06;


public class Ex_method {
    public static void main(String args[]){
        MyMath mm = new MyMath();

        long result1 = mm.add(5L, 3L); //add 메서드 호출
        //1. main메서드에서 메서드 add를 호출한다. 인수 5L, 3L이 메서드 add의 매개변수 a,b에 각각 복사(대입)된다.

        long result2 = mm.subtract(5L, 3L); //subtract 메서드 호출
        long result3 = mm.multiply(5L, 3L); //multiply 메서드 호출
        double result4 = mm.divide(5L, 3L); //divide 메서드 호출

        mm.printGugudan(12);
        mm.printGugudan(3);

        System.out.println("add(5L, 3L) = " + result1);
        System.out.println("subtract(5L, 3L) = " + result2);
        System.out.println("multiply(5L, 3L) = " + result3);
        System.out.println("divide(5L, 3L) = " + result4);
    }
}

class MyMath { //메서드는 클래스 영역에만 정의 가능
    long add(long a, long b) { //2. 메서드 add의 괄호{}엔에 있는 문장들이 순서대로 수행된다.
        long result = a+b;

        //메서드 add의 모든 문장이 실행되거나 return문을 만나면, 호출한 메서드(main메서드)로 되돌아와서 이후의 문장들을 실행한다.
        return result;
        //return a+b; //위의 두 줄을 이와 같이 한 줄로 간단히 할 수 있다.
    }
    long subtract(long a , long b) { return a-b;}
    long multiply(long a , long b) { return a*b;}
    double divide(double a, double b){
        return a/b;
    }

    void printGugudan(int dan) {
        if(!(2<=dan && dan <=9)){
            return; //입력받은 단(dan)이 2~9가 아니면, 메서드 종료하고 돌아가기
        }
        
        for(int i=1; i<=9; i++){
            System.out.printf("%d * %d = %d%n", dan, i, dan*i);
        }      
    }

    long max(long a, long b){
        if(a>b)
            return a; //조건식이 참일 때만 실행
        else //만약 else return문이 없으면 error 무조건 return값이 있어야하기때문에.
            return b; //조건식이 거짓일 때 실행
    }
}