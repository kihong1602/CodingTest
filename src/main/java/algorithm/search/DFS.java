package algorithm.search;

import java.util.List;

public class DFS {

  public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
    visited[node] = true;

    for (int next : graph.get(node)) {
      if (!visited[next]) {
        dfs(next, graph, visited);
      }
    }
  }

}