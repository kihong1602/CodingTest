package doit.chapter09.problem075;

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
  private static int maxK;
  private static int[] depth;
  private static int[][] parent;

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

      maxK = (int) (Math.log(n) / Math.log(2));
      depth = new int[n + 1];
      parent = new int[maxK + 1][n + 1];

      bfs(n);
      initParent(n);

      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);

        int result = lca(u, v);
        bw.write(result + "\n");
      }

      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void bfs(int n) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[n + 1];
    visited[1] = true;
    depth[1] = 0;
    queue.add(1);

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      for (Integer next : tree.get(now)) {
        if (!visited[next]) {
          visited[next] = true;
          depth[next] = depth[now] + 1;
          parent[0][next] = now;
          queue.add(next);
        }
      }
    }
  }

  private static void initParent(int n) {
    for (int k = 1; k <= maxK; k++) {
      for (int i = 1; i <= n; i++) {
        parent[k][i] = parent[k - 1][parent[k - 1][i]];
      }
    }
  }

  private static int lca(int u, int v) {
    if (depth[u] < depth[v]) {
      int tmp = u;
      u = v;
      v = tmp;
    }

    for (int k = maxK; k >= 0; k--) {
      if (depth[u] - depth[v] >= (1 << k)) {
        u = parent[k][u];
      }
    }

    if (u == v) {
      return u;
    }

    for (int k = maxK; k >= 0; k--) {
      if (parent[k][u] != parent[k][v]) {
        u = parent[k][u];
        v = parent[k][v];
      }
    }

    return parent[0][u];
  }

}