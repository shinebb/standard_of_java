package chapter05;

public class Ex_commend {
    public static void main(String[] args){

        System.out.println("매개변수의 개수 : " + args.length);

        for(int i=0; i<args.length; i++){
            System.out.println("args["+i+"] = \"" + args[i]+ "\"");
        }

        /*
        커맨드창
        ex)
        c >java Ex_commend abc 1234 "Hello world"
        매개변수의 개수 : 3
        args[0] = "abc"
        args[1] = "123"
        args[2] = "Hello world"

        c >java Ex_commend //매개변수를 입력하지 않는다면
        매개변수의 개수 : 0 //java에서는 길이가 0인 배열을 허용한다.

        ******intelliJ 커맨드창 사용법
        Edit Configurations > Application 추가 > Main Class 에 패키지.클래스 네임 입력(chapter05.Ex_commend)
        > 아래 Program arguments에 원하는 값 입력

        *****Window 커맨트창 사용법
        기존방법 :
        해당 클래스 폴더 위치 확인(.java가 아닌 .class파일)(D:\devMusign\standard_of_java\out\production\standard_of_java\chapter05) 복사
        > Window cmd 창 오픈 > cd 경로 (해당경로 이동) > java Ex_commend abc 1234 "Hello" 입력하면 실행됨

        본인 방법 :
        해당 클래스 폴더 위치 확인(.java가 아닌 .class파일)(D:\devMusign\standard_of_java\out\production\standard_of_java) 복사
        (chapter05 패키지를 포함한 이전 경로에서 실행 가능) -> D드라이브로 이동이 안돼서 "cd /d D:\" 로 다른 드라이브 이동후 다시 D드라이브 이동
        > Window cmd 창 오픈 > cd 경로 (해당경로 이동) > java chapter05.Ex_commend abc 1234 "Hello" 패키지명까지 입력하면 실행됨.

        */
    }
}
