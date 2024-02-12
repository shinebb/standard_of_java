package chapter07;

public class Ex_polymorphism3 {
    public static void main(String[] args){
        Buyer2 b = new Buyer2();


        /*Product p = new Tv1();
        b.buy(p);*/
        //위에 코드와 아래 코드가 같다.
        b.buy(new Tv2());       //buy(Product p)
        b.buy(new Computer2());  //buy(Product p)
        b.buy(new Audio2());  //buy(Product p)
        b.summary();

        System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다..");

    }
}

class Product2 {
    int price;        //제품가격
    int bonusPoint;   //보너스점수

    Product2(int price)  {
        this.price = price;
        bonusPoint = (int)(price/10.0); //보너스점수는 제품가격의 10%
    }

    Product2() {} //기본생성자
}
class Tv2 extends Product2 {
    Tv2() {
        //조상클래스의 생성자 Product(int price)를 호출한다.
        super(100); //Tv의 가격을 100만원으로 한다.
    }

        public String toString() {return "Tv";}
}

class Computer2 extends Product2 {
    Computer2(){ super(200);}

    public String toString() {return "Computer";}
}
class Audio2 extends Product2 {
    Audio2(){ super(50);}

    public String toString() {return "Audio";}
}

class Buyer2 { //물건 사는 사람
    int money = 1000; //소유금액
    int bonusPoint = 0; //보너스점수z

    Product2[] cart = new Product2[10]; //구입한 제품을 저장하기 위한 배열
    int i = 0;      //Product배열에 사용될 카운터

    void buy(Product2 p){
        if(money < p.price)    {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= p.price;   //가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += p.bonusPoint; //제품의 보너스 점수를 추가한다.
        cart[i++] = p;      //제품을 Product[] cart에 저장한다.
        System.out.println(p + "을/를 구입하셨습니다."); //p = p.toString()
    }

    void summary() {    //구매한 물품에 대한 정보를 요약해서 보여 준다.
        int sum = 0; //구입한 물품의 가격합계
        String itemList = ""; //구입한 물품목록

        //반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
        for(int i=0; i<cart.length; i++){
            if(cart[i]==null) break;
            sum += cart[i].price;
            itemList += cart[i] + ", ";
        }

        System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");


    }


}
