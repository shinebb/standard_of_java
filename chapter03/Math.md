Math (수학 관련 클래스)
=========================

반올림 - Math.rount()
---------
*****

"실수를 소수점 첫째자리에서 반올림한 정수를 반환"  

    long result = Math.rount(4.52);  // result = 5  

    double pi = 3.141592;  
    double shortPi = Math.round(pi * 1000) / 1000.0;  
    System.out.println(shortPi);  //3.142  
    Math.round(pi * 1000) / 1000.0  
    -> Math.round(3.141592 * 1000) / 1000.0   
    -> Math.round(3142.592) / 1000.0  
    -> 3142 / 1000.0  
    -> 3.142  
  
    int 3142 / int 1000 => int 3  
    int 3142 / double 1000.0 => 3.142


