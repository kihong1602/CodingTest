package doit.chapter10.problem080;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int m = Integer.parseInt(br.readLine());
      int[] colors = new int[m];
      String[] inputs = br.readLine().split(" ");
      int total = 0;
      for (int i = 0; i < m; i++) {
        colors[i] = Integer.parseInt(inputs[i]);
        total += colors[i];
      }

      int k = Integer.parseInt(br.readLine());

      double result = solution(colors, total, k);

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static double solution(int[] colors, int total, int K) {
    double result = 0.0;

    for (int color : colors) {
      if (color < K) {
        continue;
      }
      double prob = 1.0;
      for (int i = 0; i < K; i++) {
        prob *= (double) (color - i) / (total - i);
      }

      result += prob;
    }
    return result;
  }

}