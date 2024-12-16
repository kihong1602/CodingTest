package doit.chapter09.problem071;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static long[] tree;
  private static long[] array;

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
        array[i] = Long.parseLong(br.readLine());
      }

      build(1, 1, n);

      for (int i = 0; i < m + k; i++) {
        inputs = br.readLine().split(" ");
        int type = Integer.parseInt(inputs[0]);
        switch (type) {
          case 1: {
            int index = Integer.parseInt(inputs[1]);
            long value = Long.parseLong(inputs[2]);
            update(1, 1, n, index, value);
            break;
          }
          case 2: {
            int left = Integer.parseInt(inputs[1]);
            int right = Integer.parseInt(inputs[2]);
            long result = sum(1, 1, n, left, right);
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
    return tree[node] = build(node * 2, start, mid) + build(node * 2 + 1, mid + 1, end);
  }

  private static void update(int node, int start, int end, int idx, long value) {
    if (start == end) {
      tree[node] = value;
      array[idx] = value;
      return;
    }

    int mid = (start + end) / 2;
    if (idx <= mid) {
      update(node * 2, start, mid, idx, value);
    } else {
      update(node * 2 + 1, mid + 1, end, idx, value);
    }

    tree[node] = tree[node * 2] + tree[node * 2 + 1];
  }

  private static long sum(int node, int start, int end, int left, int right) {
    if (left > end || right < start) {
      return 0;
    }

    if (left <= start && end <= right) {
      return tree[node];
    }

    int mid = (start + end) / 2;
    return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
  }
}