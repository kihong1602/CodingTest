package doit.chapter05.problem025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem025 {

  private static List<List<Integer>> graph = new ArrayList<>();

  private static boolean[] visited;

  private static boolean arrive;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int n = Integer.parseInt(size[0]);
      int m = Integer.parseInt(size[1]);

      visited = new boolean[n];
      for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < m; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);

        graph.get(u).add(v);
        graph.get(v).add(u);
      }

      for (int node = 0; node < n; node++) {
        dfs(node, 1);
        if (arrive) {
          break;
        }
      }

      bw.write(arrive ? "1" : "0");
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void dfs(int node, int depth) {
    if (depth == 5 || arrive) {
      arrive = true;
      return;
    }

    visited[node] = true;
    for (Integer next : graph.get(node)) {
      if (!visited[next]) {
        dfs(next, depth + 1);
      }
    }
    visited[node] = false;
  }
}