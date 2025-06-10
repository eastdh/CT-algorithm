import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (arr[mid] == target)
        return 1;
      else if (arr[mid] < target)
        left = mid + 1;
      else if (arr[mid] > target)
        right = mid - 1;
    }

    return 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// N 입력
    int N = Integer.parseInt(br.readLine());
// A 배열 입력받기
    int[] A = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    Arrays.sort(A);

// M 입력
    int M = Integer.parseInt(br.readLine());
// B 배열 입력받기
    int[] B = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    for (int target : B)
      System.out.println(binarySearch(A, target));


  }

}
