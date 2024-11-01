# Problem 020

> BOJ 2751 수 정렬하기 2
> <br/>
> [링크](https://www.acmicpc.net/problem/2751)

## 문제

간단한 배열 정렬 문제다.

## 풀이

역시 `sort()`로 풀이해도된다. 하지만 정렬에 대해 공부중이니, `병합정렬`을 통해 풀이할 것이다.

## 해결 전략

`병합정렬`방식에는 재귀호출을 사용하는 `Top-Down` 방식과 재귀호출대신 작은 배열을 점진적으로 병합해가는 `Bottom-Up`방식이 있다.<p>
`Top-Down`방식은 구현이 쉽지만 배열 크기가 클 경우 `StackOverFlow`위험이 있어 이번 풀이에는 `Bottom-Up`방식을 사용할 것이다.

1. **정렬 배열 준비**:
    - 정렬 결과를 임시로 저장할 배열 `sorted`를 준비한다.

2. **배열 분할과 병합**:
    - 이중 `for`문을 사용해 배열을 작은 단위부터 점진적으로 병합해나간다.
    - `size`를 1부터 시작해 2배씩 키워가면서 배열 전체가 정렬될 때까지 반복한다.
    - 내부 반복문은 병합할 부분 배열의 **시작 위치** `start`를 설정하며, `start`는 각 단계마다 `size * 2`씩 증가한다.
    - 중간 지점 `mid`와 끝 지점 `end`를 설정하는 데, `Math.min()`을 사용해 배열의 범위를 초과하지 않도록 조절한다.

3. **병합 과정**:
    - `merge()` 메서드를 통해 두 부분 배열을 병합한다.
        - `left`와 `right`는 각 부분 배열의 시작 위치, `idx`는 정렬된 결과를 저장할 `sorted`의 인덱스이다.
    - 첫 번째 `while`문은 `left < mid && right < end` 조건으로 왼쪽과 오른쪽 배열을 비교해 더 작은 값을 `sorted`에 저장한다.
    - 두 번째 `while`문은 오른쪽 배열이 먼저 소진된 경우에 왼쪽 배열의 나머지 값을 추가한다.
    - 세 번째 `while`문은 왼쪽 배열이 먼저 소진된 경우에 오른쪽 배열의 나머지 값을 추가한다.
    - 병합이 완료된 후, `sorted`의 내용을 기존 배열 `array`에 복사한다.

병합 정렬은 배열을 나누는 과정에 `O(NlogN)`의 시간이 소요되고, 병합하는 데 `O(N)`의 시간이 걸리므로 최종 시간 복잡도는 `O(NlogN)`이 된다.