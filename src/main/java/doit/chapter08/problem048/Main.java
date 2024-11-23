package doit.chapter08.problem048;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static List<List<Integer>> graph;
  private static boolean[] visited;
  private static boolean[] color;
  private static boolean flag;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int testCase = Integer.parseInt(br.readLine());
      while (testCase-- > 0) {
        String[] inputs = br.readLine().split(" ");
        int node = Integer.parseInt(inputs[0]);
        int edge = Integer.parseInt(inputs[1]);

        graph = new ArrayList<>();
        for (int i = 0; i <= node; i++) {
          graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
          inputs = br.readLine().split(" ");
          int u = Integer.parseInt(inputs[0]);
          int v = Integer.parseInt(inputs[1]);
          graph.get(u).add(v);
          graph.get(v).add(u);
        }

        String result = solution(node);
        bw.write(result);
        bw.newLine();
      }
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int n) {
    visited = new boolean[n + 1];
    color = new boolean[n + 1];
    flag = true;

    for (int i = 1; i <= n && flag; i++) {
      if (!visited[i]) {
        dfs(i);
      }
    }

    return flag ? "YES" : "NO";
  }

  private static void dfs(int node) {
    visited[node] = true;
    for (Integer next : graph.get(node)) {
      if (!visited[next]) {
        color[next] = !color[node];
        dfs(next);
      } else if (color[node] == color[next]) {
        flag = false;
        return;
      }
    }
  }
}