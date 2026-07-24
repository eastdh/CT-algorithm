import java.util.Arrays;
import java.util.Collections;

class Solution {
  

  public long solution(long n) {
    long answer = 0;
    Integer[] nArr =
        Arrays.stream(Long.toString(n).split("")).map(Integer::valueOf).toArray(Integer[]::new);

    Arrays.sort(nArr, Collections.reverseOrder());

    answer =
        Long.parseLong(
            String.join("", Arrays.stream(nArr).map(String::valueOf).toArray(String[]::new)));
    return answer;
  }
}
