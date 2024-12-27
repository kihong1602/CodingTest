package programmers.귤고르기;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public int solution(int k, int[] tangerine) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int size : tangerine) {
      map.put(size, map.getOrDefault(size, 0) + 1);
    }

    List<Integer> list = map.values()
                            .stream()
                            .sorted(Comparator.reverseOrder())
                            .toList();

    int result = 0;
    int count = 0;
    for (Integer value : list) {
      count += value;
      result++;
      if (count >= k) {
        break;
      }
    }

    return result;
  }
}