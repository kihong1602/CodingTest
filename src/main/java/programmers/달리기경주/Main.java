package programmers.달리기경주;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public String[] solution(String[] players, String[] callings) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < players.length; i++) {
      map.put(players[i], i);
    }

    for (String calledPlayer : callings) {
      Integer calledIndex = map.get(calledPlayer);
      String frontPlayer = players[calledIndex - 1];

      players[calledIndex - 1] = calledPlayer;
      players[calledIndex] = frontPlayer;

      map.put(calledPlayer, calledIndex - 1);
      map.put(frontPlayer, calledIndex);
    }

    return players;
  }

}