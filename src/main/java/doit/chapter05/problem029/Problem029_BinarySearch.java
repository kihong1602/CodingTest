package doit.chapter05.problem029;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem029_BinarySearch {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String[] inputs = br.readLine().split(" ");
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }

      size = Integer.parseInt(br.readLine());
      inputs = br.readLine().split(" ");
      int[] targets = new int[size];
      for (int i = 0; i < size; i++) {
        targets[i] = Integer.parseInt(inputs[i]);
      }

      String result = solution(array, targets);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static String solution(int[] array, int[] targets) {
    StringBuilder sb = new StringBuilder();
    Arrays.sort(array);
    for (int target : targets) {
      sb.append(binarySearch(array, target) ? "1" : "0").append("\n");
    }
    return sb.toString();
  }

  private static boolean binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (array[mid] == target) {
        return true;
      } else if (array[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }

}