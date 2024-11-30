package doit.chapter08.problem059;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  private static final long INF = Long.MAX_VALUE;
  private static final List<Edge> graph = new ArrayList<>();
  private static long[] distance;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);
      for (int i = 0; i < m; i++) {
        inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);
        int time = Integer.parseInt(inputs[2]);
        graph.add(new Edge(start, end, time));
      }

      String result = solution(n);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int n) {
    distance = new long[n + 1];
    Arrays.fill(distance, INF);
    distance[1] = 0;

    if (runBellmanFord(n)) {
      return "-1";
    }

    return buildResult(n);
  }

  private static boolean runBellmanFord(int n) {
    for (int i = 1; i < n; i++) {
      for (Edge edge : graph) {
        if (isBellmanFord(edge)) {
          distance[edge.end] = distance[edge.start] + edge.time;
        }
      }
    }

    for (Edge edge : graph) {
      if (isBellmanFord(edge)) {
        return true;
      }
    }

    return false;
  }

  private static boolean isBellmanFord(Edge edge) {
    return distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.time;
  }

  private static String buildResult(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= n; i++) {
      sb.append(distance[i] == INF ? -1 : distance[i]).append("\n");
    }
    return sb.toString();
  }

  private static class Edge {

    int start;
    int end;
    int time;

    public Edge(int start, int end, int time) {
      this.start = start;
      this.end = end;
      this.time = time;
    }
  }

}