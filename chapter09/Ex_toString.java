package chapter09;

import java.util.Objects;

public class Ex_toString {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        System.out.println(c1.toString()); //Card에서 toString()이 오버라이딩 되어있지 않다면 주소값 반환
        System.out.println(c2.toString());

        System.out.println(c1.equals(c2));
        System.out.println(c1.hashCode()); //안하면 c1과 c2값은 다르다.
        System.out.println(c2.hashCode());
    }
}

class Card {
    String kind;
    int number;

    Card() {
        this("SPADE", 1);
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    //equals()를 오버라이딩 하면 hashCode()도 오버라이딩 해야한다.
    //-> equals()가 true 가면 hashCode()도 같게 해줘야한다.
    public int hashCode() {
        return Objects.hash(kind, number); //매개변수가 가변인자라서 호출 시 지정하는 값의 개수가 정해져있지 않다.
    }

    //equals 오버라이딩
    public boolean equals(Object obj){
        if(!(obj instanceof Card)){
            return false;
        }
        Card c = (Card) obj;
        return this.kind.equals(c.kind) && this.number == c.number;
    }

    //Object 클래스의 toString()을 오버라이딩
    public String toString() {
        return "kind : " + kind + ", number : " + number;
    }
}