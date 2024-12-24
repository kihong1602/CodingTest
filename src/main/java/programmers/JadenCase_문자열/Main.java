package programmers.JadenCase_문자열;

public class Main {

  public String solution(String s) {
    StringBuilder sb = new StringBuilder();

    boolean isFirst = true;

    for (char token : s.toCharArray()) {
      if (token == ' ') {
        sb.append(token);
        isFirst = true;
        continue;
      }

      if (isFirst) {
        char firstWord = Character.isAlphabetic(token) ? Character.toUpperCase(token) : token;
        sb.append(firstWord);
        isFirst = false;
      } else {
        sb.append(Character.toLowerCase(token));
      }

    }

    return sb.toString();
  }
}