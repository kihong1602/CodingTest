package programmers.같은숫자는싫어;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public int[] solution(int[] arr) {
    Deque<Integer> deque = new ArrayDeque<>();

    for (int number : arr) {
      if (!deque.isEmpty() && deque.peekLast().equals(number)) {
        continue;
      }
      deque.addLast(number);
    }

    int[] result = new int[deque.size()];
    int idx = 0;
    for (Integer number : deque) {
      result[idx++] = number;
    }

    return result;
  }
}