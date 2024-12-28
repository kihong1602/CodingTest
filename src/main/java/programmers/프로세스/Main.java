package programmers.프로세스;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public int solution(int[] priorities, int location) {
    Queue<Process> queue = new LinkedList<>();
    Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < priorities.length; i++) {
      queue.add(new Process(i, priorities[i]));
      priorityQueue.add(priorities[i]);
    }

    int count = 0;
    while (!queue.isEmpty()) {
      Process current = queue.poll();

      if (current.priority == priorityQueue.peek()) {
        count++;
        priorityQueue.poll();
        if (current.index == location) {
          break;
        }
      } else {
        queue.add(current);
      }
    }
    
    return count;
  }


  private static class Process {

    int index;
    int priority;

    public Process(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }

  }

}