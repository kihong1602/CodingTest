package doit.chapter08.problem047;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem047_Timeout {

  private static final List<List<Integer>> graph = new ArrayList<>();
  private static boolean[] visited;
  private static int[] count;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int n = Integer.parseInt(size[0]);
      int m = Integer.parseInt(size[1]);
      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < m; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        graph.get(v).add(u);
      }

      count = new int[n + 1];
      visited = new boolean[n + 1];
      int max = 0;
      for (int i = 1; i <= n; i++) {
        Arrays.fill(visited, false);
        count[i] = dfs(i);
        max = Math.max(max, count[i]);
      }

      for (int i = 1; i <= n; i++) {
        if (max == count[i]) {
          bw.write(i + " ");
        }
      }
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static int dfs(int node) {
    visited[node] = true;
    int count = 1;

    for (Integer next : graph.get(node)) {
      if (!visited[next]) {
        count += dfs(next);
      }
    }
    return count;
  }
}