package doit.chapter09.problem069;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_Trie {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int m = Integer.parseInt(inputs[1]);

      Trie root = new Trie();
      while (n > 0) {
        String text = br.readLine();
        Trie now = root;
        for (int i = 0; i < text.length(); i++) {
          char token = text.charAt(i);
          if (now.next[token - 'a'] == null) {
            now.next[token - 'a'] = new Trie();
          }
          now = now.next[token - 'a'];
          if (isLastWord(text, i)) {
            now.isEnd = true;
          }
        }
        n--;
      }

      int count = 0;
      while (m > 0) {
        String text = br.readLine();
        Trie now = root;
        for (int i = 0; i < text.length(); i++) {
          char token = text.charAt(i);
          if (now.next[token - 'a'] == null) {
            break;
          }
          now = now.next[token - 'a'];
          if (isLastWord(text, i) && now.isEnd) {
            count++;
          }
        }
        m--;
      }

      bw.write(String.valueOf(count));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static boolean isLastWord(String text, int index) {
    return text.length() - 1 == index;
  }

  private static class Trie {

    Trie[] next = new Trie[26];
    boolean isEnd;

  }

}