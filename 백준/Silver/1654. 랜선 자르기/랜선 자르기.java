import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] KN = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    int K = KN[0];
    int N = KN[1];

    long[] kLAN = new long[K];
    for (int i = 0; i < K; i++) {
      kLAN[i] = Long.parseLong(br.readLine());
    }
    Arrays.sort(kLAN);

    System.out.println(findNLength(kLAN, N));
  }

  public static long findNLength(long[] kLAN, int N) {
    long lo = 1;
    long hi = kLAN[kLAN.length-1];
    long result = 1;

//    최초의 lo, hi 찾기
    for (int i = 0; i < kLAN.length; i++) {
      long nLength = kLAN[i];
      if (getNCount(kLAN, nLength) < N) {
        if (i != 0) {
          lo = kLAN[i - 1];
        }
        hi = kLAN[i];
        break;
      }
    }

    while (lo <= hi) {
      long mid = lo + (hi - lo) / 2;
//      System.out.printf("%d %d %d\n", lo, mid, hi);
      if (getNCount(kLAN, mid) < N) {
        hi = mid - 1;
      } else {
        result = mid;
        lo = mid + 1;
      }
    }

    return result;
  }

  public static int getNCount(long[] kLAN, long nLength) {
    int count = 0;
    for (long k : kLAN) {
      count += (int) (k / nLength);
    }

//    System.out.println(count);
    return count;
  }

}
