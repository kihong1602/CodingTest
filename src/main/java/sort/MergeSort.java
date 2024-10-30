package sort;

public class MergeSort {

  /*
   * Bottom-Up 방식의 MergeSort 구현방법
   * 1. 배열의 크기를 1, 2, 4, 8, ... 방식으로 늘려가며 반복문을 통해 병합한다. 처음에는 각 요소를 크기 1의 부분 배열로 간주하고, 점차적으로 병합 크기를 늘려나간다.
   * 2. 시작점(lo)는 0부터 시작, 범위는 end - size, lo는 size * 2씩 더해가며 증가한다. lo는 현재 부분 배열의 시작점을 나타낸다.
   * 3. 중간지점(mid)은 lo + size - 1로 설정하여, 현재 병합할 크기 size의 부분 배열의 끝을 의미한다.
   * 4. 끝점(hi)은 lo + size * 2 - 1과 end 중 작은 값으로 설정하여 배열의 끝을 넘어가지 않도록 한다.
   * 5. 두 부분 배열을 병합하기 위해 merge 메서드를 호출한다.
   * 6. merge 메서드 내부에서 왼쪽 부분 배열의 인덱스는 start, 오른쪽 부분 배열의 인덱스는 mid + 1로 설정한다.
   * 7. 왼쪽 인덱스가 mid 이하이고, 오른쪽 인덱스가 end 이하인 동안 반복하여 두 부분 배열을 병합한다.
   * 8. array[left] <= array[right]일 시, sorted 배열에 array[left] 값을 추가한다.
   * 9. 병합 후에는 원래 배열에 반영하기 위해 sorted의 값을 array로 복사한다.
   */

  private static int[] sorted;

  public static void sort(int[] array) {
    sorted = new int[array.length];

    mergeSort(array, 0, array.length - 1);

    sorted = null;
  }

  private static void mergeSort(int[] array, int start, int end) {
    for (int size = 1; size <= end; size += size) {
      for (int lo = 0; lo <= end - size; lo += (size * 2)) {
        int mid = lo + size - 1;
        int hi = Math.min(lo + (size * 2) - 1, end);
        merge(array, lo, mid, hi);
      }
    }
  }

  private static void merge(int[] array, int start, int mid, int end) {
    int left = start;
    int right = mid + 1;
    int idx = start;

    while (left <= mid && right <= end) {
      if (array[left] <= array[right]) {
        sorted[idx] = array[left];
        idx++;
        left++;
      } else {
        sorted[idx] = array[right];
        idx++;
        right++;
      }
    }

    if (left > mid) {
      while (right <= end) {
        sorted[idx] = array[right];
        idx++;
        right++;
      }
    } else {
      while (left <= mid) {
        sorted[idx] = array[left];
        idx++;
        left++;
      }
    }

    for (int i = start; i <= end; i++) {
      array[i] = sorted[i];
    }
  }

  public static void main(String[] args) {
    int[] array = new int[]{9, 5, 7, 1, 8, 3, 6, 4, 10, 2};
    sort(array);
  }

}