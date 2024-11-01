package doit.chapter03.problem013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Problem013 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      Queue<Integer> queue = new LinkedList<>();
      for (int i = 1; i <= size; i++) {
        queue.add(i);
      }

      while (queue.size() != 1) {
        queue.poll();
        queue.add(queue.poll());
      }
      bw.write(String.valueOf(queue.poll()));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}