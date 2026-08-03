import java.util.Arrays;

class Solution {
  

  public String solution(String s) {
    int[] chars = s.chars().toArray();
    Arrays.sort(chars);
    String answer = "";
    for (int i = chars.length - 1; i >= 0; i--) {
      answer += (char) chars[i];
    }
    return answer;
  }
}
