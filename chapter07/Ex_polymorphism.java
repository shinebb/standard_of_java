package chapter07;

public class Ex_polymorphism {
    public static void main(String[] args){
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe; //car = (Car)fe; 에서 형변환이 생략됨
        //car.water(); //car는 Car타입으로 water 멤버변수를 가지고 있지 않음.
        fe2 = (FireEngine)car; //자손 타입 <- 조상타입. 형변환 생략 불가
        fe2.water();


        /*NullPointerException1*/
        Car car3 = null; //실제 인스턴스가 무엇인지가 중요.
        FireEngine fe3 = (FireEngine) car3; // 조상 -> 자손으로 형변환
        Car car2 = (Car)fe3;                //자손 -> 조상으로 형변환
        car2.drive(); // 에러 : NullPointerException -> car3 = null -> fe3에 car3를 넣으니 fe3도 null


        /*ClassCastException*/
        Car c = new Car();
        FireEngine f = (FireEngine) c; //ClassCastException
        //car = fe와 다른점 -> 여기서는 이미 new Car() 객체가 생성되었음. c객체는 4개의 멤버만 사용가능
        //위는 null인 car에 FireEngine 객체를 넣었으면 car = new FireEngine()으로 새로운 객체를 넣어준거임.
        //따라서 car를 넣은 fe2에서도 water()가 사용가능하지만
        //아래경우에는 이미 Car 객체를 생성했으므로 형변환을 해도 water()를 쓸 수 없다.
        f.water();
    }
}

class Car {
    String color;
    int door;

    void drive() { //운전하는 기능
        System.out.println("drive, Brrrr~");
    }

    void stop() { //멈추는 기능
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car { //소방차
    void water() {  //물을 뿌리는 기능
        System.out.println("water!!!");
    }
}