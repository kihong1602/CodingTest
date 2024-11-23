package doit.chapter08.problem047;

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

  private static final List<List<Integer>> graph = new ArrayList<>();
  private static boolean[][] visited;
  private static int[] count;
  private static int max = 0;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int N = Integer.parseInt(size[0]);
      int M = Integer.parseInt(size[1]);

      visited = new boolean[N + 1][N + 1];
      count = new int[N + 1];

      for (int i = 0; i <= N; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < M; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        graph.get(v).add(u);
      }

      for (int i = 1; i <= N; i++) {
        if (count[i] == 0) {
          bfs(i);
        }
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= N; i++) {
        if (count[i] == max) {
          sb.append(i).append(" ");
        }
      }

      bw.write(sb.toString().trim());
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void bfs(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      Integer now = queue.poll();

      if (visited[node][now]) {
        continue;
      }
      visited[node][now] = true;
      count[node]++;

      for (Integer next : graph.get(now)) {
        if (visited[node][next]) {
          continue;
        }

        if (next > node) {
          queue.add(next);
        } else {
          for (int i = 1; i < count.length; i++) {
            if (!visited[node][i] && visited[next][i]) {
              visited[node][i] = true;
              count[node]++;
            }
          }
        }
      }
    }
    max = Math.max(max, count[node]);
  }

}