package chapter04.problem019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem019 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int arraySize = Integer.parseInt(size[0]);
      int K = Integer.parseInt(size[1]) - 1;

      String[] inputs = br.readLine().split(" ");
      int[] array = new int[arraySize];
      for (int i = 0; i < arraySize; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }
      int result = quickSelect(array, K);

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static int quickSelect(int[] array, int K) {
    return quickSelect(array, 0, array.length - 1, K);
  }

  private static int quickSelect(int[] array, int start, int end, int K) {
    if (start == end) {
      // 배열의 끝까지 범위가 좁혀졌으므로 반환
      return array[start];
    }

    int pivot = pivotSelect(array, start, end); // K번째 수를 찾기 위한 pivot 설정. pivotSelect 완료시 pivot 정렬 확정

    if (K == pivot) { // pivot == K (정렬된 pivot Index == K 라면)
      return array[K];
    } else if (K < pivot) { // 이후로 K 와 pivot 비교후 pivot 제외한 범위를 탐색
      return quickSelect(array, start, pivot - 1, K);
    } else {
      return quickSelect(array, pivot + 1, end, K);
    }
  }

  private static int pivotSelect(int[] array, int left, int right) {
    int lo = left;
    int hi = right;
    int pivot = array[(left + right) / 2];

    while (lo <= hi) {
      while (array[lo] < pivot) {
        lo++;
      }
      while (array[hi] > pivot) {
        hi--;
      }

      if (lo <= hi) {
        swap(array, lo, hi);
        lo++;
        hi--;
      }
    }
    return lo;
  }

  private static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}