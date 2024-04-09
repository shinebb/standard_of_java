package chapter13;

public class Ex_Thread3 {
    static long startTime = 0;

    //싱글스레드
    public static void main(String[] args){
        for(int i=0; i<300; i++){
            System.out.print(new String("-"));
        }

        System.out.println("소요시간1 : " + (System.currentTimeMillis() - startTime));

        for(int i=0; i<300; i++){
            System.out.print(new String("|"));
        }

        System.out.println("소요시간2 : " + (System.currentTimeMillis() - startTime));
    }
}

