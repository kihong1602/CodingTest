package programmers.구명보트;

import java.util.Arrays;

public class Main {

  public int solution(int[] people, int limit) {
    int result = 0;

    Arrays.sort(people);
    int left = 0;
    int right = people.length - 1;

    while (left <= right) {
      int sum = people[left] + people[right];

      if (sum <= limit) {
        left++;
      }

      right--;
      result++;
    }

    return result;
  }

}