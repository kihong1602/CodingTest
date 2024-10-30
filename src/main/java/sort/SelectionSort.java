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
        SortUtil.swap(array, i, min);
      }
    }
  }

}