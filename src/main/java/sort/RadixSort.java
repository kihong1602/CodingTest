package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RadixSort {

  // 자릿수 만큼 Queue 생성
  // 배열의 최댓값을 찾아내서, 최댓값의 자릿수를 조회
  // 자릿수만큼 반복
  // 자릿수는 1 10 100 1000 으로 증가하도록 설정
  // 배열 인자를 1, 10, 100, ... 자릿수를 분류해 Queue에 저장
  // Queue에 값을 꺼내서 배열에 재배치
  // 루프 마지막에 place에 10을 곱해서 자릿수 증가 시킴

  public static void sort(int[] array) {
    radixSort(array);
  }

  private static void radixSort(int[] array) {
    // 1의 자리 기준으로 수를 저장할 Queue 10개를 초기화해 List에 저장
    List<Queue<Integer>> bucket = new ArrayList<>();
    for (int i = 0; i <= 9; i++) {
      bucket.add(new LinkedList<>());
    }

    // 배열의 최댓값의 자릿수 계산
    int max = getMax(array);
    int maxDigit = String.valueOf(max).length();

    int place = 1; // 자릿수 위치 (1, 10, 100, ...)
    for (int i = 0; i < maxDigit; i++) {
      // 각 Queue에 값을 분류
      for (int num : array) {
        int digit = (num / place) % 10;
        bucket.get(digit).add(num);
      }

      // Queue에서 값을 꺼내서 배열에 재배치
      int index = 0;
      for (Queue<Integer> queue : bucket) {
        while (!queue.isEmpty()) {
          array[index++] = queue.poll();
        }
      }

      // 다음 자릿수로 이동
      place *= 10;
    }
  }

  private static int getMax(int[] array) {
    int max = Integer.MIN_VALUE;
    for (int value : array) {
      max = Math.max(max, value);
    }
    return max;
  }

}