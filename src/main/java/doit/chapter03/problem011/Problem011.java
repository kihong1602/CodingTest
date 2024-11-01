package doit.chapter03.problem011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem011 {

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
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static String solution(int[] array) {
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    int num = 1;
    for (int target : array) {
      if (num <= target) {
        while (num <= target) {
          stack.push(num++);
          sb.append("+").append("\n");
        }
      }

      if (stack.peek() == target) {
        stack.pop();
        sb.append("-").append("\n");
      } else {
        return "NO";
      }
    }

    return sb.toString();
  }

}