package doit.chapter10.problem082;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static final int MAX = 1_000_000_000;
  private static int[][] dp;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);
      int k = Integer.parseInt(inputs[2]);

      dp = new int[n + 1][m + 1];
      for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {

          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = Math.min(dp[i - 1][j] + dp[i][j - 1], MAX);
          }

        }
      }

      String result = k > dp[n][m] ? "-1" : findK(n, m, k);

      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String findK(int n, int m, int k) {
    StringBuilder sb = new StringBuilder();

    while (n > 0 && m > 0) {
      if (k <= dp[n - 1][m]) {
        sb.append('a');
        n--;
      } else {
        sb.append('z');
        k -= dp[n - 1][m];
        m--;
      }
    }

    if (n > 0) {
      sb.append("a".repeat(n));
    }
    if (m > 0) {
      sb.append("z".repeat(m));
    }

    return sb.toString();
  }

}