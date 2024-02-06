package chapter07;


class MyParent { //접근제어자가 (default)이기 때문에 같은 패키지에서 가능
    private   int prv; //같은 클래스
              int dft; //같은 패키지 (접근제어자 (default) 생략됨)
    protected int prt; //같은 패키지 + 자손
    public    int pub; //접근제한 없음.

    public void printMember() {
        System.out.println(prv); //OK 같은 클래스이기 때문에 가능
        System.out.println(dft);
        System.out.println(prt);
        System.out.println(pub);
    }
}

public class Ex_modifier {
    public static void main(String[] args){

        MyParent p = new MyParent();
        //System.out.println(p.prv); //에러. 접근제어자 private은 같은 클래스가 아니므로 에러 발생
        System.out.println(p.dft);
        System.out.println(p.prt);
        System.out.println(p.pub);

    }
}
