import java.util.ArrayList;
import java.util.List;

class Solution {
  

  public int[] solution(String myString) {
    List<Integer> answer = new ArrayList<>();
    for (String s : myString.split("x", -1)) {
      answer.add(s.length());
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}
