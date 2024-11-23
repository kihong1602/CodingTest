package doit.chapter05.problem023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main_DFS {

  private static List<List<Integer>> graph;

  private static boolean[] visited;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int N = Integer.parseInt(size[0]);
      int M = Integer.parseInt(size[1]);

      graph = new ArrayList<>();
      visited = new boolean[N + 1];

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
          dfs(node);
        }
      }

      bw.write(String.valueOf(count));
      bw.flush();

    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void dfs(int node) {
    visited[node] = true;

    for (int next : graph.get(node)) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

}