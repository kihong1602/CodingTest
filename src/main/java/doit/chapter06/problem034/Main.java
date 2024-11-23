package doit.chapter06.problem034;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] array = new int[size];

      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }

      String result = solution(array);

      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }


  private static String solution(int[] array) {
    Queue<Integer> positiveQueue = new PriorityQueue<>(Comparator.reverseOrder());
    Queue<Integer> negativeQueue = new PriorityQueue<>();
    int one = 0;
    int zero = 0;

    for (int value : array) {
      if (value > 1) {
        positiveQueue.offer(value);
      } else if (value == 1) {
        one++;
      } else if (value == 0) {
        zero++;
      } else {
        negativeQueue.offer(value);
      }
    }

    int sum = 0;

    while (positiveQueue.size() > 1) {
      int first = positiveQueue.poll();
      int second = positiveQueue.poll();
      sum += first * second;
    }

    if (!positiveQueue.isEmpty()) {
      sum += positiveQueue.poll();
    }

    while (negativeQueue.size() > 1) {
      int first = negativeQueue.poll();
      int second = negativeQueue.poll();
      sum += first * second;
    }

    if (!negativeQueue.isEmpty() && zero == 0) {
      sum += negativeQueue.poll();
    }

    sum += one;

    return String.valueOf(sum);
  }
}