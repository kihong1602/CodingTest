# Problem 074

> 백준 11437 LCA
> <br/>
> [링크](https://www.acmicpc.net/problem/11437)

## 문제

N개의 정점으로 이루어진 트리가 주어진다. 트리의 각 정점은 1 ~ N번까지 번호가 새겨져있고, 루트는 1번이다.

두 노드 쌍이 주어졌을 때, 두 노드의 가장 가까운 공통 조상이 몇 번인지 출력하는 문제다.

## 풀이

문제 이름과 같이 `최소 공통 조상`을 찾는 문제다.

## 해결 전략

- 루트 노드에서 `BFS`를 통해 각 노드의 부모노드와 깊이를 `nodes`에 저장한다.
- M개의 값 쌍을 가지고 최소 공통 조상을 찾는 `lca`메서드를 수행한다.
    - a, b 중 더 깊은 depth를 가진 쪽을 a 로 swap 한다.
    - a.depth == b.depth가 될 때까지 a의 부모노드를 찾아 갱신해진다.
    - a == b 가 될 때 까지 각 노드의 부모 노드로 값을 갱신한다.