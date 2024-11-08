package doit.chpater07.problem037;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem037 {

  private static boolean[] isPrime;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int m = Integer.parseInt(inputs[0]);
      int n = Integer.parseInt(inputs[1]);

      isPrime = new boolean[n + 1];
      solution(n);
      for (int i = m; i <= n; i++) {
        if (isPrime[i]) {
          bw.write(String.valueOf(i));
          bw.newLine();
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void solution(int n) {
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }
    }

  }

}