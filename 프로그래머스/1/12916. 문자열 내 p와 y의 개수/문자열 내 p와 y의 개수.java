class Solution {
  

  public Boolean solution(String s) {

    int p = 0;
    int y = 0;

    String[] splitted = s.toLowerCase().split("");
    for (String str : splitted) {
      if (str.equals("p")) {
        p++;
      } else if (str.equals("y")) {
        y++;
      }
    }

    return p == y;
  }
}
