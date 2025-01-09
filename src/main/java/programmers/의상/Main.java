package programmers.의상;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public int solution(String[][] clothes) {
    int total = 1;
    Map<String, Integer> map = new HashMap<>();
    for (String[] clothe : clothes) {
      String type = clothe[1];
      map.put(type, map.getOrDefault(type, 0) + 1);
    }

    for (Integer value : map.values()) {
      total *= (value + 1);
    }

    return total - 1;
  }
}