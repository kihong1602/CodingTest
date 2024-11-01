package doit.chapter03.problem008;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem008 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String[] inputs = br.readLine().split(" ");
      long[] array = new long[size];
      for (int i = 0; i < inputs.length; i++) {
        array[i] = Long.parseLong(inputs[i]);
      }

      Arrays.sort(array);

      int result = 0;

      for (int i = 0; i < size; i++) {
        long target = array[i];
        int start = 0;
        int end = size - 1;
        while (start < end) {
          if (start == i) {
            start++;
            continue;
          }
          if (end == i) {
            end--;
            continue;
          }

          long sum = array[start] + array[end];
          if (sum == target) {
            result++;
            break;
          } else if (sum < target) {
            start++;
          } else {
            end--;
          }
        }
      }
      bw.write(String.valueOf(result));
      bw.flush();

    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}