package chapter03.problem012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem012 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());

      int[] array = new int[size];
      String[] inputs = br.readLine().split(" ");
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }

      String result = solution(array);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static String solution(int[] array) {
    int[] result = new int[array.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < array.length; i++) {
      while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
        result[stack.pop()] = array[i];
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      result[stack.pop()] = -1;
    }

    StringBuilder sb = new StringBuilder();
    for (int value : result) {
      sb.append(value).append(" ");
    }

    return sb.toString();
  }
}