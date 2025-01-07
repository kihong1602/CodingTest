package programmers.가장큰수;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

  public String solution(int[] numbers) {
    String result = Arrays.stream(numbers)
                          .mapToObj(String::valueOf)
                          .sorted((a, b) -> (b + a).compareTo(a + b))
                          .collect(Collectors.joining());
    return result.charAt(0) == '0' ? "0" : result;
  }

}