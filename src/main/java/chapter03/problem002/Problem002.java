package chapter03.problem002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem002 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String[] sources = br.readLine().split(" ");
      int[] array = new int[size];

      long sum = 0;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < sources.length; i++) {
        array[i] = Integer.parseInt(sources[i]);
        sum += array[i];
        max = Math.max(max, array[i]);
      }

      double result = sum * 100.0 / max / size;
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}