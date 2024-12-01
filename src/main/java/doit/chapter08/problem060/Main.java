package doit.chapter08.problem060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  private static final List<Edge> graph = new ArrayList<>();
  private static long[] distance;
  private static int[] earning;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int start = Integer.parseInt(inputs[1]);
      int end = Integer.parseInt(inputs[2]);
      int m = Integer.parseInt(inputs[3]);

      for (int i = 0; i < m; i++) {
        inputs = br.readLine().split(" ");
        int from = Integer.parseInt(inputs[0]);
        int to = Integer.parseInt(inputs[1]);
        int cost = Integer.parseInt(inputs[2]);
        graph.add(new Edge(from, to, cost));
      }

      earning = new int[n];
      inputs = br.readLine().split(" ");
      for (int i = 0; i < earning.length; i++) {
        earning[i] = Integer.parseInt(inputs[i]);
      }

      String result = solution(start, end, n);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int start, int end, int n) {
    distance = new long[n];
    Arrays.fill(distance, Long.MIN_VALUE);
    distance[start] = earning[start];

    for (int i = 0; i < n - 1; i++) {
      graph.forEach(Main::updateDistance);
    }

    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    for (Edge edge : graph) {
      if (canUpdateDistance(edge)) {
        queue.add(edge.to);
      }
    }

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      if (visited[now]) {
        continue;
      }
      visited[now] = true;

      for (Edge edge : graph) {
        if (edge.from == now && !visited[edge.to]) {
          queue.add(edge.to);
        }
      }
    }

    if (distance[end] == Long.MIN_VALUE) {
      return "gg";
    } else if (visited[end]) {
      return "Gee";
    } else {
      return String.valueOf(distance[end]);
    }
  }

  private static void updateDistance(Edge edge) {
    if (canUpdateDistance(edge)) {
      distance[edge.to] = distance[edge.from] - edge.cost + earning[edge.to];
    }
  }

  private static boolean canUpdateDistance(Edge edge) {
    return distance[edge.from] != Long.MIN_VALUE && distance[edge.to] < distance[edge.from] - edge.cost + earning[edge.to];
  }

  private static class Edge {

    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

  }

}