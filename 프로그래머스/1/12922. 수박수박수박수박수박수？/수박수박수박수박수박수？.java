class Solution {
  

  public String solution(int n) {
    String answer = "";
    String subak;
    for (int i = 0; i < n; i++) {
      subak = i % 2 == 0 ? "수" : "박";
      answer += subak;
    }
    return answer;
  }
}
