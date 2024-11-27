package doit.chapter08.problem058;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  private static final List<List<Edge>> graph = new ArrayList<>();
  private static final List<Queue<Integer>> distance = new ArrayList<>();

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);
      int k = Integer.parseInt(inputs[2]);

      init(n);

      for (int i = 0; i < m; i++) {
        inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        int w = Integer.parseInt(inputs[2]);
        graph.get(u).add(new Edge(v, w));
      }

      String result = solution(k);

      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int k) {
    Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
    queue.add(new Edge(1, 0));

    while (!queue.isEmpty()) {
      Edge current = queue.poll();
      int now = current.to;
      int cost = current.cost;

      if (distance.get(now).size() >= k && distance.get(now).peek() <= cost) {
        continue;
      }

      distance.get(now).add(cost);
      if (distance.get(now).size() > k) {
        distance.get(now).poll();
      }

      for (Edge next : graph.get(now)) {
        queue.add(new Edge(next.to, cost + next.cost));
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int node = 1; node < distance.size(); node++) {
      if (distance.get(node).size() < k) {
        sb.append(-1);
      } else {
        sb.append(distance.get(node).peek());
      }
      sb.append("\n");
    }

    return sb.toString();
  }

  private static void init(int n) {
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
      distance.add(new PriorityQueue<>(Comparator.reverseOrder()));
    }
  }

  private static class Edge {

    int to;
    int cost;

    public Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }

  }
}