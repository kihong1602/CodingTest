package algorithm.sort;

public class MergeSort {

  private static int[] sorted;

  public static void sort(int[] array) {
    sorted = new int[array.length];
    mergeSort(array, array.length);
    sorted = null;
  }

  private static void mergeSort(int[] array, int range) {
    for (int size = 1; size < range; size *= 2) {
      for (int start = 0; start < range; start += (size * 2)) {
        int mid = Math.min(start + size, range);
        int end = Math.min(start + (size * 2), range);
        merge(array, start, mid, end);
      }
    }
  }

  private static void merge(int[] array, int start, int mid, int end) {
    int left = start;
    int right = mid;
    int idx = start;

    while (left < mid && right < end) {
      sorted[idx++] = array[left] < array[right] ? array[left++] : array[right++];
    }

    while (left < mid) {
      sorted[idx++] = array[left++];
    }

    while (right < end) {
      sorted[idx++] = array[right++];
    }

    for (int i = start; i < end; i++) {
      array[i] = sorted[i];
    }
  }

}