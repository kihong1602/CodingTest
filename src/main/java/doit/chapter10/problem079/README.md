# Problem 079

> BOJ 1010 다리놓기
> <br/>
> [링크](https://www.acmicpc.net/problem/1010)

## 문제

한 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다.

강을 건너기 위해선 다리가 필요하다. 강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 하는데, 강의 서쪽에는 N개의 사이트가, 동쪽에는 M개의 사이트가 있다.

서쪽과 동쪽의 사이트를 다리로 연결하려고 하는데, 한 사이트에는 한 개의 다리만 연결될 수 있다.

서쪽 사이트의 개수 만큼 다리를 지으려고 하는데, 다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 문제다.

## 풀이

N개의 사이트를 M개의 사이트에 연결할 때, 다리는 서로 겹칠 수 없고 `N <= M`이라는 조건을 만족한다. 따라서 이 문제는 조합 문제로 변환할 수 있다.

즉 M개의 사이트 중 N개의 사이트를 선택하는 경우의수 `mCn`을 계산하면 된다.

## 해결 전략

- 값의 범위만큼 `DP`배열을 초기화 한 후, 초기 값을 설정해준다.
    - `dp[i][0] = 1` 아무것도 선택하지 않는 경우의 수는 1이다.
    - `dp[i][i] = 1` M과 N이 같을 경우의 수는 1이다.
- `2 <= i <=n`, `1 <= j < i`까지 반복하며 배열을 채운다.
    - `dp[i][j] = dp[i-1][j-1] + dp[i-1][j]`
- 테스트 케이스 값을 입력받고, 각 테스트 케이스마다 `N`과 `M`을 입력받아 `dp[M][N]`을 출력한다.