import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] minutes = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    Arrays.sort(minutes);

    int[] waiting = minutes.clone();

    for (int i = 1; i < N; i++) {
      waiting[i] += waiting[i - 1];
    }
    
    int sum = 0;
    for (int w : waiting) {
      sum += w;
    }

    System.out.println(sum);
  }

}
