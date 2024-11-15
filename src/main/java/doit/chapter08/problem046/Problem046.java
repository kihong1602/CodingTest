package doit.chapter08.problem046;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem046 {

  private static final List<List<Integer>> graph = new ArrayList<>();
  private static int[] distance;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int n = Integer.parseInt(size[0]);
      int m = Integer.parseInt(size[1]);
      int k = Integer.parseInt(size[2]);
      int x = Integer.parseInt(size[3]);

      distance = new int[n + 1];
      Arrays.fill(distance, -1);
      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < m; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        graph.get(u).add(v);
      }

      String result = solution(k, x);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int k, int start) {
    bfs(start);

    List<Integer> list = new ArrayList<>();
    for (int i = 1; i < distance.length; i++) {
      if (distance[i] == k) {
        list.add(i);
      }
    }

    if (list.isEmpty()) {
      return "-1";
    }

    list.sort(Comparator.naturalOrder());
    StringBuilder sb = new StringBuilder();
    for (Integer value : list) {
      sb.append(value).append("\n");
    }

    return sb.toString();
  }

  private static void bfs(int start) {
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
  }
}