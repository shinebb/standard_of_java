package chapter12;


enum Direction2 {
    EAST(1, ">"), SOUTH(2, "v"), WEST(2, "<"), NORTH(3,"^");

    private static final Direction2[] DIR_ARR = Direction2.values();

    /* iv 변수 선언 */
    private final int value;
    private final String symbol;

    /* 생성자
    * EAST(1, ">") 가 생성자 호출하는 것이므로 ()에 값을 저장하려면 생성자 선언 필수
    * */

    Direction2(int value, String symbol) { //접근 데어자 private이 생략됨
        this.value = value;
        this.symbol = symbol;
    }

    /* getter */
    public int getValue() { return value; }
    public String getSymbol() { return symbol; }

    /* 메서드 */
    public static Direction2 of(int dir) throws IllegalAccessException {
        if(dir < 1 || dir > 4) {
            throw new IllegalAccessException("Invalid value : " + dir);
        }

        return DIR_ARR[dir - 1];
    }

    /* 메서드 */
    public Direction2 rotate(int num) {
        num = num % 4;

        if(num < 0){
            num += 4; //num이 음수일 때는 시계반대 방향으로 회전
        }

        return DIR_ARR[(value-1+num) % 4];
    }

    public String toString(){
        return name() + getSymbol();
    }

}
public class Ex_Enum2 {
    public static void main(String[] args) throws IllegalAccessException {
        for(Direction2 d : Direction2.values()){
            System.out.printf("%s=%d%n", d.name(), d.getValue());
        }

        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.of(1);

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
        System.out.println(Direction2.EAST.rotate(1));
        System.out.println(Direction2.EAST.rotate(2));
        System.out.println(Direction2.EAST.rotate(-1));
        System.out.println(Direction2.EAST.rotate(-2));
    }
}
