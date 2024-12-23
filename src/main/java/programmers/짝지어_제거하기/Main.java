package programmers.짝지어_제거하기;

import java.util.Stack;

public class Main {

  public int solution(String s) {
    Stack<Character> stack = new Stack<>();

    for (char token : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek() == token) {
        stack.pop();
      } else {
        stack.push(token);
      }
    }

    return stack.isEmpty() ? 1 : 0;
  }

}