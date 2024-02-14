package chapter07;



abstract class Unit2 {
    int x, y;
    abstract void move(int x, int y);
    void stop() {
        System.out.println("멈춥니다.");
    }
}

interface Fightable { //인터페이스의 모든 메서드는 public abstract (예외없이)
    void move(int x, int y); //public abstract가 생략됨
    void attack(Fightable f); //public abstract가 생략됨
}

class Fighter extends Unit2 implements Fightable {
    //오버라이딩 규칙 : 조상(public)보다 접근제어자가 좁으면 안된다.
    public void move(int x, int y) { //public 안붙이면 (default)이므로 에러
        System.out.println("[" + x + ", " + y+ "]로 이동");
    } //public abstract가 생략됨
    public void attack(Fightable f) {
        System.out.println(f + "를 공격");
    } //public abstract가 생략됨

    //싸울 수 있는 상대를 불러온다.
    Fightable getFightable() {
        Fighter f = new Fighter(); //Figther를 생성해서 반환
        return f; //(Fightable)f 이 생략됨 (자동형변환)
    }
}

public class Ex_Interface {
    public static void main(String[] args){
        Fighter f = new Fighter();
        f.move(100, 200);
        f.attack(new Fighter());
        f.stop();
        
        Fightable ft = f.getFightable();
        System.out.println("====================================");

        Unit2 f2 = new Fighter();
        f2.move(100, 200);
        //f2.attack(new Fighter()); //Unit2에는 attack()이 없기때문에 에러
        f2.stop();
        System.out.println("====================================");

        Fightable f3 = new Fighter();
        f3.move(100, 200);
        f3.attack(new Fighter());
        //f3.stop(); //Fightable에는 stop()이 없기때문에 에러
    }
}
