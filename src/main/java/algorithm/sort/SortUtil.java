package algorithm.sort;

public class SortUtil {

  private SortUtil() {
  }

  public static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

}