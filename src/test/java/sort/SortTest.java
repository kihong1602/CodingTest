package sort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortTest {

  private static final Logger log = LogManager.getLogger(SortTest.class);

  private int[] array;

  private int[] compare;

  @BeforeEach
  void init() {
    List<Integer> list = IntStream.rangeClosed(1, 50_000).boxed().collect(Collectors.toList());
    Collections.shuffle(list);
    array = list.stream().mapToInt(Integer::intValue).toArray();
    compare = Arrays.copyOf(array, array.length);
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

  void loggingExecutionTime(long start, long end) {
    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
    long executionTime = end - start;
    log.info("{} Execution Time: {} ms", methodName, executionTime);
  }

}