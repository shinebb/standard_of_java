package chapter06;

public class Ex_this_constructor {
}

class Car2 {
    String color;    //색상
    String gearType; //변속기 종류 - auto(자동), manual(수동)
    int door;        //문의 개수

    /*코드의 중복을 제거하기 위해 서로를 호출한다.*/
    Car2() {
        /*color = "white";
        gearType = "auto";
        door = 4;*/
        //door = 5; => 다른 생성자 호출시에는 첫 줄에서만 가능하다.
        this("white", "auto", 4);
        //Car2(String color, String gearType, int door)를 호출
        //같은 클래스에 있는 생성자를 호출할 때는 Car2 대신 this 사용
    }
    Car2(String color){
        this(color, "auto", 4);
    }
    Car2(String color, String gearType, int door){
        this.color = color; //this.color->iv / color->lv
        this.gearType = gearType;
        this.door = door;
    }

    Car2(String c, String g){
        color = c; //같은 클래스 내에서 this 생략가능 위의 경우에는 구분을 위해 this작성 필수
        gearType = g;
    }
}
