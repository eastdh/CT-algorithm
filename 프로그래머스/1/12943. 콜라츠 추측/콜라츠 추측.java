class Solution {
  

  public int solution(int n) {
    int answer = 0;
    long nl = n;
    while (nl > 1) {
      if (answer++ >= 500) {
        answer = -1;
        break;
      }
      if (nl % 2 == 0) {
        nl /= 2;
      } else {
        nl = nl * 3 + 1;
      }
      // System.out.println(n);
    }
    return answer;
  }
}
