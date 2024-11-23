package doit.chapter05.problem027;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  private static final int[] dx = {-1, 1, 0, 0};
  private static final int[] dy = {0, 0, -1, 1};

  private static int[][] map;

  private static boolean[][] visited;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int row = Integer.parseInt(size[0]);
      int col = Integer.parseInt(size[1]);

      map = new int[row][col];
      visited = new boolean[row][col];

      for (int i = 0; i < row; i++) {
        String input = br.readLine();
        for (int j = 0; j < col; j++) {
          map[i][j] = input.charAt(j) - '0';
        }
      }

      Node start = new Node(0, 0);
      bfs(start, row, col);

      bw.write(String.valueOf(map[row - 1][col - 1]));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void bfs(Node start, int row, int col) {
    visited[start.x][start.y] = true;
    map[start.x][start.y] = 1;

    Queue<Node> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nextX = now.x + dx[i];
        int nextY = now.y + dy[i];

        if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) {
          continue;
        }

        if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
          visited[nextX][nextY] = true;
          map[nextX][nextY] = map[now.x][now.y] + 1;
          queue.add(new Node(nextX, nextY));
        }
      }
    }
  }

  private static class Node {

    final int x;
    final int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }

}