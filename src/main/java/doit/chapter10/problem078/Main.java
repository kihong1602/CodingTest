package doit.chapter10.problem078;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static int[][] dp;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      initDp();
      int testCase = Integer.parseInt(br.readLine());
      while (testCase-- > 0) {
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        bw.write(dp[k][n] + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void initDp() {
    dp = new int[15][15];

    for (int i = 0; i < 15; i++) {
      dp[0][i] = i;
      dp[i][1] = 1;
    }

    for (int i = 1; i < 15; i++) {
      for (int j = 2; j < 15; j++) {
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
      }
    }
  }
}