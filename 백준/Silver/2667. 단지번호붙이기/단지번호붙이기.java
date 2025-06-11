import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  static int[][] map;
  static boolean[][] visited;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      map[i] = Arrays.stream(br.readLine().split(""))
          .mapToInt(Integer::parseInt)
          .toArray();
    }

    int danji = 0;
    ArrayList<Integer> houseCount = new ArrayList<>();

    for (int x = 0; x < N; x++) {
      for (int y = 0; y < N; y++) {
        if (check(x, y)) {
          danji++;
          houseCount.add(getNumOfHouse(x, y));
        }
      }
    }

    houseCount.sort(null);
    StringBuilder sb = new StringBuilder();
    for (int i : houseCount) {
      sb.append(i).append("\n");
    }

    System.out.println(danji);
    System.out.println(sb);
  }

  public static boolean check(int x, int y) {
    return x >= 0 && x < N
        && y >= 0 && y < N
        && map[x][y] == 1
        && !visited[x][y];
  }

  public static int getNumOfHouse(int x, int y) {
    if (!check(x, y)) {
      return 0;
    }
    visited[x][y] = true;

    int num = 1;
    num += getNumOfHouse(x + 1, y);
    num += getNumOfHouse(x, y + 1);
    num += getNumOfHouse(x - 1, y);
    num += getNumOfHouse(x, y - 1);

    return num;
  }

}
