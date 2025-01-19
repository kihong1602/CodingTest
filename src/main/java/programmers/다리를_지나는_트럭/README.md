# Programmers 23

> level 2 다리를 지나는 트럭
> <br/>
> [링크](https://school.programmers.co.kr/learn/courses/30/lessons/42583)

## 문제

트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 한다. 모든 트럭이 다리를 건너려면 최소 몇초가 걸리는지 알아내는 문제다.

다리에는 트럭이 최대 `bridge_lenth`대 올라갈 수 있고, 다리는 `weight` 이하 까지의 무게를 견딜 수 있다.

단, 다리에 완전히 오르지 않은 트럭의 무게는 무시한다.

다리에 올라갈 수 있는 트럭 수 `bridge_length`, 다리가 견딜 수 있는 무게 `weight`, 트럭별 무게 `truck_weights`가 주어진다.

## 풀이

`Queue`를 사용해 다리에 올라간 트럭의 무게를 계산하고, 다리가 견딜 수 있는 무게를 초과하지 않는다면 계속 다리에 트럭을 올리고, 아니라면 트럭이 나갈 때 까지 대기한다.

## 해결 전략

- 결과값을 저장할 `time`, 현재 다리에 올라간 트럭들의 무게를 저장할 `currentWeight`을 0으로 초기화한다.
- `Queue`를 생성해, `bridge_length`만큼 내부를 0으로 채워준다.
- `while`문을 사용해 모든 트럭이 다리를 건너는 최소 시간을 계산한다.
    - `time`을 증가시키고, `currentWeight`에서 `bridge.poll()`을 통해 가장 먼저 진입한 트럭의 무게만큼 감소시킨다.
    - 진입해야하는 트럭의 무게와 `currentWeight`의 합이 `weight`을 초과하지 않는다면 `bridge`에 진입할 트럭의 무게를 추가하고, `currentWeight`에도 트럭의 무게를 더한다.
    - `weight`를 초과했다면 트럭이 진입할 수 없다. `bridge`에 0을 추가해 트럭이 진입하지 못함을 표시한다.
- 결과값 `time`을 반환한다.