package doit.chapter08.problem066;

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
  private static final int NOT_CONNECT = 0;
  private static int[] parent;
  private static int total;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      for (int a = 0; a < n; a++) {
        String input = br.readLine();
        for (int b = 0; b < n; b++) {
          char value = input.charAt(b);
          int weight = getWeight(value);
          total += weight;
          if (a == b || weight == NOT_CONNECT) {
            continue;
          }
          graph.add(new Edge(a, b, weight));
        }
      }

      String result = solution(n);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int n) {
    graph.sort(Comparator.naturalOrder());

    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    int min = 0;
    int count = 0;

    for (Edge edge : graph) {
      int a = find(edge.start);
      int b = find(edge.end);
      if (a != b) {
        union(a, b);
        min += edge.weight;
        count++;
      }
    }

    int result = count == n - 1 ? total - min : -1;
    return String.valueOf(result);
  }

  private static int find(int value) {
    if (parent[value] == value) {
      return value;
    }
    return parent[value] = find(parent[value]);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  private static int getWeight(char value) {
    if (Character.isLowerCase(value)) {
      return value - 'a' + 1;
    } else if (Character.isUpperCase(value)) {
      return value - 'A' + 27;
    } else {
      return 0;
    }
  }

  private static class Edge implements Comparable<Edge> {

    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }

  }

}
