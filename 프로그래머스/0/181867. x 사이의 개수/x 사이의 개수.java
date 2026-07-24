import java.util.ArrayList;
import java.util.List;

class Solution {
  

  public int[] solution(String myString) {
    List<Integer> answer = new ArrayList<>();
    String[] splited = myString.split("x", -1);
    for (String s : splited) {
      answer.add(s.length());
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}
