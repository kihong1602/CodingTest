package programmers.KAKAO_캐시;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public int solution(int cacheSize, String[] cities) {
    if (cacheSize == 0) {
      return cities.length * 5;
    }

    int time = 0;

    Deque<String> cache = new ArrayDeque<>();
    for (String city : cities) {
      city = city.toLowerCase();
      if (cache.contains(city)) {
        time += 1;
        cache.remove(city);
        cache.addLast(city);
      } else {
        time += 5;
        if (cache.size() >= cacheSize) {
          cache.removeFirst();
        }
        cache.addLast(city);
      }
    }

    return time;
  }

}