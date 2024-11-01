package algorithm.search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

  public static void bfs(int startNode, List<List<Integer>> graph, boolean[] visited) {
    visited[startNode] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startNode);

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