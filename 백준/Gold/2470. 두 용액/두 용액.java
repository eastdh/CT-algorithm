import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] solutions = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    Arrays.sort(solutions);

    System.out.println(getMinimalAbs(solutions));

  }

  public static String getMinimalAbs(int[] solutions) {
    int minABS = Integer.MAX_VALUE;
    int left = 0;
    int right = solutions.length - 1;
    int leftValue = solutions[left];
    int rightValue = solutions[right];

    while (left < right) {
      int temp = solutions[right] + solutions[left];
      if (Math.abs(temp) < minABS) {
        minABS = Math.abs(temp);
        leftValue = solutions[left];
        rightValue = solutions[right];
      }

      if (temp > 0) {
        right--;
      } else if (temp < 0) {
        left++;
      } else {
        break;
      }
    }

    return leftValue + " " + rightValue;
  }
}
