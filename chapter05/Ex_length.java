package chapter05;

public class Ex_length {
    public static void main(String[] args){

        int[] arr = new int[5]; //길이가 5인 int배열 arr 생성
        System.out.println("arr.length="+arr.length); //5

        for(int i=0; i<arr.length; i++){ //배열의 길이만큼 for문이 실행된다.
            System.out.println("arr["+i+"]="+arr[i]);
        }
        //i<arr.length;가 아닌 i<7로 for문을 돌린다면
        //index의 범위를 벗어나기 때문에 에러가 발생한다.
    }
}
