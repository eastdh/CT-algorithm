class Solution {
  

  public int solution(int[] arr1, int[] arr2) {
    int answer;
    int sum1 = 0;
    for (int i : arr1) {
      sum1 += i;
    }
    int sum2 = 0;
    for (int i : arr2) {
      sum2 += i;
    }

    if (arr1.length > arr2.length) {
      answer = 1;
    } else if (arr1.length < arr2.length) {
      answer = -1;
    } else if (sum1 > sum2) {
      answer = 1;
    } else if (sum1 < sum2) {
      answer = -1;
    } else {
      answer = 0;
    }
    return answer;
  }
}
