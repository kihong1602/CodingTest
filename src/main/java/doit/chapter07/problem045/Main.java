package doit.chapter07.problem045;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int a = Integer.parseInt(inputs[0]);
      int b = Integer.parseInt(inputs[1]);
      int c = Integer.parseInt(inputs[2]);

      Result result = extendedGcd(a, b);
      if (c % result.gcd != 0) {
        bw.write("-1");
      } else {
        long scale = c / result.gcd;
        long x = result.x * scale;
        long y = result.y * scale;
        bw.write(x + " " + y);
      }
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static Result extendedGcd(int a, int b) {
    if (b == 0) {
      return new Result(a, 1, 0);
    }
    Result next = extendedGcd(b, a % b);
    long x = next.y;
    long y = next.x - (a / b) * next.y;
    return new Result(next.gcd, x, y);
  }

  private static class Result {

    long gcd;
    long x;
    long y;

    public Result(long gcd, long x, long y) {
      this.gcd = gcd;
      this.x = x;
      this.y = y;
    }
  }

}