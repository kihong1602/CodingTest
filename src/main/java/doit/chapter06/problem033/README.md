# Problem 033

> BOJ 1715 카드 정렬하기
> <br/>
> [링크](https://www.acmicpc.net/problem/1715)

## 문제

여러 카드 묶음을 하나의 묶음으로 합치는데 필요한 최소 비교 횟수를 구하는 문제다.

## 풀이

`그리디 알고리즘`을 사용해 풀이한다. 가장 작은 두 묶음부터 차례대로 합치는 방식을 반복해 비교 횟수를 최소화 할 수 있다.

## 해결 전략

- `우선순위 큐(Priority Queue)`를 사용해 카드 묶음을 오름차순 정렬한다.
- 큐에서 가장 작은 두 값을 꺼내 합치고, 그 결과를 다시 큐에 넣는다.
    - 이 과정을 큐에 하나의 묶음만 남을 때까지 반복한다.
- 합치는 과정에서 발생한 비교횟수를 누적하여 최종 비교횟수를 구한다.