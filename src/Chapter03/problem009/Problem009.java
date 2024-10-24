package Chapter03.problem009;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem009 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");

      int wordLength = Integer.parseInt(size[0]);
      int passwordLength = Integer.parseInt(size[1]);

      String word = br.readLine();

      String[] inputs = br.readLine().split(" ");
      int[] requiredCounts = new int[4];
      for (int i = 0; i < 4; i++) {
        requiredCounts[i] = Integer.parseInt(inputs[i]);
      }

      int[] currentCounts = new int[4];
      int result = 0;

      for (int i = 0; i < passwordLength; i++) {
        currentCounts[operation(word.charAt(i))]++;
      }

      if (isValid(requiredCounts, currentCounts)) {
        result++;
      }

      for (int i = passwordLength; i < wordLength; i++) {
        currentCounts[operation(word.charAt(i - passwordLength))]--;
        currentCounts[operation(word.charAt(i))]++;

        if (isValid(requiredCounts, currentCounts)) {
          result++;
        }
      }

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static int operation(char token) {
    return switch (token) {
      case 'A' -> 0;
      case 'C' -> 1;
      case 'G' -> 2;
      case 'T' -> 3;
      default -> throw new IllegalArgumentException();
    };
  }

  private static boolean isValid(int[] min, int[] current) {
    for (int i = 0; i < 4; i++) {
      if (min[i] > current[i]) {
        return false;
      }
    }
    return true;
  }

}