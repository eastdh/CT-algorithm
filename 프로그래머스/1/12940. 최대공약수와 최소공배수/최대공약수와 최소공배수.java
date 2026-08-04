class Solution {
  

  public int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    int max = Math.max(a, b);
    int min = Math.min(a, b);

    int r = max % min;
    return gcd(min, r);
  }

  public int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

  public int[] solution(int n, int m) {
    int[] answer = {gcd(n, m), lcm(n, m)};
    return answer;
  }
}
