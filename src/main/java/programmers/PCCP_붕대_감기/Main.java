package programmers.PCCP_붕대_감기;

public class Main {

  public int solution(int[] bandage, int health, int[][] attacks) {
    int t = bandage[0];
    int x = bandage[1];
    int y = bandage[2];
    int current = health;
    int currentTime = 0;
    int attackIndex = 0;

    int lastAttackTime = attacks[attacks.length - 1][0];

    for (int i = 1; i <= lastAttackTime; i++) {
      if (attackIndex < attacks.length && attacks[attackIndex][0] == i) {
        current -= attacks[attackIndex][1];
        attackIndex++;
        currentTime = 0;
      } else {
        current += x;
        currentTime++;
        if (currentTime == t) {
          current += y;
          currentTime = 0;
        }
        current = Math.min(current, health);
      }
      
      if (current <= 0) {
        return -1;
      }
    }

    return current;
  }

}