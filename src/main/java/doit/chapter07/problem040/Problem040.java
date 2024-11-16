package doit.chapter07.problem040;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem040 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      long min = Long.parseLong(size[0]);
      long max = Long.parseLong(size[1]);

      int range = (int) (max - min + 1);
      boolean[] isNotPows = new boolean[range];
      Arrays.fill(isNotPows, true);

      for (long i = 2; i * i <= max; i++) {
        long pow = i * i;
        long start = (min % pow == 0) ? min / pow : min / pow + 1;

        for (long j = start; j * pow <= max; j++) {
          isNotPows[(int) (j * pow - min)] = false;
        }
      }

      int count = 0;
      for (int i = 0; i < range; i++) {
        if (isNotPows[i]) {
          count++;
        }
      }

      bw.write(String.valueOf(count));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}