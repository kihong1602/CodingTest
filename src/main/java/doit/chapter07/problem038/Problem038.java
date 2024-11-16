package doit.chapter07.problem038;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem038 {

  private static final int max = (int) Math.pow(10, 7);
  private static boolean[] isPrimes;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      long start = Long.parseLong(size[0]);
      long end = Long.parseLong(size[1]);

      int result = solution(start, end);

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static int solution(long start, long end) {
    isPrimes = new boolean[max + 1];
    primeCheck();

    int count = 0;
    for (int number = 2; number < isPrimes.length; number++) {
      if (!isPrimes[number]) {
        continue;
      }

      long target = (long) number * number;
      while (target <= end) {
        if (target >= start) {
          count++;
        }
        if (target > end / number) {
          break;
        }
        target *= number;
      }
    }
    return count;
  }

  private static void primeCheck() {
    Arrays.fill(isPrimes, true);
    isPrimes[0] = isPrimes[1] = false;
    for (int i = 2; i <= Math.sqrt(max); i++) {
      if (isPrimes[i]) {
        for (int j = i * i; j <= max; j += i) {
          isPrimes[j] = false;
        }
      }
    }
  }
}