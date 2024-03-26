package chapter12;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

class Product {}
class Tv2 extends Product {}
class Audio2 extends Product{}


public class Ex_Generics3 {
    public static void main(String[] args){
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv2>      tvList = new ArrayList<Tv2>();
        //ArrayList<Product>      tvList = new ArrayList<Tv2>(); //에러
        //List<Tv2> tvList = new ArrayList<Tv2>();                //OK. 다형성

        productList.add(new Tv2());
        productList.add(new Audio2());


        tvList.add(new Tv2());
        tvList.add(new Tv2());
        //tvList.add(new Audio2());  //에러 타입불일치

        printAll(productList);
        //printAll(tvList); //에러 타입불일치

    }

    public static void printAll(ArrayList<Product> list){
        for(Product p : list){
            System.out.println(p);
        }
    }
}
