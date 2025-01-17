# Programmers 20

> level2 의상
> <br/>
> [링크](https://school.programmers.co.kr/learn/courses/30/lessons/42578)

## 문제

코니는 매일 다른 옷을 조합해 입는 것을 좋아한다.

각 종류별로 1가지의 의상만 착용할 수 있고, 착용한 의상의 일부가 겹치더라도 다른 ㅡ이상이 겹치지 않거나, 추가로 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산한다.

의상들이 담긴 2차원 배열 `clothes`가 주어졌을 때, 서로 다른 옷의 조합의 수를 구하는 문제다.

## 풀이

`HashMap`과 조합을 사용하여 풀이할 수 있는 문제다.

`HashMap`으로 각 의상 타입별로 갯수를 카운트 하고, 타입마다 의상개수 + 1(해당 타입을 입지 않을 경우 포함)을 곱해 경우의 수를 계산한다.

아무것도 착용하지 않는 경우는 제외해야 하므로 마지막에 1을 빼야 한다.

## 해결 전략

- `HashMap`에 `clothes`의 데이터를 저장한다.
    - Key: 의상 종류, Value: 타입별 의상 갯수
- `HashMap`의 value를 순회하며 결과값에 `value + 1`을 곱해 모든 경우의 수를 구한다.
- 마지막으로 아무것도 착용하지 않은 경우인 1을 빼서 결과값을 반환한다.