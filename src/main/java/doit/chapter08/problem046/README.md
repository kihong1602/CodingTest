# Problem 046

> BOJ 18352 특정 거리의 도시 찾기
> <br/>
> [링크](https://www.acmicpc.net/problem/18352)

## 문제

N개의 도시와 M개의 단방향 도로가 있다. 특정도시 X로부터 출발해 최단거리가 K인 도시들의 번호를 구하는 문제다.

## 풀이

`BFS`를 사용해 모든 도시에 대한 최단거리를 계산한 뒤, 거리가 K인 도시만 출력한다.
<br/>
`인접 리스트`로 그래프를 구성하고, 방문 여부와 거리는 `distance` 배열로 관리한다.

## 해결 전략

- 인접리스트로 도시간 도로 정보를 저장한다.
- `distance` 배열을 -1로 초기화해 방문 여부를 관리한다.
- 시작도시 X에서 `BFS`를 수행해 최단 거리를 갱신한다.
- 현재거리 +1로 다음 도시를 방문
- `distance` 배열에서 거리가 K인 도시를 리스트에 추가하고, 없다면 -1을 출력한다.
- 리스트에 담긴 결과를 오름차순으로 정렬한 뒤 출력한다.