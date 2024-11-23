package doit.chapter04.problem020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static int[] sorted;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }

      mergeSort(array);

      for (int number : array) {
        bw.write(String.valueOf(number));
        bw.newLine();
      }
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
    int left = start;
    int right = mid;
    int idx = start;

    while (left < mid && right < end) {
      sorted[idx++] = array[left] < array[right] ? array[left++] : array[right++];
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