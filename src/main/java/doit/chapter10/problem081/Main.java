package doit.chapter10.problem081;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static long[] factorials;
  private static List<Integer> numbers = new ArrayList<>();

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int n = Integer.parseInt(br.readLine());

      for (int i = 1; i <= n; i++) {
        numbers.add(i);
      }

      factorials = new long[n + 1];
      factorials[0] = 1;
      for (int i = 1; i <= n; i++) {
        factorials[i] = factorials[i - 1] * i;
      }

      String[] inputs = br.readLine().split(" ");
      int type = Integer.parseInt(inputs[0]);
      switch (type) {
        case 1: {
          long k = Long.parseLong(inputs[1]);
          String result = getPerm(n, k);
          bw.write(result);
          break;
        }
        case 2: {
          int[] arr = new int[n];
          for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i + 1]);
          }
          String result = getOrder(n, arr);
          bw.write(result);
          break;
        }
      }

      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static String getPerm(int n, long k) {
    k--;
    StringBuilder sb = new StringBuilder();
    List<Integer> temp = new ArrayList<>(numbers);
    for (int i = 0; i < n; i++) {
      long factorial = factorials[n - 1 - i];
      int index = (int) (k / factorial);
      sb.append(temp.get(index)).append(" ");
      temp.remove(index);
      k %= factorial;
    }
    return sb.toString().trim();
  }

  private static String getOrder(int n, int[] arr) {
    long result = 1;
    List<Integer> temp = new ArrayList<>(numbers);
    for (int i = 0; i < n; i++) {
      int num = arr[i];
      int index = temp.indexOf(num);
      result += index * factorials[n - 1 - i];
      temp.remove(index);
    }
    return String.valueOf(result);
  }

}