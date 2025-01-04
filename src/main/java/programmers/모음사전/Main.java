package programmers.모음사전;

import java.util.ArrayList;
import java.util.List;

public class Main {

  private final char[] tokens = "AEIOU".toCharArray();

  public int solution(String word) {
    List<String> list = new ArrayList<>();
    wordBuilder("", list);
    return list.indexOf(word);
  }

  private void wordBuilder(String str, List<String> list) {
    list.add(str);
    if (str.length() == 5) {
      return;
    }
    for (char token : tokens) {
      wordBuilder(str + token, list);
    }
  }
}