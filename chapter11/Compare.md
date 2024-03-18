Comparator와 Comparable
=======================

* 객체 정렬에 필요한 메서드(정렬기준 제공)를 정의한 인터페이스

* Comparable : 기본 정렬 기준을 구현하는데 사용
* Comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용


    public interface Comperator {
        int compare(Object o1, Object o2); //o1, o2 두 객체를 비교(왼쪽이 크면 양수, 같으면 0, 오른쪽이 크면 음수)
        boolean equals(Object obj); //equals를 오버라이딩하라는 뜻
    }

    public interface Comparable {
        int compareTo(Object o); //주어진 객체(o)를 자신(this)과 비교
    }


* compare()와 compareTo()는 두 객체의 비교결과를 반환하도록 작성
* 왼쪽이 크면 양수, 같으면 0, 오른쪽이 크면 음수


