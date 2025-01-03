package programmers.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

  private final int[] dx = {-1, 1, 0, 0};
  private final int[] dy = {0, 0, -1, 1};

  public int solution(int[][] maps) {
    Point start = new Point(0, 0);
    bfs(maps, start);

    int n = maps.length;
    int m = maps[0].length;

    return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
  }

  private void bfs(int[][] maps, Point start) {
    int width = maps.length;
    int height = maps[0].length;
    Queue<Point> queue = new LinkedList<>();
    queue.add(start);

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
        if (maps[nextX][nextY] != 1) {
          continue;
        }
        maps[nextX][nextY] = maps[nowX][nowY] + 1;
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