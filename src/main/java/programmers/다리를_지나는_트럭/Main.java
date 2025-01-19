package programmers.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int time = 0;
    int currentWeight = 0;
    int index = 0;

    Queue<Integer> bridge = new LinkedList<>();
    for (int i = 0; i < bridge_length; i++) {
      bridge.add(0);
    }

    while (!bridge.isEmpty()) {
      time++;
      currentWeight -= bridge.poll();

      if (index < truck_weights.length) {
        int truck = truck_weights[index];
        if (currentWeight + truck <= weight) {
          bridge.add(truck);
          currentWeight += truck;
          index++;
        } else {
          bridge.add(0);
        }
      }
    }

    return time;
  }
}