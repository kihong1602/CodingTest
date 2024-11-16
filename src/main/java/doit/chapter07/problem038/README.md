# Problem 038

> BOJ 1456 거의 소수
> <br/>
> [링크](https://www.acmicpc.net/problem/1456)

## 문제

소수의 N제곱 수 중 A보다 크거나 같고, B보다 작거나 같은 수인 `거의 소수`가 몇개인지 출력하는 문제다.

## 풀이

`에라토스테네스의 체`를 사용해 소수를 먼저 구하고, 소수를 순회하며 N 제곱한 값이 범위안에 있는지 카운트 해준다.
입력값의 최대 범위가 10^14이므로, long 타입으로 선언해도 제곱시 오버플로우가 발생할 수 있어 보호코드가 필요하다.

## 해결 전략

- 에라토스테네스의 체를 사용한 소수 판별
    - 최댓값은 `10^14`이므로, 소수의 제곱수를 구할 때 기준이 되는 소수는 `10^7`내에 존재하므로 `10^7`까지만 소수를 구한다.
- 소수를 제곱해 거의 소수 카운팅
- 오버플로우를 대비해 소수를 곱하기 전에 `target > B / number` 조건을 통해 오버플로우 발생하지 않도록 미리 검사한다. 