package doit.chapter04.problem017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String input = br.readLine();
      int[] array = new int[input.length()];
      for (int i = 0; i < input.length(); i++) {
        array[i] = input.charAt(i) - '0';
      }

      for (int i = 0; i < array.length; i++) {
        int max = i;
        for (int j = i + 1; j < array.length; j++) {
          if (array[j] > array[max]) {
            max = j;
          }
        }
        if (array[i] < array[max]) {
          swap(array, i, max);
        }
      }

      for (int num : array) {
        bw.write(String.valueOf(num));
      }
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void swap(int[] array, int index1, int index2) {
    int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

}