package Chapter03.problem012;

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
        // stack에 값이 존재하고, array[stack peek index]가 array[i] 보다 작다면 array[i]가 오큰수임
        // result[stack pop index]에 array[i]
        result[stack.pop()] = array[i];
      }
      // stack에 다음차례를 위해 index 저장
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      // 이전 반복문을 수행하도고 stack에 남아있는 index는 오큰수가 없음. 따라서 -1을 저장
      result[stack.pop()] = -1;
    }

    StringBuilder sb = new StringBuilder();
    for (int value : result) {
      sb.append(value).append(" ");
    }

    return sb.toString();
  }
}