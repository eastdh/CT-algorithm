class Solution {
  

  public long solution(int price, int money, int count) {
    long sum = 0;
    for (int i = 1; i <= count; i++) {
      sum += i;
    }
    sum *= price;
    long answer = money - sum;
    if (answer > 0) {
      answer = 0;
    } else {
      answer *= -1;
    }
    return answer;
  }
}
