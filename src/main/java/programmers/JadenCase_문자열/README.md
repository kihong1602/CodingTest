# Programmers 09

> level2 JadenCase 문자열 만들기
> <br/>
> [링크](https://school.programmers.co.kr/learn/courses/30/lessons/12951)

## 문제

JadenCase란 모든 단어의 첫문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열이다.

단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 된다.

문자열이 주어졌을 때, JadenCase로 바꾼 문자열을 반환하는 문제다.

## 풀이

단순한 구현 문제다. 첫 문자가 문자인지 숫자인지 판단해 설정해준 다음, 나머지 문자를 모두 소문자 처리 해주면 된다.

## 해결 전략

- 첫 문자인지 체크하는 boolean 타입의 `isFirst`를 `true`로 초기화 하고 문자열 `s`를 char 배열로 변환해 순회한다.
- `token == ' '`이면 그대로 공백처리하고, 다음 문자는 첫번째 문자이므로 `isFirst = true` 처리한다.
- `token`이 첫 문자라면 (`isFirst == true`), `token`이 문자인지 체크한다.
    - `token`이 문자라면 대문자로 변환하고, 아니라면 그대로 작성한다.
    - `isFirst = false`를 통해 다음 문자가 첫 문자가 아님을 명시한다.
- `token`이 첫 문자가 아니라면 (`isFirst == false`), `token`을 소문자로 변환해 작성한다.
- 변환된 문자열을 반환한다.