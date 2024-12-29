package doit.chapter10.problem079;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static long[][] dp;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int testCase = Integer.parseInt(br.readLine());

      initDp();

      while (testCase-- > 0) {
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        bw.write(String.valueOf(dp[m][n]));
        bw.newLine();
      }

      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void initDp() {
    dp = new long[31][31];

    for (int i = 0; i <= 30; i++) {
      dp[i][0] = 1; // 아무것도 선택하지 않는 경우
      dp[i][i] = 1; // 동쪽 사이트와 서쪽 사이트의 수가 같은 경우
    }

    for (int i = 2; i <= 30; i++) {
      for (int j = 1; j < i; j++) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
      }
    }
  }
}