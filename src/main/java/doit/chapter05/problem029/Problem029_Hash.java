package doit.chapter05.problem029;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Problem029_Hash {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String[] inputs = br.readLine().split(" ");
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < size; i++) {
        map.put(Integer.parseInt(inputs[i]), 1);
      }

      size = Integer.parseInt(br.readLine());
      inputs = br.readLine().split(" ");

      StringBuilder sb = new StringBuilder();
      for (String token : inputs) {
        Integer find = map.getOrDefault(Integer.parseInt(token), 0);
        sb.append(find).append("\n");
      }

      bw.write(sb.toString());
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}