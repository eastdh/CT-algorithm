import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int numOfBasket = Integer.parseInt(NM[0]);
        int numOfSwitch = Integer.parseInt(NM[1]);

        ArrayList<String> baskets = new ArrayList<>();
        for (int i=0; i<numOfBasket; i++) {
            baskets.add(String.valueOf(i+1));
        }

        for (int swt=0; swt<numOfSwitch; swt++) {
            String[] IJ = br.readLine().split(" ");
            int left = Integer.parseInt(IJ[0]) - 1;
            int right = Integer.parseInt(IJ[1]) - 1;

            String temp = baskets.get(left);
            baskets.set(left, baskets.get(right));
            baskets.set(right, temp);
        }

        bw.write(String.join(" ", baskets));
        bw.close();
        }
}