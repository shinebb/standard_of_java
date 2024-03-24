Generics(제네릭스)
==================

* 컴파일시 타입을 체크해 주는 기능(compile-time type check)
* 객체의 타입 안정성을 높이고, 형변환의 번거로움을 줄여줌


    //Tv 객체만 저할 수 있는 ArrayList를 생성
    ArrayList<Tv> tvList = new ArrayList<Tv>();

    tvList.add(new Tv()); //OK
    tvList.add( new Audio()); //컴파일 에러. Tv 외에 다른 타입은 저장 불가


제네릭스의 장점
----------
*****

* 타입 안정성을 제공한다.
* 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해 진다.

