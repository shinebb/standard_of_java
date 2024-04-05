package chapter12;


import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Deprecated //사용안할클래스이다
@SuppressWarnings("1111") //유효하지 않은 어노테이션은 무시된다.
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101", hhmmss="235959"))
public class Ex_Annotation2 {
    public static void main(String args[]){
        Class<Ex_Annotation2> cls = Ex_Annotation2.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy()=" + anno.testedBy());
        System.out.println("anno.testDate().yymmdd=" + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss=" + anno.testDate().hhmmss());

        for(String str : anno.testTools()){
            System.out.println("testTools = " + str);
        }

        System.out.println();

        //Ex_Annotation2에 적용된 모든 어노테이션을 가져온다.
        Annotation[] annoArr = cls.getAnnotations();

        for(Annotation a : annoArr){
            System.out.println(a);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)  //실행 시에 사용가능하도록 지정
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit"; //{"JUnit", "FILE"} - 여러개일경우 배열도 가능
    //TestType testType() default TestType.FIRST;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME) //실행 시에 사용가능하도록 지정
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

@Retention(RetentionPolicy.RUNTIME)  //실행 시에 사용가능하도록 지정
@interface TestType {


}

