package chapter03.problem014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem014 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] operations = new int[size];
      for (int i = 0; i < size; i++) {
        operations[i] = Integer.parseInt(br.readLine());
      }
      String result = solution(operations);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static String solution(int[] operations) {
    StringBuilder sb = new StringBuilder();

    Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
      int first = Math.abs(o1);
      int second = Math.abs(o2);
      if (first == second) {
        return o1 > o2 ? 1 : -1;
      } else {
        return first - second;
      }
    });

    for (int operation : operations) {
      if (operation == 0) {
        sb.append(queue.isEmpty() ? "0" : queue.poll()).append("\n");
      } else {
        queue.add(operation);
      }
    }

    return sb.toString();
  }

}