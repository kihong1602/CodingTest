package sort;

public class QuickSort {

  public static void sort(int[] array) {
    pivotSort(array, 0, array.length - 1);
  }

  private static void pivotSort(int[] array, int start, int end) {
    if (start >= end) {
      // 이미 정렬이 완료되었으므로 return
      return;
    }

    int pivot = partition(array, start, end); // 배열을 분할하기 위한 pivot 설정
    pivotSort(array, start, pivot); // pivot 기준 왼쪽 분할배열 정렬
    pivotSort(array, pivot + 1, end); // pivot 기준 오른쪽 분할배열 정렬
  }

  private static int partition(int[] array, int left, int right) {
    int lo = left;
    int hi = right;

    int pivot = array[(left + right) / 2]; // 중간값을 pivot으로 설정

    // lo가 hi와 만날때까지 반복
    while (lo <= hi) {
      // array[lo]가 pivot보다 커질 때까지 증가
      while (array[lo] < pivot) {
        lo++;
      }

      // array[hi]가 pivot보다 작을 때까지 감소
      while (array[hi] > pivot) {
        hi--;
      }

      if (lo <= hi) {
        // 증가시킨 lo와 hi의 값을 swap
        SortUtil.swap(array, lo, hi);
        lo++;
        hi--;
      }
    }
    return lo - 1;  // 마지막으로 swap한 lo는 증가연산자가 적용되었으므로 -1을 진행
  }
}