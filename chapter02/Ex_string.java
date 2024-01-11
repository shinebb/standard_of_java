package chapter02;

public class Ex_string {
    public static void main(String[] args){

        char ch = 'A';
        //char ch = 'AB'; //에러
        System.out.println(ch); //A

        int i = 'A';
        System.out.println(i);  //65

        String str = "";  //빈 문자열(empty string)
        String str2 = "ABCD";
        String str3 = "123";
        String str4 = str2 + str3;
        System.out.println(str4);  //ABCD1234

        System.out.println(""+7+7); //77
        System.out.println(7+7+""); //14


    }
}
