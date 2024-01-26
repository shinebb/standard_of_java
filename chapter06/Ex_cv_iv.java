package chapter06;


public class Ex_cv_iv {
    public static void main(String args[]){
        System.out.println("Card.width = " + Card.width); //CV는 객체 생성없이 사용 가능
        System.out.println("Card.height = " + Card.height); //CV는 클래스가 올라가면서 자동으로 만들어짐

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
        System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");

        c1.width = 50; //참조변수로 다루니까 iv로 보이지만 cv임. 따라서 cv는 클래스로 => Card.width로 작성하여 이 클래스들이 모든 객체가 공유하는 cv이라는것을 나타내주는것이 좋다.
        c1.height = 80;

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
    }
}

class Card {
    String kind;
    int number;
    static int width = 100;
    static int height = 250;
}
