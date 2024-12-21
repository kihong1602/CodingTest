package doit.chapter10.problem077;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static final int DIVIDE_VALUE = 10_007;
  private static int[][] dp;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int k = Integer.parseInt(inputs[1]);

      initDp(n);

      bw.write(String.valueOf(dp[n][k]));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void initDp(int n) {
    dp = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i][1] = i;
      dp[i][0] = 1;
      dp[i][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % DIVIDE_VALUE;
      }
    }
  }

}