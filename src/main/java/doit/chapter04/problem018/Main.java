package doit.chapter04.problem018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] array = new int[size];
      String[] input = br.readLine().split(" ");
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(input[i]);
      }

      for (int i = 1; i < size; i++) {
        int value = array[i];
        int j = i - 1;

        while (j >= 0 && array[j] > value) {
          array[j + 1] = array[j];
          j--;
        }
        array[j + 1] = value;
      }

      int[] sum = new int[size];
      sum[0] = array[0];
      for (int i = 1; i < size; i++) {
        sum[i] = sum[i - 1] + array[i];
      }

      int result = 0;
      for (int value : sum) {
        result += value;
      }

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}