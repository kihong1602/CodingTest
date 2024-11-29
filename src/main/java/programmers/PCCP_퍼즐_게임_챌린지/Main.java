package programmers.PCCP_퍼즐_게임_챌린지;

public class Main {

  public int solution(int[] diffs, int[] times, long limit) {
    int low = 1;
    int high = 100_000;
    int level = high;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (canSolveAll(diffs, times, limit, mid)) {
        level = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return level;
  }

  private boolean canSolveAll(int[] diffs, int[] times, long limit, int level) {
    long resolved = 0;
    int prev = 0;

    for (int i = 0; i < diffs.length; i++) {
      int diff = diffs[i];
      int current = times[i];

      if (diff <= level) {
        resolved += current;
      } else {
        int repeat = diff - level;
        resolved += repeat * (current + prev) + current;
      }

      if (resolved > limit) {
        return false;
      }

      prev = current;
    }
    return true;
  }

}