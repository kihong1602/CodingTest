package programmers.PCCP_석유시추;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

  private static final int[] dx = {-1, 1, 0, 0};
  private static final int[] dy = {0, 0, -1, 1};
  private static final Map<Integer, Integer> map = new HashMap<>();
  private static int mapX;
  private static int mapY;
  private static boolean[][] visited;

  public int solution(int[][] land) {
    mapX = land.length;
    mapY = land[0].length;
    visited = new boolean[mapX][mapY];

    for (int row = 0; row < mapX; row++) {
      for (int col = 0; col < mapY; col++) {
        if (land[row][col] == 1 && !visited[row][col]) {
          bfs(land, row, col);
        }
      }
    }

    return getMaxOil();
  }

  private void bfs(int[][] land, int x, int y) {
    visited[x][y] = true;
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(x, y));

    int size = 1;
    int min = y;
    int max = y;

    while (!queue.isEmpty()) {
      Point now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nextX = now.x + dx[i];
        int nextY = now.y + dy[i];

        if (isOutOfBound(nextX, nextY)) {
          continue;
        }

        if (land[nextX][nextY] == 1 && !visited[nextX][nextY]) {
          visited[nextX][nextY] = true;
          queue.add(new Point(nextX, nextY));
          size++;
          min = Math.min(min, nextY);
          max = Math.max(max, nextY);
        }
      }
    }

    for (int col = min; col <= max; col++) {
      map.put(col, map.getOrDefault(col, 0) + size);
    }
  }

  private boolean isOutOfBound(int x, int y) {
    return x < 0 || y < 0 || x >= mapX || y >= mapY;
  }

  private int getMaxOil() {
    int max = 0;
    for (int col : map.keySet()) {
      max = Math.max(max, map.get(col));
    }
    return max;
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