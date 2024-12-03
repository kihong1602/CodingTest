package programmers.KAKAO_가장많이받은선물;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public int solution(String[] friends, String[] gifts) {
    Map<String, Integer> giftCount = new HashMap<>();
    Map<String, Integer> giftLog = new HashMap<>();

    for (String name : friends) {
      giftCount.put(name, 0);
    }

    for (String gift : gifts) {
      String[] split = gift.split(" ");
      String giver = split[0];
      String receiver = split[1];

      String logKey = createLogKey(giver, receiver);
      giftLog.put(logKey, giftLog.getOrDefault(logKey, 0) + 1);

      giftCount.put(giver, giftCount.get(giver) + 1);
      giftCount.put(receiver, giftCount.get(receiver) - 1);
    }

    Map<String, Integer> nextMonths = new HashMap<>();
    for (String name : friends) {
      nextMonths.put(name, 0);
    }

    for (int i = 0; i < friends.length; i++) {
      for (int j = i + 1; j < friends.length; j++) {
        String A = friends[i];
        String B = friends[j];
        int AtoB = giftLog.getOrDefault(createLogKey(A, B), 0);
        int BtoA = giftLog.getOrDefault(createLogKey(B, A), 0);

        if (AtoB < BtoA) {
          nextMonths.put(B, nextMonths.get(B) + 1);
        } else if (AtoB > BtoA) {
          nextMonths.put(A, nextMonths.get(A) + 1);
        } else {
          int ACount = giftCount.get(A);
          int BCount = giftCount.get(B);

          if (ACount < BCount) {
            nextMonths.put(B, nextMonths.get(B) + 1);
          } else if (ACount > BCount) {
            nextMonths.put(A, nextMonths.get(A) + 1);
          }
        }

      }
    }

    int max = 0;
    for (Integer value : nextMonths.values()) {
      max = Math.max(max, value);
    }
    return max;
  }

  private String createLogKey(String A, String B) {
    return A + "-" + B;
  }
}