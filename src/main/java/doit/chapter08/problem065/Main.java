package doit.chapter08.problem065;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  private static final int MIN_BRIDGE_LEN = 2;
  private static final int[] dx = {-1, 1, 0, 0};
  private static final int[] dy = {0, 0, -1, 1};
  private static final List<Edge> edges = new ArrayList<>();
  private static int[][] map;
  private static int n, m;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      n = Integer.parseInt(inputs[0]);
      m = Integer.parseInt(inputs[1]);
      map = new int[n][m];
      boolean[][] visited = new boolean[n][m];
      for (int i = 0; i < n; i++) {
        inputs = br.readLine().split(" ");
        for (int j = 0; j < m; j++) {
          map[i][j] = Integer.parseInt(inputs[j]);
        }
      }

      int island = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (map[i][j] == 1 && !visited[i][j]) {
            island++;
            bfs(i, j, island, visited);
          }
        }
      }

      int result = solution(island);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void bfs(int x, int y, int land, boolean[][] visited) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});
    visited[x][y] = true;
    map[x][y] = land;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nextX = now[0] + dx[i];
        int nextY = now[1] + dy[i];

        if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
          continue;
        }

        if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
          visited[nextX][nextY] = true;
          map[nextX][nextY] = land;
          queue.add(new int[]{nextX, nextY});
        }
      }
    }
  }

  private static int solution(int land) {
    calculateBridge();
    edges.sort(Comparator.naturalOrder());

    int[] parent = new int[land + 1];
    for (int i = 1; i <= land; i++) {
      parent[i] = i;
    }

    int totalCost = 0;
    int count = 0;

    for (Edge edge : edges) {
      int a = find(parent, edge.start);
      int b = find(parent, edge.end);
      if (a != b) {
        union(parent, a, b);
        totalCost += edge.weight;
        count++;
        if (count == land - 1) {
          break;
        }
      }
    }
    return count == land - 1 ? totalCost : -1;
  }

  private static void calculateBridge() {
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        if (map[x][y] > 0) {
          for (int i = 0; i < 4; i++) {
            connectBridge(x, y, i);
          }
        }
      }
    }
  }

  private static void connectBridge(int x, int y, int dir) {
    int current = map[x][y];
    int length = 0;
    while (true) {
      x += dx[dir];
      y += dy[dir];
      if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == current) {
        break;
      }
      if (map[x][y] > 0) {
        if (length >= MIN_BRIDGE_LEN) {
          edges.add(new Edge(current, map[x][y], length));
        }
        break;
      }
      if (map[x][y] == 0) {
        length++;
      }
    }
  }

  private static int find(int[] parent, int value) {
    if (parent[value] == value) {
      return value;
    }
    return parent[value] = find(parent, parent[value]);
  }

  private static void union(int[] parent, int a, int b) {
    a = find(parent, a);
    b = find(parent, b);
    if (a != b) {
      parent[b] = a;
    }
  }

  private static class Edge implements Comparable<Edge> {

    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }

}