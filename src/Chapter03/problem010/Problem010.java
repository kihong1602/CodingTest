package Chapter03.problem010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem010 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int numberSize = Integer.parseInt(size[0]);
      int range = Integer.parseInt(size[1]);

      Deque<Node> deque = new ArrayDeque<>();

      String[] inputs = br.readLine().split(" ");
      for (int i = 0; i < numberSize; i++) {
        int now = Integer.parseInt(inputs[i]);
        while (!deque.isEmpty() && deque.getLast().value() > now) {
          deque.removeLast();
        }
        deque.addLast(new Node(i, now));

        if (deque.getFirst().index() <= i - range) {
          deque.removeFirst();
        }
        bw.write(deque.getFirst().value() + " ");
      }

      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static class Node {

    private final int index;
    private final int value;

    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }

    public int index() {
      return this.index;
    }

    public int value() {
      return this.value;
    }

  }

}