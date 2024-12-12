package doit.chapter09.problem068;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static final int ROOT = -1;
  private static final List<List<Integer>> tree = new ArrayList<>();
  private static boolean[] visited;
  private static int target;
  private static int leaf;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      visited = new boolean[n];
      for (int i = 0; i < n; i++) {
        tree.add(new ArrayList<>());
      }

      int root = ROOT;
      String[] inputs = br.readLine().split(" ");
      for (int node = 0; node < inputs.length; node++) {
        int parent = Integer.parseInt(inputs[node]);
        if (parent == ROOT) {
          root = node;
        } else {
          tree.get(parent).add(node);
        }
      }

      target = Integer.parseInt(br.readLine());

      if (root != target) {
        dfs(root);
      }

      bw.write(String.valueOf(leaf));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void dfs(int node) {
    visited[node] = true;

    boolean isLeaf = true;
    for (Integer next : tree.get(node)) {
      if (!visited[next] && next != target) {
        isLeaf = false;
        dfs(next);
      }
    }
    if (isLeaf) {
      leaf++;
    }
  }
}
