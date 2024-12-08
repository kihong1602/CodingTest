package doit.chapter08.problem064;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

  private static final List<Edge> graph = new ArrayList<>();
  private static int[] union;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);

      union = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        union[i] = i;
      }

      for (int i = 0; i < m; i++) {
        inputs = br.readLine().split(" ");
        int from = Integer.parseInt(inputs[0]);
        int to = Integer.parseInt(inputs[1]);
        int weight = Integer.parseInt(inputs[2]);
        graph.add(new Edge(from, to, weight));
      }

      graph.sort(Comparator.naturalOrder());

      long result = 0;
      int count = 0;
      for (Edge edge : graph) {
        if (find(edge.from) != find(edge.to)) {
          union(edge.from, edge.to);
          result += edge.weight;
          count++;
          if (count == n - 1) {
            break;
          }
        }
      }
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static int find(int value) {
    if (union[value] == value) {
      return value;
    }
    return union[value] = find(union[value]);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      union[b] = a;
    }
  }

  private static class Edge implements Comparable<Edge> {

    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
      return this.weight - other.weight;
    }

  }

}