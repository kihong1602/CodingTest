package sort;

public class SelectionSort {

  public static void sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[min] > array[j]) {
          min = j;
        }
      }
      if (i != min) {
        swap(array, i, min);
      }
    }
  }

  private static void swap(int[] array, int idx1, int idx2) {
    int tmp = array[idx1];
    array[idx1] = array[idx2];
    array[idx2] = tmp;
  }

}