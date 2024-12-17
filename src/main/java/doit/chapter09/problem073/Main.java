package doit.chapter09.problem073;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static final long DIVIDE_VALUE = 1_000_000_007L;
  private static long[] array;
  private static long[] tree;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);
      int k = Integer.parseInt(inputs[2]);

      array = new long[n + 1];
      tree = new long[n * 4];

      for (int i = 1; i <= n; i++) {
        array[i] = divide(br.readLine());
      }

      build(1, 1, n);

      for (int i = 0; i < m + k; i++) {
        inputs = br.readLine().split(" ");
        int type = Integer.parseInt(inputs[0]);
        switch (type) {
          case 1: {
            int index = Integer.parseInt(inputs[1]);
            long value = divide(inputs[2]);
            update(1, 1, n, index, value);
            break;
          }
          case 2: {
            int left = Integer.parseInt(inputs[1]);
            int right = Integer.parseInt(inputs[2]);
            long result = multiply(1, 1, n, left, right);
            bw.write(result + "\n");
            break;
          }
        }
      }

      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static long build(int node, int start, int end) {
    if (start == end) {
      return tree[node] = array[start];
    }

    int mid = (start + end) / 2;
    return tree[node] = divide(build(node * 2, start, mid) * build(node * 2 + 1, mid + 1, end));
  }

  private static void update(int node, int start, int end, int index, long value) {
    if (start == end) {
      tree[node] = value;
      array[index] = value;
      return;
    }

    int mid = (start + end) / 2;
    if (index <= mid) {
      update(node * 2, start, mid, index, value);
    } else {
      update(node * 2 + 1, mid + 1, end, index, value);
    }

    tree[node] = divide(tree[node * 2] * tree[node * 2 + 1]);
  }

  private static long multiply(int node, int start, int end, int left, int right) {
    if (left > end || right < start) {
      return 1;
    }

    if (left <= start && end <= right) {
      return tree[node];
    }

    int mid = (start + end) / 2;
    return divide(multiply(node * 2, start, mid, left, right) * multiply(node * 2 + 1, mid + 1, end, left, right));
  }

  private static long divide(long value) {
    return value % DIVIDE_VALUE;
  }

  private static long divide(String value) {
    return divide(Long.parseLong(value));
  }

}