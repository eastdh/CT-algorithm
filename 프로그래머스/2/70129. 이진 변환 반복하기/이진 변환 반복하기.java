class Solution {
  

  public int[] solution(String s) {
    int convertCount = 0;
    int zeroCount = 0;

    while (!s.equals("1")) {
      String afterRemove = s.replaceAll("0", "");
      convertCount++;
      zeroCount += s.length() - afterRemove.length();
      s = Integer.toBinaryString(afterRemove.length());
    }
    int[] answer = {convertCount, zeroCount};
    return answer;
  }
}
