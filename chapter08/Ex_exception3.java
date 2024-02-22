package chapter08;

import java.io.File;

public class Ex_exception3 {
    public static void main(String args[]){
        try {
            File f = createFile("test2.txt");
            System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
        } catch(Exception e) {
            System.out.println(e.getMessage() + " 다시 입력해 주시기 바랍니다.");
        }
    }

    static File createFile(String fileName) throws Exception { //여기에 try catch문을 만들어서 처리해도 됨. 지금은 throws를 사용해 이 메서드를 호출한 곳에 넘겨줌.
        if(fileName==null || fileName.equals("")){
            throw new Exception("파일이름이 유효하지 않습니다.");
        }
        File f = new File(fileName);  //File 클래스의 객체를 만든다.
        //File객체의 createNewFile메서드를 이용해서 실제 파일을 생성한다.
        f.createNewFile();
        return f; //생성된 객체의 참조를 반환한다.
    }
}
