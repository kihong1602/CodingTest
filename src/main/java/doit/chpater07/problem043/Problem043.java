package doit.chpater07.problem043;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem043 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      long a = Long.parseLong(inputs[0]);
      long b = Long.parseLong(inputs[1]);
      long result = gcd(a, b);
      while (result-- > 0) {
        bw.write("1");
      }
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static long gcd(long a, long b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}