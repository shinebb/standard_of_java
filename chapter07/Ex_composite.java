package chapter07;

class Point { //부모 클래스가 없으니 컴파일 시 extends Object 가 추가된다.
    int x;
    int y;
}


class Circle extends Point { //상속
    int r;
}


class Circle2 { //포함
    Point p = new Point(); //참조변수의 초기화
    int r;
}

public class Ex_composite {
    public static void main(String[] args){
        
        //상속일 때
        Circle c = new Circle();
        c.x = 1;
        c.y = 2;
        c.r = 3;

        System.out.println("c.x="+c.x);
        System.out.println("c.y="+c.y);
        System.out.println("c.r="+c.r);

        //포함일 때
        Circle2 c2 = new Circle2();
        c2.p.x = 1;
        c2.p.y = 2;
        c2.r = 3;

        System.out.println("c.x="+c2.p.x);
        System.out.println("c.y="+c2.p.y);
        System.out.println("c.r="+c2.r);


        System.out.println(c2.toString());
        //Object 클래스를 상속받고있지 때문에 toString() 메서드를 사용해도 오류가 나지 않는다.
        //println메서드의 기능으로 c2만 써도 같은 값이 출력되기때문에 활성화 안됨.
    }
}
