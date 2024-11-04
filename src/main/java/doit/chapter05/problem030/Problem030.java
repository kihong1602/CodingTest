package doit.chapter05.problem030;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem030 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int n = Integer.parseInt(size[0]);
      int m = Integer.parseInt(size[1]);
      String[] inputs = br.readLine().split(" ");

      int left = 0;
      int right = 0;
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = Integer.parseInt(inputs[i]);
        left = Math.max(left, array[i]); // left: 블루레이에 들어갈 레슨의 최소 길이 -> 가장 큰 레슨이 left
        right += array[i]; // right: 블루레이에 들어갈 레슨의 최대 길이 -> 모든 레슨 길이의 합
      }

      while (left <= right) {
        int mid = left + (right - left) / 2;

        if (canRecord(array, n, m, mid)) {
          right = mid - 1; // 다 담긴다면 더 작은 크기에서도 담을 수 있는지 확인하기 위해 right 감소
        } else {
          left = mid + 1; // 다 안담긴다면 더 큰 크기에서 담아야하므로 left 증가
        }
      }

      bw.write(String.valueOf(left));
      bw.flush();

    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static boolean canRecord(int[] array, int n, int m, int maxSize) {
    int count = 1; // 블루레이 갯수
    int sum = 0; // 블루레이에 담기는 레슨의 길이 합
    for (int i = 0; i < n; i++) {
      if (sum + array[i] > maxSize) { // 블루레이의 최대크기(maxSize)보다 크다면
        count++; // 블루레이 갯수를 증가시키고
        sum = array[i]; // 다음 블루레이에 이번 레슨을 넣어야하므로 sum 값 변경
        if (count > m) { // 만약 블루레이 갯수가 최대갯수를 넘겼다면 false 반환
          return false;
        }
      } else {
        sum += array[i]; // 블루레이 최대크기보다 작으므로 sum에 레슨 추가
      }
    }
    return true; // 다 담긴다면 true 반환
  }


}