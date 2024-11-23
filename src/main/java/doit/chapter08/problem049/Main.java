package doit.chapter08.problem049;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  private static final int[] sender = {0, 0, 1, 1, 2, 2};
  private static final int[] receiver = {1, 2, 0, 2, 0, 1};
  private static boolean[][] visited;
  private static Set<Integer> result;
  private static int[] capacity;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      capacity = new int[3];
      capacity[0] = Integer.parseInt(inputs[0]);
      capacity[1] = Integer.parseInt(inputs[1]);
      capacity[2] = Integer.parseInt(inputs[2]);

      visited = new boolean[capacity[0] + 1][capacity[1] + 1];
      result = new TreeSet<>();

      bfs();

      for (Integer value : result) {
        bw.write(value + " ");
      }
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void bfs() {
    Queue<State> queue = new LinkedList<>();
    queue.add(new State(0, 0));
    visited[0][0] = true;
    result.add(capacity[2]);

    while (!queue.isEmpty()) {
      State current = queue.poll();
      int a = current.a;
      int b = current.b;
      int c = capacity[2] - current.a - current.b;

      for (int i = 0; i < 6; i++) {
        pour(a, b, c, sender[i], receiver[i], queue);
      }
    }
  }

  private static void pour(int a, int b, int c, int from, int to, Queue<State> queue) {
    int[] next = {a, b, c};

    next[to] += next[from];
    next[from] = 0;

    if (next[to] > capacity[to]) {
      next[from] = next[to] - capacity[to];
      next[to] = capacity[to];
    }

    if (!visited[next[0]][next[1]]) {
      visited[next[0]][next[1]] = true;
      queue.add(new State(next[0], next[1]));

      if (next[0] == 0) {
        result.add(next[2]);
      }
    }
  }

  private static class State {

    int a, b;

    public State(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }
}