package doit.chapter06.problem033;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      Queue<Integer> queue = new PriorityQueue<>();

      for (int i = 0; i < size; i++) {
        queue.add(Integer.parseInt(br.readLine()));
      }

      int result = 0;
      while (queue.size() > 1) {
        int first = queue.poll();
        int second = queue.poll();

        int sum = first + second;

        result += sum;
        queue.add(sum);
      }

      bw.write(String.valueOf(result));
      bw.flush();

    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}