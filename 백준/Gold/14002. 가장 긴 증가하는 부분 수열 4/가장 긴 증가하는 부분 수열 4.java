import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    int[] currentLength = new int[N];
    Arrays.fill(currentLength, 1);
    String[] currentLine = new String[N];
    int[] beforeIDX = new int[N];
    Arrays.fill(beforeIDX, -1);

    int maxLength = 0;
    String maxLine = "";
    for (int i = 0; i < N; i++) {
      currentLine[i] = String.valueOf(arr[i]);
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          if (currentLength[i] < currentLength[j] + 1) {
            currentLength[i] = currentLength[j] + 1;
            currentLine[i] = currentLine[j] + " " + arr[i];
          }
        }
      }
      if (currentLength[i] > maxLength) {
        maxLength = currentLength[i];
        maxLine = currentLine[i];
      }
    }

    System.out.println(maxLength);
    System.out.println(maxLine);
  }

}
