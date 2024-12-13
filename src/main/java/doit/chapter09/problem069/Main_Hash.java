package doit.chapter09.problem069;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main_Hash {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);

      Set<String> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        String input = br.readLine();
        set.add(input);
      }

      int count = 0;
      for (int i = 0; i < m; i++) {
        String input = br.readLine();
        if (set.contains(input)) {
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