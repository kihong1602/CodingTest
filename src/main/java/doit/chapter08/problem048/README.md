# Problem 048

> BOJ 1707 이분 그래프
> <br/>
> [링크](https://www.acmicpc.net/problem/1707)

## 문제

각 집합에 속한 노드끼리 서로 인접하지 않는 두 집합으로 그래프의 노드를 나눌 수 있다면 '이분 그래프'라고 한다. 입력으로 주어지는 그래프가 이분그래프인지 여부를 판단하는 문제다.

## 풀이

그래프를 탐색하면서 인접한 노드끼리 서로 다른 색으로 칠할 수 있는지를 확인한다. 색상은 최소한의 메모리를 사용하기 위해 boolean 값을 사용해 두 가지 색(예: true, false)으로 구분한다.

`DFS`를 통해 인접 리스트를 탐색하며, 인접 노드 간의 색상이 동일한 경우 이분 그래프가 아니라고 판단한다. 탐색 중 이분 그래프가 아님이 확인되면 즉시 탐색을 중단해 효율성을 높인다.

## 해결 전략

- 그래프 입력을 인접 리스트 `graph`로 표현하고, 다음 배열을 초기화한다:
    - `visited`: 노드 방문 여부를 저장한다.
    - `color`: 노드의 색상 정보를 저장한다.
    - `flag`: 이분 그래프 여부를 나타낸다.
- 그래프의 모든 정점을 순회하며 방문하지 않은 정점에서 `DFS` 탐색을 시작한다:
    - 현재 노드와 인접한 노드의 색상이 동일하다면, `flag = false`로 설정하고 탐색을 종료한다.
    - 방문하지 않은 인접 노드는 현재 노드와 반대 색상으로 칠한 뒤, `DFS`를 재귀적으로 호출한다.
- 모든 탐색이 끝난 후 `flag` 값을 확인하여 "YES" 또는 "NO"를 반환한다.