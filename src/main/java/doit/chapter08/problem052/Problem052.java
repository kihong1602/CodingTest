package doit.chapter08.problem052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem052 {

  private static int[] parent;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);

      parent = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        parent[i] = i;
      }

      inputs = br.readLine().split(" ");
      int truthCount = Integer.parseInt(inputs[0]);
      List<Integer> truths = new ArrayList<>();
      for (int i = 1; i <= truthCount; i++) {
        truths.add(Integer.parseInt(inputs[i]));
      }

      List<List<Integer>> parties = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        List<Integer> party = new ArrayList<>();
        inputs = br.readLine().split(" ");
        int partySize = Integer.parseInt(inputs[0]);
        for (int j = 1; j <= partySize; j++) {
          party.add(Integer.parseInt(inputs[j]));
        }

        for (int j = 1; j < party.size(); j++) {
          union(party.get(0), party.get(j));
        }

        parties.add(party);
      }

      for (int i = 1; i < truths.size(); i++) {
        union(truths.get(0), truths.get(i));
      }

      int root = truths.isEmpty() ? -1 : find(truths.get(0));

      int count = 0;
      for (List<Integer> party : parties) {
        count = canLie(root, count, party);
      }

      bw.write(String.valueOf(count));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static int find(int value) {
    if (parent[value] == value) {
      return value;
    }
    return parent[value] = find(parent[value]);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  private static int canLie(int root, int count, List<Integer> party) {
    boolean canLie = true;
    for (Integer person : party) {
      if (find(person) == root) {
        canLie = false;
        break;
      }
    }

    if (canLie) {
      count++;
    }
    return count;
  }
}