package doit.chapter05.problem023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem023_BFS {

  private static List<List<Integer>> graph;

  private static boolean[] visited;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int N = Integer.parseInt(size[0]);
      int M = Integer.parseInt(size[1]);

      visited = new boolean[N + 1];
      graph = new ArrayList<>();
      for (int i = 0; i <= N; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < M; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);

        graph.get(u).add(v);
        graph.get(v).add(u);
      }

      int count = 0;
      for (int node = 1; node <= N; node++) {
        if (!visited[node]) {
          count++;
          bfs(node);
        }
      }

      bw.write(String.valueOf(count));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void bfs(int node) {
    visited[node] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      Integer now = queue.poll();

      for (Integer next : graph.get(now)) {
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
        }
      }
    }
  }
}