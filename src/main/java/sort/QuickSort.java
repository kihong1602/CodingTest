package sort;

public class QuickSort {

  public static void sort(int[] array) {
    pivotSort(array, 0, array.length - 1);
  }

  private static void pivotSort(int[] array, int lo, int hi) {
    if (lo >= hi) {
      return; // 정렬할 구간이 더 이상 없으면 재귀 종료
    }

    // pivot 기준으로 배열을 나누고, 나눈 부분을 재귀적으로 정렬
    int pivot = partition(array, lo, hi);
    pivotSort(array, lo, pivot); // pivot 왼쪽부분 정렬
    pivotSort(array, pivot + 1, hi); // pivot 오른쪽부분 정렬
  }

  private static int partition(int[] array, int left, int right) {
    // lo, hi는 시작과 끝에서 출발하고, 탐색할 범위를 설정
    int lo = left - 1;
    int hi = right + 1;

    // 배열의 중간 인덱스 값을 pivot 설정
    int pivot = array[(left + right) / 2];

    while (true) {

      // lo가 pivot보다 큰 값을 만날 때까지 증가
      do {
        lo++;
      } while (array[lo] < pivot);

      // hi가 pivot보다 작은 값을 만날 때까지 감소
      do {
        hi--;
      } while (array[hi] > pivot);

      // 만약 lo가 hi와 같거나 크다면 탐색 종료, hi를 반환
      if (lo >= hi) {
        return hi;
      }

      // lo < hi인 경우, swap 진행
      SortUtil.swap(array, lo, hi);
    }
  }

}