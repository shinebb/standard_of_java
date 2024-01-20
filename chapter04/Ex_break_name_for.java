package chapter04;

public class Ex_break_name_for {
    public static void main(String[] args){

        //for문에 Loop1이라는 이름을 붙였다.
        Loop1 : for(int i=2; i<=9; i++){
            for(int j=1; j<=9; j++){
                if (j == 5) {
                    break Loop1; //바깥쪽 for문까지 break 되어서 for문이 종료된다.
                    //break;  //안쪽 for문만 break 되어서 바깥쪽 for문은 계속 돌아간다.
                    //continue Loop1; //쓸수는 있지만 사용할 일이 없으니 알아만 둘것
                    //continue
                }
                System.out.println(i + "*" + j + "=" + i*j);
            }
            System.out.println();
        }
    }
}
