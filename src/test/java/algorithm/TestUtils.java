package algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtils {

  private static final Logger log = LogManager.getLogger(TestUtils.class);

  public static void loggingExecutionTime(long start, long end) {
    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
    long executionTime = end - start;
    log.info("{} Execution Time: {} ms", methodName, executionTime);
  }
}