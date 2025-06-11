import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//  region 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // N 물품의 수
    int K = Integer.parseInt(st.nextToken()); // K 버틸 수 있는 무게

    int[][] items = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer itemToken = new StringTokenizer(br.readLine());
      items[i][0] = Integer.parseInt(itemToken.nextToken()); // W 무게
      items[i][1] = Integer.parseInt(itemToken.nextToken()); // V 가치
    }
//  endregion 입력

    int[] packs = new int[K + 1];

    for (int[] item : items) {
      int itemWeight = item[0];
      int itemValue = item[1];

      for (int i = K; i >= itemWeight; i--) {
        // 가장 큰 가방부터 비교: 기존 가방 가치 vs. (현재 item이 안 들어 있는 작은 가방 가치 + 현재 item 가치)
        packs[i] = Math.max(packs[i], packs[i - itemWeight] + itemValue);
      }
    }
//    System.out.println(Arrays.toString(packs));
    System.out.println(packs[K]);
  }


}
