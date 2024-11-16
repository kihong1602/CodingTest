package doit.chapter07.problem044;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem044 {

  private static final List<List<Ratio>> graph = new ArrayList<>();
  private static long[] mass;
  private static boolean[] visited;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());
      for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
      }
      mass = new long[n];
      visited = new boolean[n];

      long lcm = 1;
      for (int i = 0; i < n - 1; i++) {
        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int p = Integer.parseInt(inputs[2]);
        int q = Integer.parseInt(inputs[3]);
        graph.get(a).add(new Ratio(b, p, q));
        graph.get(b).add(new Ratio(a, q, p));
        lcm *= (p * q / gcd(p, q));
      }

      mass[0] = lcm;
      dfs(0);

      long mgcd = mass[0];
      for (int i = 0; i < n; i++) {
        mgcd = gcd(mgcd, mass[i]);
      }

      for (int i = 0; i < n; i++) {
        bw.write((mass[i] / mgcd) + " ");
      }
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void dfs(int node) {
    visited[node] = true;
    for (Ratio ratio : graph.get(node)) {
      if (!visited[ratio.to]) {
        mass[ratio.to] = mass[node] * ratio.q / ratio.p;
        dfs(ratio.to);
      }
    }

  }

  private static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  private static class Ratio {

    int to;
    int p;
    int q;

    public Ratio(int to, int p, int q) {
      this.to = to;
      this.p = p;
      this.q = q;
    }
  }

}