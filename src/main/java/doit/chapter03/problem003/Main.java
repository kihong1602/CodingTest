package doit.chapter03.problem003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int arraySize = Integer.parseInt(size[0]);
      int querySize = Integer.parseInt(size[1]);

      int[] sumArray = new int[arraySize + 1];
      String[] inputs = br.readLine().split(" ");
      for (int i = 0; i < inputs.length; i++) {
        sumArray[i + 1] = sumArray[i] + Integer.parseInt(inputs[i]);
      }

      while (querySize-- > 0) {
        String[] boundary = br.readLine().split(" ");
        int start = Integer.parseInt(boundary[0]);
        int end = Integer.parseInt(boundary[1]);
        int result = sumArray[end] - sumArray[start - 1];
        bw.write(result + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}