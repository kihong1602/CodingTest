package doit.chapter09.problem067;

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
  private static boolean[] visited;
  private static int[] parent;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      parent = new int[n + 1];
      visited = new boolean[n + 1];
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

      String result = solution();
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution() {
    bfs();

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i < parent.length; i++) {
      sb.append(parent[i]).append("\n");
    }

    return sb.toString();
  }

  private static void bfs() {
    final int ROOT = 1;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(ROOT);
    visited[ROOT] = true;

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      for (Integer next : tree.get(now)) {
        if (!visited[next]) {
          parent[next] = now;
          visited[next] = true;
          queue.add(next);
        }
      }
    }
  }

}