package algorithm.sort;

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
    pivotSort(array, start, pivot - 1); // pivot 기준 왼쪽 분할배열 정렬
    pivotSort(array, pivot + 1, end); // pivot 기준 오른쪽 분할배열 정렬
  }

  private static int partition(int[] array, int left, int right) {
    int lo = left;
    int hi = right - 1;
    int pivotIndex = (left + right) / 2;
    int pivot = array[pivotIndex]; // 중간값을 pivot으로 설정

    SortUtil.swap(array, pivotIndex, right);  // pivot을 맨 오른쪽으로 이동

    // lo가 hi와 만날때까지 반복
    while (lo <= hi) {
      // array[lo]가 pivot보다 커질 때까지 증가
      while (lo <= hi && array[lo] < pivot) {
        lo++;
      }

      // array[hi]가 pivot보다 작을 때까지 감소
      while (lo <= hi && array[hi] > pivot) {
        hi--;
      }

      if (lo <= hi) {
        // 증가시킨 lo와 hi의 값을 swap
        SortUtil.swap(array, lo, hi);
        lo++;
        hi--;
      }
    }

    SortUtil.swap(array, lo, right); // pivot을 다시 중앙으로 이동
    return lo; // pivot 최종 위치 return
  }
}