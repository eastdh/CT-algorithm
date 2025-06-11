import java.util.Scanner;

public class Main {

  static char[][] stars;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    stars = new char[N][N];
    makeStar(0, 0, N);

    StringBuilder sb = new StringBuilder();
    for (char[] row : stars) {
      for (char c : row) {
        sb.append(c);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static void makeStar(int x, int y, int N) {
    if (N == 1) {
      stars[x][y] = '*';
      return;
    }

    int newN = N / 3;

    // Line 1
    for (int i = 0; i < 3; i++) {
      makeStar(x + newN * i, y, newN);
    }

    // Line 2
    makeStar(x, y + newN, newN);
    makeSpace(x + newN, y + newN, newN);
    makeStar(x + newN * 2, y + newN, newN);

    // Line 3
    for (int i = 0; i < 3; i++) {
      makeStar(x + newN * i, y + newN * 2, newN);
    }

  }

  public static void makeSpace(int x, int y, int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        stars[x + i][y + j] = ' ';
      }
    }
  }
}
