class Solution {
  public int[] solution(int[] arr, int n) {
    int odd = arr.length % 2 == 1 ? 0 : 1;

    for (int i = 0; i < arr.length; i++) {
      if (i % 2 == odd) {
        arr[i] += n;
      }
    }

    return arr;
  }
}
