package programmers.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

  private int[][] visited;
  private int[] dx = {-1, 1, 0, 0};
  private int[] dy = {0, 0, -1, 1};

  public int solution(int[][] maps) {
    int n = maps.length;
    int m = maps[0].length;
    visited = new int[n][m];

    Point start = new Point(0, 0);
    bfs(maps, start);
    return visited[n - 1][m - 1] == 0 ? -1 : visited[n - 1][m - 1];
  }

  private void bfs(int[][] maps, Point start) {
    int width = maps.length;
    int height = maps[0].length;
    Queue<Point> queue = new LinkedList<>();
    queue.add(start);
    visited[start.x][start.y] = 1;

    while (!queue.isEmpty()) {
      Point now = queue.poll();
      int nowX = now.x;
      int nowY = now.y;

      for (int i = 0; i < 4; i++) {
        int nextX = nowX + dx[i];
        int nextY = nowY + dy[i];
        if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) {
          continue;
        }
        if (maps[nextX][nextY] == 0 || visited[nextX][nextY] != 0) {
          continue;
        }
        visited[nextX][nextY] = visited[nowX][nowY] + 1;
        queue.add(new Point(nextX, nextY));
      }
    }
  }

  private static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }

}