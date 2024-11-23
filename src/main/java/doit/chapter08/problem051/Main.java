package doit.chapter08.problem051;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class Main {


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());

      int[][] cities = new int[n + 1][n + 1];
      for (int i = 1; i <= n; i++) {
        String[] inputs = br.readLine().split(" ");
        for (int j = 1; j <= n; j++) {
          cities[i][j] = Integer.parseInt(inputs[j - 1]);
        }
      }

      String[] inputs = br.readLine().split(" ");
      int[] routes = new int[m + 1];
      for (int i = 1; i <= m; i++) {
        routes[i] = Integer.parseInt(inputs[i - 1]);
      }

      String result = solution(n, cities, routes);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String solution(int n, int[][] cities, int[] routes) {
    int[] city = IntStream.range(0, cities.length).toArray();
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        if (cities[i][j] == 1) {
          union(city, i, j);
        }
      }
    }

    int root = find(city, routes[1]);
    for (int i = 2; i < routes.length; i++) {
      if (root != find(city, routes[i])) {
        return "NO";
      }
    }

    return "YES";
  }

  private static int find(int[] city, int value) {
    if (city[value] == value) {
      return value;
    }
    return city[value] = find(city, city[value]);
  }

  private static void union(int[] city, int a, int b) {
    a = find(city, a);
    b = find(city, b);
    if (a != b) {
      city[b] = a;
    }
  }

}