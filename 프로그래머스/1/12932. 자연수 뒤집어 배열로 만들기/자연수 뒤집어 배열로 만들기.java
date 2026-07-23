import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public int[] solution(long n) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        String str = Long.toString(n);

        for (int i = str.length()-1; i >= 0; i--) {
            list.add(str.charAt(i) - '0');
        }
        answer = list
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();

        return answer;
    }
}