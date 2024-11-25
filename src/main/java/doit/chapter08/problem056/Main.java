package doit.chapter08.problem056;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  private static final List<List<Edge>> graph = new ArrayList<>();
  
  private static int[] distance;

  private static boolean[] visited;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);

      int start = Integer.parseInt(br.readLine());

      init(n, start);

      for (int i = 0; i < m; i++) {
        inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        int w = Integer.parseInt(inputs[2]);
        graph.get(u).add(new Edge(v, w));
      }

      String result = solution(start);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void init(int n, int start) {
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    visited = new boolean[n + 1];
    distance = new int[n + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[start] = 0;
  }

  private static String solution(int start) {
    Queue<Edge> queue = new PriorityQueue<>();
    queue.add(new Edge(start, distance[start]));

    while (!queue.isEmpty()) {
      Edge now = queue.poll();
      if (visited[now.node]) {
        continue;
      }
      visited[now.node] = true;

      for (Edge edge : graph.get(now.node)) {
        int next = edge.node;
        int weight = edge.weight;
        if (isShorterPath(next, now, weight)) {
          distance[next] = distance[now.node] + weight;
          queue.add(new Edge(next, distance[next]));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < distance.length; i++) {
      sb.append(visited[i] ? distance[i] : "INF").append("\n");
    }
    return sb.toString();
  }

  private static boolean isShorterPath(int next, Edge now, int weight) {
    return distance[next] > distance[now.node] + weight;
  }


  private static class Edge implements Comparable<Edge> {

    int node;
    int weight;

    public Edge(int node, int weight) {
      this.node = node;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }

}