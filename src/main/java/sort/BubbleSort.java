package sort;

public class BubbleSort {

  public static void sort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          SortUtil.swap(array, j, j + 1);
        }
      }
    }
  }

}