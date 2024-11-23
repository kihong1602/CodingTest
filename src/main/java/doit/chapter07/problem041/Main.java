package doit.chapter07.problem041;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      long n = Long.parseLong(br.readLine());

      long result = n;
      for (long p = 2; p <= Math.sqrt(n); p++) {
        if (n % p == 0) {
          while (n % p == 0) {
            n /= p;
          }
          result = result * (p - 1) / p;
        }
      }

      if (n > 1) {
        result = result * (n - 1) / n;
      }

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}