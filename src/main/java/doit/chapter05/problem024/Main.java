package doit.chapter05.problem024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static final StringBuilder sb = new StringBuilder();

  private static int maxDigit;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      maxDigit = Integer.parseInt(br.readLine());

      int[] primes = {2, 3, 5, 7};

      for (int prime : primes) {
        dfs(prime, 1);
      }

      bw.write(sb.toString());
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void dfs(int number, int digit) {
    if (digit == maxDigit) {
      if (isPrime(number)) {
        sb.append(number).append("\n");
      }
      return;
    }

    for (int i = 1; i < 10; i += 2) {
      int next = number * 10 + i;
      if (isPrime(next)) {
        dfs(next, digit + 1);
      }
    }
  }

  private static boolean isPrime(int num) {
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

}