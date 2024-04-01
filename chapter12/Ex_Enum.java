package chapter12;

enum Direction { EAST, SOUTH, WEST, NORTH } //0,1,2,3

public class Ex_Enum {
    public static void main(String[] args){
        Direction d1 = Direction.EAST;  //열거형타입.상수이름
        Direction d2 = Direction.valueOf("WEST");  //문자열을 이용하여 열거형 상수이름
        Direction d3 = Enum.valueOf(Direction.class, "EAST"); //Enum 클래스의 메서드 사용

        System.out.println("d1="+d1);
        System.out.println("d2="+d2);
        System.out.println("d3="+d3);

        System.out.println("d1==d2 ? " + (d1==d2));  //false
        System.out.println("d1==d3 ? " + (d1==d3));  //true
        System.out.println("d1.equals(d3) ? " + d1.equals(d3)); //equals() 비교 가능
        //System.out.println("d2 > d3 ? " + (d1 > d3)); //에러. 객체이기 때문에 비교연산자 사용 불가
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3))); //compareTo() 비교 가능
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2))); //0-2 -> -2 음수

        switch(d1) { //EAST
            case EAST: //Direction.EAST라고 쓸 수 없다.
                System.out.println("The direction is EAST.");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH.");
                break;
            case WEST:
                System.out.println("The direction is WEST.");
                break;
            case NORTH:
                System.out.println("The direction is NORTH.");
                break;
        }

        Direction[] dArr = Direction.values(); //열거형의 모든 상수를 배열로 반환

        for(Direction d : dArr) { //for(Direction d : Direction.values())
            System.out.printf("%s=%d%n", d.name(), d.ordinal()); //ordinal() = 순서(몇 번째로 정의 됐나?) -> 상수들이 가진 값과는 무관함
        }

    }
}
