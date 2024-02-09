instanceof 연산자
=========================
* 참조변수의 형변환 가능여부 확인에 사용. 가능하면 true 반환
* 형변환 전에 반드시 instanceof로 확인하고 형변환해야 함.


        void doWork(Car c) { 
            /*Car의 모든 자손이 들어올 수 있지만 new Car()가 들어올지 new FireEngine()이 들어올지 
            new Ambulance()가 들어올지 모르기 때문에 형변환이 가능한지 확인이 필요하다.*/
            if(c instanceof FireEngine) {       //1. 형변환이 가능한지 확인
                                                //(c의 객체가 FireEngine인지 또는 FireEngine의 자손인지)
                FireEngine fe = (FireEngine)c;  //2. 형변환
                fe.water();
                ...
            }
        }


<br>

        FireEngine fe = new FireEngine();
        System.out.println(fe instanceof Object);     //true
        System.out.println(fe instanceof Car);        //true
        System.out.println(fe instanceof FireEngine); //true

        Object obj = (Object)fe; //OK
        Car    c   = (Car)fe;    //OK

* 자기 자신을 비롯해 조상까지도 true가 나오기 때문에 주의.


Q.참조변수의 형변환은 왜 하나요?
---------
*****

A : 참조변수(리모콘)을 변경함으로써 사용할 수 있는 멤버의 갯수를 조절하기 위해서

        FireEngine f = new FireEngine();
        Car c = (Car)f;  //OK. 조상인 Car타입으로 형변환(생략가능)


Q.instanceof연산자는 언제 사용하나요?
---------
*****

A : 참조변수를 형변환하기 전에 형변환 가능여부를 확인할 때

        void doWork(Car c) {
            if(c instanceof FireEngine) {       //1. 형변환이 가능한지 확인
                FireEngine fe = (FireEngine)c;  //2. 형변환
                fe.water();
                ...
            }
        }