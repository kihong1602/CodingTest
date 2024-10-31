package chapter04.problem021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem021 {

  private static int[] sorted;
  private static long swapCount = 0L;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String[] inputs = br.readLine().split(" ");

      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }
      mergeSort(array);

      bw.write(String.valueOf(swapCount));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void mergeSort(int[] array) {
    sorted = new int[array.length];
    mergeSort(array, array.length);
    sorted = null;
  }

  private static void mergeSort(int[] array, int length) {
    for (int size = 1; size < length; size *= 2) {
      for (int start = 0; start < length; start += (size * 2)) {
        int mid = Math.min(start + size, length);
        int end = Math.min(start + (size * 2), length);
        merge(array, start, mid, end);
      }
    }
  }

  private static void merge(int[] array, int start, int mid, int end) {
    int idx = start;
    int left = start;
    int right = mid;

    while (left < mid && right < end) {
      if (array[left] <= array[right]) {
        sorted[idx++] = array[left++];
      } else {
        sorted[idx++] = array[right++];
        // 역순 발견시 왼쪽에 남은 개수만큼 swap 발생
        swapCount += (mid - left);
      }
    }

    while (left < mid) {
      sorted[idx++] = array[left++];
    }

    while (right < end) {
      sorted[idx++] = array[right++];
    }

    for (int i = start; i < end; i++) {
      array[i] = sorted[i];
    }
  }

}