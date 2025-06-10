import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int K = scanner.nextInt();

    int[] coins = new int[N];
    for (int i = 0; i < N; i++) {
      coins[i] = scanner.nextInt();
    }

    int count = 0;
    for (int i = coins.length-1; i >= 0; i--) {
      count += K / coins[i];
      K %= coins[i];
    }

    System.out.println(count);
  }

}
