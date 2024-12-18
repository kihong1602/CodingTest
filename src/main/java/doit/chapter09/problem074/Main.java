package doit.chapter09.problem074;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  private static final List<List<Integer>> tree = new ArrayList<>();
  private static Node[] nodes;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<>());
      }

      for (int i = 0; i < n - 1; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        tree.get(u).add(v);
        tree.get(v).add(u);
      }

      nodes = new Node[n + 1];
      bfs(n);

      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int result = lca(a, b);
        bw.write(result + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void bfs(int n) {
    boolean[] visited = new boolean[n + 1];
    nodes[1] = new Node(0, 1, 0);
    visited[1] = true;
    Queue<Node> queue = new LinkedList<>();
    queue.add(nodes[1]);

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (Integer next : tree.get(now.value)) {
        if (!visited[next]) {
          visited[next] = true;
          Node nextNode = new Node(now.value, next, now.depth + 1);
          nodes[next] = nextNode;
          queue.add(nextNode);
        }
      }
    }
  }

  private static int lca(int a, int b) {
    if (nodes[a].depth < nodes[b].depth) {
      int tmp = a;
      a = b;
      b = tmp;
    }

    while (nodes[a].depth != nodes[b].depth) {
      a = nodes[a].parent;
    }

    while (a != b) {
      a = nodes[a].parent;
      b = nodes[b].parent;
    }

    return a;
  }

  private static class Node {

    int parent;
    int value;
    int depth;

    public Node(int parent, int value, int depth) {
      this.parent = parent;
      this.value = value;
      this.depth = depth;
    }

  }

}