# Problem 022

> BOJ 10989 수 정렬하기 3
> <br/>
> [링크](https://www.acmicpc.net/problem/10989)

## 문제

배열을 정렬하는 문제다.

## 풀이

`sort()`를 사용하면 쉽게 풀이할 수 있지만, 이번엔 `카운팅정렬`을 구현하여 풀이할 것이다.

## 해결 전략

- 문제에서 주어진 수의 최대값을 크기로 가지는 `count`배열을 생성한다.
- 입력된 배열을 순회하며 배열 인자를 `count`의 인덱스로 삼아 증가시킨다.
- `count`배열을 다시 순회하며 값이 나타나는 횟수 만큼 원본 배열에 오름차순으로 채운다.

`카운팅정렬`은 배열을 채우며 `O(N)`, 카운트 배열을 순회하며 정렬된 배열을 채우며 `O(K)`이 소요되므로 최종 시간복잡도는 `O(N+K)`다.