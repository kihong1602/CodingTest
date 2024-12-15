package programmers.KAKAO_신규아이디추천;

public class Main {

  public String solution(String new_id) {
    return seventhProcess(sixthProcess(fivethProcess(forthProcess(thirdProcess(secondProcess(firstProcess(new_id)))))));
  }

  private String firstProcess(String id) {
    return id.toLowerCase();
  }

  private String secondProcess(String id) {
    return id.replaceAll("[^a-z0-9-_.]", "");
  }

  private String thirdProcess(String id) {
    StringBuilder sb = new StringBuilder();
    boolean isFirst = true;
    for (char token : id.toCharArray()) {
      if (token == '.') {
        if (isFirst) {
          sb.append(token);
          isFirst = false;
        }
      } else {
        sb.append(token);
        isFirst = true;
      }
    }
    return sb.toString();
  }

  private String forthProcess(String id) {
    if (id.charAt(0) == '.') {
      id = id.substring(1);
    }

    if (!id.isEmpty() && id.charAt(id.length() - 1) == '.') {
      id = id.substring(0, id.length() - 1);
    }
    return id;
  }

  private String fivethProcess(String id) {
    return id.isEmpty() ? "a" : id;
  }

  private String sixthProcess(String id) {
    if (id.length() >= 16) {
      id = id.substring(0, 15);
    }
    if (id.charAt(id.length() - 1) == '.') {
      id = id.substring(0, id.length() - 1);
    }
    return id;
  }

  private String seventhProcess(String id) {
    StringBuilder sb = new StringBuilder(id);
    if (sb.length() <= 2) {
      char lastWord = sb.charAt(id.length() - 1);
      while (sb.length() != 3) {
        sb.append(lastWord);
      }
    }
    return sb.toString();
  }

}