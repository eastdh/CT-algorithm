import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] times = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      times[i][0] = Integer.parseInt(st.nextToken());
      times[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(times, (a, b) -> {
      if (a[1] == b[1]) {
        return a[0] - b[0];
      }
      return a[1] - b[1];
    });
//    System.out.println(Arrays.deepToString(times));

    int count = 0;
    int endTime = 0;
    for (int[] time : times) {
      if (time[0] >= endTime) {
        count++;
        endTime = time[1];
      }
    }

    System.out.println(count);
  }

}
