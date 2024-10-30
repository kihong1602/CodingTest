package chapter03.problem004;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem004 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int arraySize = Integer.parseInt(size[0]);
      int querySize = Integer.parseInt(size[1]);

      int[][] array = new int[arraySize + 1][arraySize + 1];
      for (int i = 1; i <= arraySize; i++) {
        String[] inputs = br.readLine().split(" ");
        for (int j = 1; j <= arraySize; j++) {
          array[i][j] = Integer.parseInt(inputs[j - 1]);
        }
      }

      int[][] sum = new int[arraySize + 1][arraySize + 1];
      for (int i = 1; i <= arraySize; i++) {
        for (int j = 1; j <= arraySize; j++) {
          sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + array[i][j];
        }
      }

      while (querySize-- > 0) {
        String[] queries = br.readLine().split(" ");
        int x1 = Integer.parseInt(queries[0]);
        int y1 = Integer.parseInt(queries[1]);
        int x2 = Integer.parseInt(queries[2]);
        int y2 = Integer.parseInt(queries[3]);

        int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
        bw.write(result + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}