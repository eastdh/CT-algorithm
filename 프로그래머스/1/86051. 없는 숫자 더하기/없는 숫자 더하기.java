class Solution {
  

  public int solution(int[] numbers) {
    int answer = 0;
    int[] numCount = new int[10];
    for (int i : numbers) {
      numCount[i] = 1;
    }
    for (int i = 0; i < numCount.length; i++) {
      if (numCount[i] == 0) {
        answer += i;
      }
    }
    return answer;
  }
}
