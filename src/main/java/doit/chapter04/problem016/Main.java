package doit.chapter04.problem016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int N = Integer.parseInt(br.readLine());
      Node[] array = new Node[N];
      for (int i = 0; i < N; i++) {
        array[i] = new Node(i, Integer.parseInt(br.readLine()));
      }

      Arrays.sort(array);
      int max = 0;
      for (int i = 0; i < N; i++) {
        max = Math.max(max, array[i].getIndex() - i);
      }

      bw.write(String.valueOf(max + 1));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static class Node implements Comparable<Node> {

    private int index;
    private int value;

    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }

    public int getIndex() {
      return this.index;
    }

    public int getValue() {
      return this.value;
    }

    @Override
    public int compareTo(Node o) {
      return this.value - o.value;
    }

  }

}