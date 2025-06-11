import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[] dp = new int[N + 1];
    String[] log = new String[N + 1];

    dp[1] = 0;
    log[1] = "1";

    for (int i = 2; i < N + 1; i++) {
      int op1 = Integer.MAX_VALUE;
      int op2 = Integer.MAX_VALUE;
      int op3 = dp[i - 1];

      if (i % 3 == 0) {
        op1 = dp[i / 3];
      }
      if (i % 2 == 0) {
        op2 = dp[i / 2];
      }

      int min = Math.min(op1, Math.min(op2, op3));
      if (min == op1){
        log[i] = i + " " + log[i / 3];
      } else if (min == op2) {
        log[i] = i + " " + log[i / 2];
      } else {
        log[i] = i + " " + log[i - 1];
      }
      dp[i] = min + 1;
    }

    System.out.println(dp[N]);
    System.out.println(log[N]);

  }

}
