package doit.chapter08.problem062;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static int[][] distance;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      distance = new int[n][n];
      for (int i = 0; i < n; i++) {
        String[] inputs = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
          distance[i][j] = Integer.parseInt(inputs[j]);
        }
      }

      String result = solution(n);
      bw.write(result);
      bw.flush();

    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int n) {
    for (int k = 0; k < n; k++) {
      for (int s = 0; s < n; s++) {
        for (int e = 0; e < n; e++) {
          if (distance[s][k] == 1 && distance[k][e] == 1) {
            distance[s][e] = 1;
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(distance[i][j]).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}