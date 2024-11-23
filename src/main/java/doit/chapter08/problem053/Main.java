package doit.chapter08.problem053;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  private static final List<List<Integer>> graph = new ArrayList<>();
  private static int[] degree;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);

      init(n);

      for (int i = 0; i < m; i++) {
        inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        graph.get(u).add(v);
        degree[v]++;
      }

      String result = solution();
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void init(int n) {
    degree = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
  }

  private static String solution() {
    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i < degree.length; i++) {
      if (degree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      sb.append(now).append(" ");

      for (Integer next : graph.get(now)) {
        degree[next]--;
        if (degree[next] == 0) {
          queue.add(next);
        }
      }
    }

    return sb.toString().trim();
  }
}