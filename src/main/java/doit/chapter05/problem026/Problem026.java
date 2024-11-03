package doit.chapter05.problem026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem026 {

  private static final List<List<Integer>> graph = new ArrayList<>();

  private static final StringBuilder sb = new StringBuilder();

  private static boolean[] visited;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

      String[] size = br.readLine().split(" ");
      int n = Integer.parseInt(size[0]);
      int m = Integer.parseInt(size[1]);
      int start = Integer.parseInt(size[2]);

      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < m; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);

        graph.get(u).add(v);
        graph.get(v).add(u);
      }

      for (List<Integer> nodes : graph) {
        nodes.sort(Comparator.naturalOrder());
      }

      visited = new boolean[n + 1];
      dfs(start);

      sb.append("\n");

      visited = new boolean[n + 1];
      bfs(start);

      bw.write(sb.toString());
      bw.flush();

    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void dfs(int node) {
    visited[node] = true;
    sb.append(node).append(" ");

    for (Integer next : graph.get(node)) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  private static void bfs(int node) {
    visited[node] = true;
    sb.append(node).append(" ");
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      Integer now = queue.poll();

      for (Integer next : graph.get(now)) {
        if (!visited[next]) {
          visited[next] = true;
          sb.append(next).append(" ");
          queue.add(next);
        }
      }
    }
  }

}