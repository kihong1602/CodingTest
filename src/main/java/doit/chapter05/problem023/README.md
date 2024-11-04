# Problem 023

> BOJ 11724 연결 요소의 개수
> <br/>
> [링크](https://www.acmicpc.net/problem/11724)

## 문제

방향이 없는 그래프가 주어졌을때, 연결되어있는 요소의 개수를 구하는 문제다.

## 풀이

그래프를 탐색해야하므로, `깊이우선탐색(DFS)` 또는 `너비우선탐색(BFS)`로 풀이할 수 있다.
<br/>
이번 문제는 두 방식을 모두 사용해 풀이할 것이다.

## 해결 전략

### 공통 로직

- 입력받은 간선 정보를 토대로 `List<List<Integer>>`로 구현된 인접리스트에 저장한다.
- 특정 노드를 방문했는지 체크하기 위한 배열 `visited`를 초기화한다.
- 방문하지 않은 노드를 방문할 때마다 `count`를 증가시켜 연결 요소의 개수를 구한다.

### DFS

- 재귀호출을 통해 모든 인접노드를 방문하고, 방문한 노드는 `visited`에 기록해 중복 탐색을 방지한다.

### BFS

- `Queue`를 사용해 탐색을 수행한다.
- 방문하지 않은 노드를 `Queue`에 추가해 모든 인접노드를 탐색하고, 해당 노드를 `visited`에 표시해 중복탐색을 방지한다.

DFS, BFS는 각 노드(N)를 한 번씩 방문하고, 각 간선(M)을 한번씩 확인한다. 따라서 시간복잡도는 `O(N+M)`이다. 