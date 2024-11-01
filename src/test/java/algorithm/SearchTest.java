package algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import algorithm.search.BFS;
import algorithm.search.DFS;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest {

  private List<List<Integer>> graph;
  private boolean[] visited;

  @BeforeEach
  void init() {
    int n = 6;
    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    visited = new boolean[n + 1];

    graph.get(1).add(2);
    graph.get(2).add(5);
    graph.get(3).add(4);
    graph.get(4).add(6);
    graph.get(5).add(1);
  }

  @Test
  @DisplayName("DFS 테스트")
  void dfsTest() {
    //given
    final int expectedCount = 2;
    int result = 0;
    //when
    long start = System.currentTimeMillis();
    for (int node = 1; node <= 6; node++) {
      if (!visited[node]) {
        result++;
        DFS.dfs(node, graph, visited);
      }
    }
    long end = System.currentTimeMillis();

    //then
    assertThat(result).isEqualTo(expectedCount);
    TestUtils.loggingExecutionTime(start, end);
  }

  @Test
  @DisplayName("BFS 테스트")
  void bfsTest() {
    //given
    final int expectedCount = 2;
    int result = 0;
    //when
    long start = System.currentTimeMillis();
    for (int node = 1; node <= 6; node++) {
      if (!visited[node]) {
        result++;
        BFS.bfs(node, graph, visited);
      }
    }
    long end = System.currentTimeMillis();

    //then
    assertThat(result).isEqualTo(expectedCount);
    TestUtils.loggingExecutionTime(start, end);
  }


}