package chapter07;

public class ex_polymorphism2 {
    public static void main(String[] args){
        Buyer b = new Buyer();


        /*Product p = new Tv1();
        b.buy(p);*/
        //위에 코드와 아래 코드가 같다.
        b.buy(new Tv1());       //buy(Product p)
        b.buy(new Computer());  //buy(Product p)

        System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
        System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다..");

    }
}

class Product {
    int price;        //제품가격
    int bonusPoint;   //보너스점수

    Product(int price)  {
        this.price = price;
        bonusPoint = (int)(price/10.0); //보너스점수는 제품가격의 10%
    }
}
class Tv1 extends Product {
    Tv1() {
        //조상클래스의 생성자 Product(int price)를 호출한다.
        super(100); //Tv의 가격을 100만원으로 한다.
    }

        public String toString() {return "Tv";}
}

class Computer extends Product {
    Computer(){ super(200);}

    public String toString() {return "Computer";}
}
class Audio extends Product {
    Audio(){ super(200);}

    public String toString() {return "Audio";}
}

class Buyer { //물건 사는 사람
    int money = 1000; //소유금액
    int bonusPoint = 0; //보너스점수z

    void buy(Product p){
        if(money < p.price)    {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= p.price;   //가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += p.bonusPoint; //제품의 보너스 점수를 추가한다.
        System.out.println(p + "을/를 구입하셨습니다."); //p = p.toString()
    }
}
