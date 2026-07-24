class Solution {
  

  public String[] solution(String my_string) {
    String[] answer = my_string.trim().replaceAll(" +", " ").split(" ");
    return answer;
  }
}
