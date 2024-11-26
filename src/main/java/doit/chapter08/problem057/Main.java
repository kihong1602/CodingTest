package doit.chapter08.problem057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  private static final List<List<Edge>> graph = new ArrayList<>();
  private static int[] cost;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());

      init(n);

      for (int i = 0; i < m; i++) {
        String[] inputs = br.readLine().split(" ");
        int from = Integer.parseInt(inputs[0]);
        int to = Integer.parseInt(inputs[1]);
        int weight = Integer.parseInt(inputs[2]);
        graph.get(from).add(new Edge(to, weight));
      }

      String[] inputs = br.readLine().split(" ");
      int start = Integer.parseInt(inputs[0]);
      int end = Integer.parseInt(inputs[1]);

      int result = solution(start, end);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void init(int n) {
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    cost = new int[n + 1];
    Arrays.fill(cost, Integer.MAX_VALUE);
  }

  private static int solution(int start, int end) {
    cost[start] = 0;
    Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
    queue.add(new Edge(start, cost[start]));

    while (!queue.isEmpty()) {
      Edge now = queue.poll();

      if (now.cost > cost[now.node]) {
        continue;
      }

      for (Edge next : graph.get(now.node)) {
        int nextCost = now.cost + next.cost;
        if (nextCost < cost[next.node]) {
          cost[next.node] = nextCost;
          queue.add(new Edge(next.node, nextCost));
        }
      }

    }
    return cost[end];
  }

  private static class Edge {

    int node;
    int cost;

    public Edge(int node, int cost) {
      this.node = node;
      this.cost = cost;
    }

  }

}