package programmers.최소공배수;

public class Main {

  public int solution(int[] arr) {
    int result = arr[0];

    for (int i = 1; i < arr.length; i++) {
      result = lcm(result, arr[i]);
    }

    return result;
  }

  private int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}