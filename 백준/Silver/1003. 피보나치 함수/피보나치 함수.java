import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      int[] fibo = fibonacci(N);
      sb.append(fibo[N]).append(" ").append(fibo[N + 1]).append("\n");
    }

    System.out.println(sb);
  }

  // 시간 초과
//  public static int fibonacci(int N) {
//    if (N == 0) {
//      zeros++;
//      return 0;
//    } else if (N == 1) {
//      ones++;
//      return 1;
//    } else {
//      return fibonacci(N - 1) + fibonacci(N - 2);
//    }
//  }

  public static int[] fibonacci(int N) {
    int[] fibo = new int[N + 3];
    fibo[0] = 1;
    fibo[1] = 0;
    fibo[2] = 1;
    for (int i = 3; i < N + 3; i++) {
      fibo[i] = fibo[i - 1] + fibo[i - 2];
    }

    return fibo;
  }
}
