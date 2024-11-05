package doit.chapter05.problem031;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem031 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int N = Integer.parseInt(br.readLine());
      int K = Integer.parseInt(br.readLine());

      long left = 1L;
      long right = K;
      long result = 0;

      while (left <= right) {
        long mid = left + (right - left) / 2;
        long count = 0;
        for (int i = 1; i <= N; i++) {
          count += Math.min(mid / i, N);
        }

        if (count < K) {
          left = mid + 1;
        } else {
          result = mid;
          right = mid - 1;
        }
      }

      bw.write(String.valueOf(result));
      bw.flush();

    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }


}