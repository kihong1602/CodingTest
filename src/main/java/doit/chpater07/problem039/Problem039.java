package doit.chpater07.problem039;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem039 {

  private static final int MAX = 2_000_000;
  private static final boolean[] isPrimes = new boolean[MAX + 1];

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int min = Integer.parseInt(br.readLine());
      primeCheck();

      for (int number = min; number < isPrimes.length; number++) {
        if (!isPrimes[number]) {
          continue;
        }

        if (isPalindrome(number)) {
          bw.write(String.valueOf(number));
          break;
        }
      }

      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static void primeCheck() {
    Arrays.fill(isPrimes, true);
    isPrimes[0] = isPrimes[1] = false;
    for (int i = 2; i <= Math.sqrt(MAX); i++) {
      if (isPrimes[i]) {
        for (int j = i * i; j <= MAX; j += i) {
          isPrimes[j] = false;
        }
      }
    }
  }

  private static boolean isPalindrome(int number) {
    String value = String.valueOf(number);
    int left = 0;
    int right = value.length() - 1;
    while (left <= right) {
      if (value.charAt(left++) != value.charAt(right--)) {
        return false;
      }
    }
    return true;
  }

}