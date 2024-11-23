package doit.chapter08.problem054;

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

  private static int[] buildTimes;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());

      init(n);

      for (int i = 1; i <= n; i++) {
        String[] inputs = br.readLine().split(" ");
        buildTimes[i] = Integer.parseInt(inputs[0]);
        for (int j = 1; j < inputs.length - 1; j++) {
          int dependency = Integer.parseInt(inputs[j]);
          graph.get(dependency).add(i);
          degree[i]++;
        }
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
    buildTimes = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
  }

  private static String solution() {
    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new LinkedList<>();

    int[] result = new int[buildTimes.length];

    for (int i = 1; i < degree.length; i++) {
      if (degree[i] == 0) {
        queue.add(i);
        result[i] = buildTimes[i];
      }
    }

    while (!queue.isEmpty()) {
      Integer now = queue.poll();

      for (Integer next : graph.get(now)) {
        result[next] = Math.max(result[next], result[now] + buildTimes[next]);
        degree[next]--;
        if (degree[next] == 0) {
          queue.add(next);
        }
      }
    }

    for (int i = 1; i < result.length; i++) {
      sb.append(result[i]).append("\n");
    }

    return sb.toString();
  }

}