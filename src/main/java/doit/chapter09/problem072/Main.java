package doit.chapter09.problem072;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static int[] array;
  private static int[] tree;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);
      array = new int[n + 1];
      tree = new int[n * 4];
      for (int i = 1; i <= n; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }

      build(1, 1, n);

      for (int i = 0; i < m; i++) {
        inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int min = min(1, 1, n, a, b);
        bw.write(min + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static int build(int node, int start, int end) {
    if (start == end) {
      return tree[node] = array[start];
    }

    int mid = (start + end) / 2;
    return tree[node] = Math.min(build(node * 2, start, mid), build(node * 2 + 1, mid + 1, end));
  }

  private static int min(int node, int start, int end, int left, int right) {
    if (left > end || right < start) {
      return Integer.MAX_VALUE;
    }
    if (left <= start && right >= end) {
      return tree[node];
    }

    int mid = (start + end) / 2;

    return Math.min(min(node * 2, start, mid, left, right), min(node * 2 + 1, mid + 1, end, left, right));
  }
}