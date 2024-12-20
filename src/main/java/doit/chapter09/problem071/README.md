# Problem 071

> BOJ 2042 구간 합 구하기
> <br/>
> [링크](https://www.acmicpc.net/problem/2042)

## 문제

N개의 수가 주어지는데, 중간에 수의 변경이 빈번히 일어나고 부분 합을 구하는 문제다.

- 첫째 줄에 수의 개수 `N`, `M`, `K`이 주어진다. `M`은 수의 변경이 일어나는 횟수, `K`는 구간 합을 구하는 횟수다.
- 둘째 줄부터 `N + 1`번째 줄까지 N개의 수가 주어진다.
- `N + 2`번째 줄부터 `N + M + K + 1`번째 줄까지 세개의 정수 `a, b, c`가 주어진다.
    - a가 1인 경우 b번째 수를 c로 바꾼다.
    - a가 2인 경우 b번째 수부터 c번째 수까지의 합을 구하여 출력한다.

## 풀이

`세그먼트 트리`를 사용한다면 구간 합과 값 변경을 `O(long N)`의 시간복잡도로 처리할 수 있으므로 `세그먼트 트리`를 사용해 풀이할 것이다.

## 해결 전략

`array`: 입력으로 주어진 원본 데이터를 저장하는 배열
`tree`: 세그먼트 트리를 저장하는 배열

- `build` 메서드를 통해 세그먼트 트리를 초기화한다.
    - 리프노드는 원본 배열의 값이 저장되고, 부모 노드는 자식 노드들의 합을 저장하도록 재귀적으로 초기화한다.
- `type == 1`일때 `update`메서드를 통해 값을 변경한다.
    - 특정 인덱스의 값을 변경하고, 변경된 값이 부모노드에 반영되도록 리프노드부터 부모노드로 올라가며 값을 업데이트 한다.
- `type == 2`일때 `sum`메서드를 통해 구간합을 계산한다.
    - 구간이 노드의 범위와 겹치면 값을 반환하고, 일부만 겹칠 경우 왼쪽과 오른쪽 자식 노드로 나누어 재귀적으로 합을 구한다.