package doit.chapter05.problem028;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem028 {

  private static final List<List<Edge>> tree = new ArrayList<>();
  private static boolean[] visited;
  private static int maxDist;
  private static int farthestNode;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());

      for (int i = 0; i <= size; i++) {
        tree.add(new ArrayList<>());
      }

      for (int i = 0; i < size; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        for (int idx = 1; idx < inputs.length - 1; idx += 2) {
          int v = Integer.parseInt(inputs[idx]);
          int dist = Integer.parseInt(inputs[idx + 1]);
          tree.get(u).add(new Edge(v, dist));
        }
      }

      visited = new boolean[size + 1];
      bfs(1);

      visited = new boolean[size + 1];
      bfs(farthestNode);
      
      bw.write(String.valueOf(maxDist));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void bfs(int start) {
    visited[start] = true;
    Queue<Edge> queue = new LinkedList<>();
    queue.add(new Edge(start, 0));

    while (!queue.isEmpty()) {
      Edge now = queue.poll();

      if (now.dist > maxDist) {
        maxDist = now.dist;
        farthestNode = now.node;
      }

      for (Edge next : tree.get(now.node)) {
        if (!visited[next.node]) {
          visited[next.node] = true;
          queue.add(new Edge(next.node, next.dist + now.dist));
        }
      }
    }
  }

  private static class Edge {

    int node;
    int dist;

    public Edge(int node, int dist) {
      this.node = node;
      this.dist = dist;
    }
  }

}