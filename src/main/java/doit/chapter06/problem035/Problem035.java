package doit.chapter06.problem035;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem035 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      List<MeetingInfo> list = new ArrayList<>(size);

      for (int i = 0; i < size; i++) {
        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);
        list.add(new MeetingInfo(start, end));
      }

      Collections.sort(list);

      int count = 0;
      int end = -1;
      for (MeetingInfo meetingInfo : list) {
        if (meetingInfo.start >= end) {
          end = meetingInfo.end;
          count++;
        }
      }

      bw.write(String.valueOf(count));
      bw.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  private static class MeetingInfo implements Comparable<MeetingInfo> {

    int start;
    int end;

    public MeetingInfo(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(MeetingInfo other) {
      if (this.end == other.end) {
        return this.start - other.start;
      }
      return this.end - other.end;
    }
  }

}