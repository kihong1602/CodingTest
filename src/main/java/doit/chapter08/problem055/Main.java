package doit.chapter08.problem055;

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

  private static final List<List<Edge>> graph = new ArrayList<>();
  private static final List<List<Edge>> reverse = new ArrayList<>();

  private static int[] degree;
  private static int[] maxTime;

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
        int time = Integer.parseInt(inputs[2]);

        graph.get(from).add(new Edge(to, time));
        reverse.get(to).add(new Edge(from, time));
        degree[to]++;
      }

      String[] inputs = br.readLine().split(" ");
      int start = Integer.parseInt(inputs[0]);
      int end = Integer.parseInt(inputs[1]);

      int maxTime = findMaxTime(start, end);

      int maxRouteCount = findMaxRouteCount(end);

      bw.write(maxTime + "\n" + maxRouteCount);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void init(int n) {
    degree = new int[n + 1];
    maxTime = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
      reverse.add(new ArrayList<>());
    }
  }

  private static int findMaxTime(int start, int end) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      Integer now = queue.poll();

      for (Edge edge : graph.get(now)) {
        int next = edge.to;
        int time = edge.time;

        maxTime[next] = Math.max(maxTime[next], maxTime[now] + time);
        degree[next]--;
        if (degree[next] == 0) {
          queue.add(next);
        }
      }
    }
    return maxTime[end];
  }

  private static int findMaxRouteCount(int end) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(end);
    boolean[] visited = new boolean[degree.length];
    visited[end] = true;

    int count = 0;
    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      for (Edge edge : reverse.get(now)) {
        int prev = edge.to;
        int time = edge.time;

        if (maxTime[prev] + time == maxTime[now]) {
          count++;
          if (!visited[prev]) {
            visited[prev] = true;
            queue.add(prev);
          }
        }
      }
    }

    return count;
  }

  private static class Edge {

    int to;
    int time;

    public Edge(int to, int time) {
      this.to = to;
      this.time = time;
    }
  }

}