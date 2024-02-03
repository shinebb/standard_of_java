package chapter07;


class Point3 {
    int x;
    int y;
    String getLocation() {
        return "x:" + x + ", y:" + y;
    }
}

class Point3D extends Point3 {
    int z;

    //조상의 getLocation()을 오버라이딩
    String getLocation() {
        return "x:" + x + ", y:" + y + ", z:" + z;
    }
}

//간결한 코드
class Point2 extends Object {
    int x;
    int y;

    Point2(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    //Object 클래스의 toString() 메서드 오버라이딩
    public String toString(){
        return "x:" + x + ", y:" + y;
    }
}
public class Ex_override {
    public static void main(String[] args){
        //단 2줄의 코드로 끝난다.
        Point2 p2 = new Point2(1, 4);
        System.out.println(p2);

        Point3D p = new Point3D();
        p.x = 3;
        p.y = 5;
        p.z = 7;
        System.out.println(p.getLocation());

    }
}
