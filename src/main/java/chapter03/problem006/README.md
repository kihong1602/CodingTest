# Problem 006

> BOJ 2018 수들의 합 5
> <br/>
> [링크](https://www.acmicpc.net/problem/2018)

## 문제

주어진 수를 연속된 자연수들의 합으로 나타내는 경우의 수를 구하는 문제다.

## 풀이

모든 구간을 일일이 탐색하는 방법도 있지만, 효율적으로 풀이하기 위해선 **투 포인터 알고리즘**을 사용한다.

## 해결전략

1. 두 포인터 `start` `end`를 사용해 연속된 자연수의 구간을 설정하고, 구간의 합을 계산한다.
2. 구간 합이 목표 숫자와 같다면 경우의 수를 증가시킨다.
3. 구간 합이 목표보다 작으면 `end`를 증가시키고, 구간 합이 목표보다 크면 `start`를 증가시켜 구간을 축소시킨다.
4. 조합 가능한 모든 구간을 탐색하여, 조건을 만족하는 경우의 수를 계산한다.

투 포인터 알고리즘을 사용해 배열을 한 번만 순회하므로 시간복잡도는 `O(N)`이다.