package doit.chapter03.problem005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem005 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int size = Integer.parseInt(inputs[0]);
      int M = Integer.parseInt(inputs[1]);
      long[] count = new long[M];
      inputs = br.readLine().split(" ");

      long answer = 0;
      long sum = 0;
      for (int i = 0; i < size; i++) {
        sum += Integer.parseInt(inputs[i]);
        int remain = (int) (sum % M);
        if (remain == 0) {
          answer++;
        }
        count[remain]++;
      }

      for (int i = 0; i < M; i++) {
        if (count[i] > 1) {
          answer += count[i] * (count[i] - 1) / 2;
        }
      }
      bw.write(String.valueOf(answer));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}