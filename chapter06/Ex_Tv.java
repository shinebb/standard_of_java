package chapter06;


public class Ex_Tv {
    public static void main(String args[]){
        Tv t = new Tv(); //객체 생성
        t.channel = 7;  //객체 사용 Tv인스턴스의 멤버변수 channel의 값을 7로
        t.channelDown(); //객체 사용 Tv인스턴스의 메서드 channelDown()을 호출
        System.out.println("현재 채널은 " + t.channel + "입니다.");


        //서로 다른 주소의 객체 2개 생성
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("t1의 채널은 " + t1.channel + "입니다.");
        System.out.println("t2의 채널은 " + t2.channel + "입니다.");

        t1.channel = 7;
        System.out.println("t1의 channel값을 7로 변경하였습니다.");

        System.out.println("t1의 채널은 " + t1.channel + "입니다.");
        System.out.println("t2의 채널은 " + t2.channel + "입니다.");

        t2 = t1; //참조변수 t1의 값을 t2에 저장

        System.out.println("t1의 채널은 " + t1.channel + "입니다.");
        System.out.println("t2의 채널은 " + t2.channel + "입니다.");
    }
}

class Tv{ //클래스 Tv = 설계도
    
    //Tv의 속성(멤버변수)
    String color; //변수 색깔
    boolean power; //변수 전원상태
    int channel; //변수 채널

    //Tv의 기능(메서드)
    void power() {power = !power;}  //메서드
    void channelUp() {channel++;} //메서드
    void channelDown() {channel--;} //메서드
}
