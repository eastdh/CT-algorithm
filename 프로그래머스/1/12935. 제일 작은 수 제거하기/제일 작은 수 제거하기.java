class Solution {
  

  public int[] solution(int[] arr) {
    if (arr.length <= 1) {
      int[] answer = {-1};
      return answer;
    }

    int min = Integer.MAX_VALUE;
    for (int i : arr) {
      min = min > i ? i : min;
    }

    int[] answer = new int[arr.length - 1];
    int index = 0;
    for (int i : arr) {
      if (i == min) {
        continue;
      }
      answer[index++] = i;
    }

    return answer;
  }
}
