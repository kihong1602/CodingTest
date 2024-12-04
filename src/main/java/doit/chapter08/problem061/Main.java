package doit.chapter08.problem061;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static final int INF = 10_000_001;
  private static int[][] distance;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      distance = new int[n + 1][n + 1];
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          distance[i][j] = i == j ? 0 : INF;
        }
      }

      for (int i = 0; i < m; i++) {
        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);
        int cost = Integer.parseInt(inputs[2]);
        distance[start][end] = Math.min(distance[start][end], cost);
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
          distance[s][e] = Math.min(distance[s][e], distance[s][k] + distance[k][e]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        int value = distance[i][j] == INF ? 0 : distance[i][j];
        sb.append(value).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}