package doit.chapter08.problem063;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  private static final int INF = 100_000;
  private static int[][] distance;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);

      distance = new int[n + 1][n + 1];
      for (int i = 1; i <= n; i++) {
        Arrays.fill(distance[i], INF);
        distance[i][i] = 0;
      }

      for (int i = 0; i < m; i++) {
        inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        distance[a][b] = distance[b][a] = 1;
      }

      String result = solution(n);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int n) {
    for (int k = 1; k <= n; k++) {
      for (int s = 1; s <= n; s++) {
        for (int e = 1; e <= n; e++) {
          if (distance[s][e] > distance[s][k] + distance[k][e]) {
            distance[s][e] = distance[s][k] + distance[k][e];
          }
        }
      }
    }

    int min = Integer.MAX_VALUE;
    int result = 0;

    for (int i = 1; i <= n; i++) {
      int sum = 0;
      for (int j = 1; j <= n; j++) {
        sum += distance[i][j];
      }

      if (sum < min) {
        min = sum;
        result = i;
      }
    }

    return String.valueOf(result);
  }

}