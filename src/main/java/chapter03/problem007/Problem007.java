package chapter03.problem007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem007 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int materialSize = Integer.parseInt(br.readLine());
      int requiredMaterialCountForArmor = Integer.parseInt(br.readLine());

      String[] inputs = br.readLine().split(" ");
      int[] materials = new int[materialSize];
      for (int i = 0; i < materialSize; i++) {
        materials[i] = Integer.parseInt(inputs[i]);
      }

      Arrays.sort(materials);

      int result = 0;
      int start = 0;
      int end = materialSize - 1;
      while (start < end) {
        int sum = materials[start] + materials[end];
        if (sum == requiredMaterialCountForArmor) {
          result++;
          start++;
          end--;
        }
        if (sum < requiredMaterialCountForArmor) {
          start++;
        }
        if (sum > requiredMaterialCountForArmor) {
          end--;
        }
      }

      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}