package chapter09;

public class Ex_wrapper {

    public static void main(String[] args){
        Integer i = new Integer(100);
        Integer i2 = new Integer(100);

        System.out.println("i==i2 ? " + (i==i2));  //false
        System.out.println("i.equals(i2) ? " + i.equals(i2)); //true
        System.out.println("i.compareTo(i2) = " + i.compareTo(i2)); //0 -> 같으면 0 / 작으면 양수 / 크면 음수
        System.out.println("i.toString() = " + i.toString()); //100

        System.out.println("MAX_VALUE = " + Integer.MAX_VALUE); //Integer의 최대값 20억
        System.out.println("MIN_VALUE = " + Integer.MIN_VALUE); //Integer의 최소값 -20억
        System.out.println("SIZE = " + Integer.SIZE + " bits"); //Integer의 크기 32비트
        System.out.println("BYTES = " + Integer.BYTES + " bytes"); //Integer의 크기 4byte
        System.out.println("TYPE = " + Integer.TYPE); //타입 int
    }
}
