package Chapter03.problem006;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem006 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int target = Integer.parseInt(br.readLine());

      int sum = 1;
      int result = 1;

      int start = 1, end = 1;

      while (end < target) {
        if (sum == target) {
          result++;
          sum += ++end;
        }
        if (sum > target) {
          sum -= start++;
        }
        if (sum < target) {
          sum += ++end;
        }
      }

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}