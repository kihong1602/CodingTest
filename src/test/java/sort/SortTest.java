package sort;

import static org.assertj.core.api.Assertions.assertThat;

import algorithm.sort.BubbleSort;
import algorithm.sort.CountingSort;
import algorithm.sort.InsertionSort;
import algorithm.sort.MergeSort;
import algorithm.sort.QuickSort;
import algorithm.sort.RadixSort;
import algorithm.sort.SelectionSort;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortTest {

  private static final Logger log = LogManager.getLogger(SortTest.class);

  private static int[] original;
  
  private int[] array;

  private int[] compare;

  @BeforeAll
  static void setup() {
    List<Integer> list = IntStream.rangeClosed(1, 150_000).boxed().collect(Collectors.toList());
    Collections.shuffle(list);
    original = list.stream().mapToInt(Integer::intValue).toArray();
  }

  @BeforeEach
  void init() {
    array = Arrays.copyOf(original, original.length);
    compare = Arrays.copyOf(original, original.length);
    Arrays.sort(compare);
  }

  @Test
  @DisplayName("버블 정렬 테스트")
  void bubbleSortTest() {
    //given when
    long start = System.currentTimeMillis();
    BubbleSort.sort(array);
    long end = System.currentTimeMillis();

    //then
    assertThat(array).isEqualTo(compare);
    loggingExecutionTime(start, end);
  }

  @Test
  @DisplayName("선택 정렬 테스트")
  void selectionSortTest() {
    //given when
    long start = System.currentTimeMillis();
    SelectionSort.sort(array);
    long end = System.currentTimeMillis();

    //then
    assertThat(array).isEqualTo(compare);
    loggingExecutionTime(start, end);
  }

  @Test
  @DisplayName("삽입 정렬 테스트")
  void insertionSortTest() {
    //given when
    long start = System.currentTimeMillis();
    InsertionSort.sort(array);
    long end = System.currentTimeMillis();

    //then
    assertThat(array).isEqualTo(compare);
    loggingExecutionTime(start, end);
  }

  @Test
  @DisplayName("퀵 정렬 테스트")
  void quickSortTest() {
    //given when
    long start = System.currentTimeMillis();
    QuickSort.sort(array);
    long end = System.currentTimeMillis();

    //then
    assertThat(array).isEqualTo(compare);
    loggingExecutionTime(start, end);
  }

  @Test
  @DisplayName("병합 정렬 테스트")
  void mergeSortTest() {
    //given when
    long start = System.currentTimeMillis();
    MergeSort.sort(array);
    long end = System.currentTimeMillis();

    //then
    assertThat(array).isEqualTo(compare);
    loggingExecutionTime(start, end);
  }

  @Test
  @DisplayName("기수 정렬 테스트")
  void radixSortTest() {
    //given when
    long start = System.currentTimeMillis();
    RadixSort.sort(array);
    long end = System.currentTimeMillis();

    //then
    assertThat(array).isEqualTo(compare);
    loggingExecutionTime(start, end);
  }

  @Test
  @DisplayName("카운팅 정렬 테스트")
  void countingSortTest() {
    //given when
    long start = System.currentTimeMillis();
    CountingSort.sort(array, 150_000);
    long end = System.currentTimeMillis();

    //then
    assertThat(array).isEqualTo(compare);
    loggingExecutionTime(start, end);
  }

  void loggingExecutionTime(long start, long end) {
    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
    long executionTime = end - start;
    log.info("{} Execution Time: {} ms", methodName, executionTime);
  }

}