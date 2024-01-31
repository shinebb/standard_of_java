package chapter06;

public class Ex_overloading {
    public static void main(String[] args){
        MyMath3 mm = new MyMath3();
        System.out.println("mm.add(3, 3) 결과 : " + mm.add(3,3));
        System.out.println("mm.add(3L, 3) 결과 : " + mm.add(3L,3));
        System.out.println("mm.add(3, 3L) 결과 : " + mm.add(3,3L));
        System.out.println("mm.add(3L, 3L) 결과 : " + mm.add(3L,3L));

        int[] a = {100, 200, 300};
        System.out.println("mm.add(a) 결과 : " + mm.add(a));

    }
}

class MyMath3 {
    //메서드이름 : add (대부분 동사(작업을하기때문에))
    //이름이 같다 == 하는 작업이 같다.

    int add(int a, int b){
        System.out.print("int add(int a, int b) - ");
        return a+b;
    }

    long add(long a, long b){
        System.out.print("long add(long a, long b) - ");
        return a+b;
    }

    int add(int[] a){ //배열의 모든 요소의 합을 결과로 돌려준다.
        System.out.print("int add(int[] a) - ");
        int result = 0;
        for(int i=0; i<a.length; i++){
            result += a[i];
        }
        return result;
    }

}

