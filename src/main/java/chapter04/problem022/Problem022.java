package chapter04.problem022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem022 {

  private static final int MAX_VALUE = 10000;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }

      countingSort(array);

      for (int value : array) {
        bw.write(String.valueOf(value));
        bw.newLine();
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }


  private static void countingSort(int[] array) {
    int[] count = new int[MAX_VALUE + 1];
    for (int value : array) {
      count[value]++;
    }

    int idx = 0;
    for (int i = 1; i < count.length; i++) {
      int size = count[i];
      while (size-- > 0) {
        array[idx++] = i;
      }
    }
  }

}