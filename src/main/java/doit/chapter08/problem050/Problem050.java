package doit.chapter08.problem050;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class Problem050 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int n = Integer.parseInt(size[0]);
      int m = Integer.parseInt(size[1]);

      int[] array = IntStream.rangeClosed(0, n).toArray();

      String[] queries = new String[m];
      for (int i = 0; i < m; i++) {
        queries[i] = br.readLine();
      }

      String result = solution(array, queries);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int[] array, String[] queries) {
    StringBuilder sb = new StringBuilder();

    for (String query : queries) {
      String[] token = query.split(" ");
      String type = token[0];
      int a = Integer.parseInt(token[1]);
      int b = Integer.parseInt(token[2]);

      switch (type) {
        case "0":
          union(array, a, b);
          break;
        case "1":
          sb.append(isSame(array, a, b)).append("\n");
          break;
      }
    }

    return sb.toString();
  }

  private static int find(int[] array, int value) {
    if (array[value] == value) {
      return value;
    }
    return array[value] = find(array, array[value]);
  }

  private static void union(int[] array, int a, int b) {
    a = find(array, a);
    b = find(array, b);
    if (a != b) {
      array[b] = a;
    }
  }

  private static String isSame(int[] array, int a, int b) {
    return find(array, a) == find(array, b) ? "YES" : "NO";
  }

}