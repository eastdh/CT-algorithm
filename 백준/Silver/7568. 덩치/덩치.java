import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfPeople = Integer.parseInt(br.readLine());

        ArrayList<int[]> people = new ArrayList<>();
        for (int i=1; i<=numOfPeople; i++){
            String[] input = br.readLine().split(" ");
            people.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        ArrayList<String> index = new ArrayList<>();
        for (int[] a : people) {
            int count = 0;
            for (int[] b : people) {
                if (a[0] < b[0] && a[1] < b[1])
                    count++;
            }
            index.add(String.valueOf(count + 1));
        }

        System.out.println(String.join(" ", index));
    }
}