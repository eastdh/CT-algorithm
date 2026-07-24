import java.util.ArrayList;
import java.util.List;

class Solution {
  

  public int[] solution(int[] arr) {
    List<Integer> answer = new ArrayList<>();

    for (int n : arr) {
      for (int i = 0; i < n; i++) {
        answer.add(n);
      }
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}
