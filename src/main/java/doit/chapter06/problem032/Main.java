package doit.chapter06.problem032;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] input = br.readLine().split(" ");
      int coinTypes = Integer.parseInt(input[0]);
      int amount = Integer.parseInt(input[1]);

      int[] coins = new int[coinTypes];

      for (int i = 0; i < coinTypes; i++) {
        coins[i] = Integer.parseInt(br.readLine());
      }

      int count = 0;
      for (int i = coinTypes - 1; i >= 0; i--) {
        if (coins[i] <= amount) {
          count += amount / coins[i];
          amount %= coins[i];
        }
      }

      bw.write(String.valueOf(count));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}