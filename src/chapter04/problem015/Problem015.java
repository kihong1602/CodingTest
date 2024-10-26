package chapter04.problem015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem015 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }

      for (int i = 0; i < array.length - 1; i++) {
        for (int j = 0; j < array.length - 1 - i; j++) {
          if (array[j] > array[j + 1]) {
            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
          }
        }
      }

      for (int value : array) {
        bw.write(value + "\n");
      }

    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}