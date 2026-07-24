import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[] solution(String myString) {
    String[] splitted = myString.split("x", -1);
    int[] answer = new int[splitted.length];
    for (int i = 0; i < splitted.length; i++) {
      answer[i] = splitted[i].length();
    }

    return answer;
  }
}
