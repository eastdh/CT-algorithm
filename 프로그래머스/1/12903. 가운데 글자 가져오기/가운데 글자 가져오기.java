class Solution {
  

  public String solution(String s) {
    int right = s.length() / 2 + 1;
    int left = s.length() % 2 == 0 ? right - 2 : right - 1;

    return s.substring(left, right);
  }
}
