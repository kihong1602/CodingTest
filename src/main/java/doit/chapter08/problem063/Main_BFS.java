package doit.chapter08.problem063;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_BFS {

  private static final List<List<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);

      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < m; i++) {
        inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        graph.get(a).add(b);
        graph.get(b).add(a);
      }

      int min = Integer.MAX_VALUE;
      int result = -1;
      for (int i = 1; i <= n; i++) {
        int distance = bfs(i, n);
        if (distance < min) {
          min = distance;
          result = i;
        }
      }

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static int bfs(int start, int n) {
    int[] distance = new int[n + 1];
    Arrays.fill(distance, -1);
    distance[start] = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      for (Integer next : graph.get(now)) {
        if (distance[next] == -1) {
          distance[next] = distance[now] + 1;
          queue.add(next);
        }
      }
    }

    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += distance[i];
    }
    return sum;
  }
}