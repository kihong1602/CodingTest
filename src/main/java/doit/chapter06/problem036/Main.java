package doit.chapter06.problem036;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split("-");

      int result = IntStream.range(0, inputs.length)
                            .map(i -> (i == 0 ? 1 : -1) * sum(inputs[i]))
                            .sum();

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static int sum(String token) {
    return Arrays.stream(token.split("[+]")).mapToInt(Integer::parseInt).sum();
  }
}