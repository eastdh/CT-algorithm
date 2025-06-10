import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer> decks = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      decks.add(Integer.parseInt(br.readLine()));
    }
    decks.sort(null);

    ArrayList<Integer> compares = new ArrayList<>();
    while (decks.size() > 1) {
      int plus = decks.remove(0) + decks.remove(0);
      compares.add(plus);
      decks.add(getIndex(decks, plus), plus);
    }

    int sum = 0;
    for (int c : compares) {
      sum += c;
    }

    System.out.println(sum);

  }

  public static int getIndex(ArrayList<Integer> decks, int plus) {
    int left = 0 , right = decks.size();

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (decks.get(mid) == plus)
        return mid;
      else if (decks.get(mid) < plus)
        left = mid + 1;
      else
        right = mid;
    }

    return left;
  }

}
