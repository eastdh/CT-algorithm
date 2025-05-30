import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 3; i++) {
      int N = Integer.parseInt(reader.readLine());
      BigInteger sum = BigInteger.ZERO;
      for (int j = 0; j < N; j++) {
        sum = sum.add(new BigInteger(reader.readLine()));
      }
      char result = (sum.equals(BigInteger.ZERO) ? '0' : (sum.compareTo(BigInteger.ZERO) > 0 ? '+' : '-'));
      System.out.println(result);
    }

    reader.close();
  }

}
