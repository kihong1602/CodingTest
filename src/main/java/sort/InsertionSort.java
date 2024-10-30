package sort;

public class InsertionSort {

  public static void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int insertIndex = i - 1;
      int insertValue = array[i];

      while (insertIndex >= 0 && array[insertIndex] > insertValue) {
        array[insertIndex + 1] = array[insertIndex];
        insertIndex--;
      }

      array[insertIndex + 1] = insertValue;
    }
  }
}