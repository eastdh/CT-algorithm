import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] paper;
  static int white = 0;
  static int blue = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//  region 입력
    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }
//  endregion 입력

    divider(0, 0, N);
    System.out.println(white);
    System.out.println(blue);
  }

  public static void divider(int x, int y, int size) {
    if (isSameColor(x, y, size)) {
      if (paper[x][y] == 0) {
        white++;
      } else {
        blue++;
      }
      return;
    }

    int newSize = size / 2;
    divider(x, y, newSize);
    divider(x + newSize, y, newSize);
    divider(x, y + newSize, newSize);
    divider(x + newSize, y + newSize, newSize);
  }

  public static boolean isSameColor(int x, int y, int size) {
    int color = paper[x][y];
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (paper[i][j] != color) {
          return false;
        }
      }
    }

    return true;
  }

}
