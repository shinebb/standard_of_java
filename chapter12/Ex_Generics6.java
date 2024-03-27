package chapter12;

import java.util.ArrayList;

class Fruit implements Eatable {
    public String toString() { return "Fruit"; }
}
class Apple extends Fruit{ public String toString() { return "Apple"; }}
class Grape extends Fruit{ public String toString() { return "Grape"; }}
class Toy{ public String toString() { return "Toy"; }}

interface Eatable{}

public class Ex_Generics6 {
    public static void main(String[] args){
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
        //FruitBox<Grape> grapeBox = new FruitBox<Apple>(); //에러. 타입 불일치
        //FruitBox<Toy> toyBox = new FruitBox<Toy>(); //에러. Fruit 자손 아님
        Box<Toy> toyBox = new Box<Toy>(); //OK

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple()); //다형성
        fruitBox.add(new Grape()); //다형성
        appleBox.add(new Apple());
        //appleBox.add(new Grape()); //에러. Grape는 Apple의 자손이 아님
        grapeBox.add(new Grape());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);
    }
}

class FruitBox<T extends Fruit & Eatable> extends Box<T>{}
//Fruit의 자손이면서 Eatable 인터페이스를 구현한 애들만 들어올 수 있음.
//그러나 여기서는 Fruit가 이미 Eatable 인터페이스를 구현했기 때문에 Eatable 생략가능

class Box<T> {
    ArrayList<T> list = new ArrayList<T>(); //item을 저장할 list
    void add(T item) { list.add(item); }    //박스에 item을 추가
    T get(int i)     { return list.get(i); } //박스에서 item을 꺼낼 때
    int size()       { return list.size(); }
    public String toString() { return list.toString(); }
}