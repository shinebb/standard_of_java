참조변수(super)
=========================
"객체 자신을 가리키는 참조변수. 인스턴스 메서드(생성자)내에만 존재(static 메서드내에 사용불가)"
"조상의 멤버를 자신의 멤버와 구별할 때 사용"


class Parent { int x = 10; } /* super.x */

class Child extends Parent {  
int x = 20; /* this.x */  
void method() {  
System.out.println("x = " + x) ;  
System.out.println("this.x = " + this.x) ; //20  
System.out.println("super.x = " + super.x) ; //10  
}


super() - 조상의 생성자
---------
*****
* "조상의 생성자를 호출할 때 사용"  
* "조상의 멤버는 조상의 생성자를 호출해서 초기화"  
(*생성자/초기화블럭 상속 되지않는다.)

* "(중요!) 모든 생성자의 첫 줄에 반드시 생성자를 호출해야한다."
* "그렇지 않으면 컴파일러가 생성자의 첫 줄에 super();를 삽입한다."
* "기본 생성자 작성 필수, 첫줄에 반드시 생성자 호출 필수"

class Point {  
    int x, y;  
    Point(int x, int y){ //iv 초기화  
        /* 컴파일시 super(); 추가됨 */
        this.x = x;  
        this.y = y;  
    }  
}

class Point3D extends Point {  
    int z;  
    Point3D(int x, int y, int z) {  
        this.x = x; //조상의 멤버를 초기화  
        this.y = y; //조상의 멤버를 초기화  
        this.z = z;  
    }  
}  
=> 자손의 생성자가 조상의 멤버를 초기화 => 에러는 안나지만 이런식으로 하면 안됨

=>  
Point3D(int x, int y, int z){  
    super(x, y); //조상클래스의 생성자 Point(int x, int y)를 호출  
    this.z = z; //자신의 멤버를 초기화  
}  






