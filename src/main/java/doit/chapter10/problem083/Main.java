package doit.chapter10.problem083;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      long mod = 1_000_000_000;
      long[] dp = new long[Math.max(3, n + 1)];

      dp[1] = 0;
      dp[2] = 1;

      for (int i = 3; i <= n; i++) {
        dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % mod;
      }

      bw.write(String.valueOf(dp[n]));
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}