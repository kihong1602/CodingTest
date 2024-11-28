package programmers.PCCP_동영상_재생기;

public class Main {

  private static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
    Time total = new Time(video_len);
    Time start = new Time(op_start);
    Time end = new Time(op_end);
    Time now = new Time(pos);

    now.skip(start, end);

    for (String command : commands) {
      switch (command) {
        case "next":
          now.next(total);
          break;
        case "prev":
          now.prev();
          break;
      }
      now.skip(start, end);
    }

    return now.toString();
  }

  private static class Time implements Comparable<Time> {

    int minutes;
    int seconds;

    public Time(String value) {
      String[] inputs = value.split(":");
      minutes = Integer.parseInt(inputs[0]);
      seconds = Integer.parseInt(inputs[1]);
    }

    public void next(Time total) {
      seconds += 10;

      if (seconds >= 60) {
        minutes += 1;
        seconds -= 60;
      }

      if (this.compareTo(total) > 0) {
        minutes = total.minutes;
        seconds = total.seconds;
      }
    }

    public void prev() {
      seconds -= 10;
      if (seconds < 0) {
        minutes -= 1;
        seconds += 60;
      }

      if (minutes < 0) {
        minutes = 0;
        seconds = 0;
      }
    }

    public void skip(Time start, Time end) {
      if (this.compareTo(start) >= 0 && this.compareTo(end) <= 0) {
        minutes = end.minutes;
        seconds = end.seconds;
      }
    }

    @Override
    public int compareTo(Time other) {
      return this.minutes == other.minutes ?
          Integer.compare(this.seconds, other.seconds) : Integer.compare(this.minutes, other.minutes);
    }

    @Override
    public String toString() {
      return String.format("%02d:%02d", minutes, seconds);
    }
  }

}