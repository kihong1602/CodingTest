package algorithm.sort;

public class CountingSort {

  public static void sort(int[] array, int range) {
    int[] count = new int[range + 1];

    for (int value : array) {
      count[value]++;
    }

    int idx = 0;
    for (int i = 1; i < count.length; i++) {
      int size = count[i];
      while (size-- > 0) {
        array[idx++] = i;
      }
    }

  }

}