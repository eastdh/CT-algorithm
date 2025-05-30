import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int numOfBasket = Integer.parseInt(NM[0]);
        int numOfPivot = Integer.parseInt(NM[1]);

        String[] baskets = new String[numOfBasket];
        for (int i=0; i<numOfBasket; i++) {
            baskets[i] = String.valueOf(i + 1);
        }

        for (int piv=0; piv<numOfPivot; piv++) {
            String[] IJ = br.readLine().split(" ");
            int left = Integer.parseInt(IJ[0]) - 1;
            int right = Integer.parseInt(IJ[1]) - 1;

            for (int i=0; i<(right-left+1)/2; i++) {
                String temp = baskets[left + i];
                baskets[left + i] = baskets[right - i];
                baskets[right - i] = temp;
            }
        }

        bw.write(String.join(" ", baskets));
        bw.close();
    }
}