익명 클래스(anonymous class)
=========================

* 이름이 없는 일회용 클래스. 정의와 생성을 동시에

    
    new 조상클래스이름() {
        //멤버 선언
    }
    
    new 구현인터페이스이름() {
        //멤버 선언
    }

<br>

    class Ex {
        Object iv = new Object() { void method(){} );           //익명클래스
        static Object cv = new Object() { void method(){} );    //익명클래스
        
        void myMethor() {
            Object iv new Object() { void method(){} };  //익명클래스
        }
    }


예제
---------
*****

* 일반


    import java.awt.*;
    import java.event.*;

    class Ex {
        public static void main(String[] args) {
            Button b = new Button("Start");
            b.addActionListener(new EventHandler());
        }
    }

    class EventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionEvent occurred!!!");
        }
    }

<br>  

* 익명 클래스 사용시


    b.addActionListner(new ActionListener() {   //조상이름 사용
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionEvent occurred!!!");
        }
    });
    