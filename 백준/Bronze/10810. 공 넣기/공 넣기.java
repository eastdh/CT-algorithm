import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int numOfBasket = Integer.parseInt(NM[0]);
        int numOfPut = Integer.parseInt(NM[1]);

        ArrayList<String> baskets = new ArrayList<>();
        for (int i=0; i<numOfBasket; i++) {
            baskets.add("0");
        }
        for (int put=1; put<=numOfPut; put++) {
            String[] IJK = br.readLine().split(" ");
            int startBasket = Integer.parseInt(IJK[0]);
            int endBasket = Integer.parseInt(IJK[1]);
            String  ballNumber = IJK[2];

            for (int basket=startBasket; basket<=endBasket; basket++) {
                baskets.set(basket-1, ballNumber);
            }
        }

        bw.write(String.join(" ", baskets));
        bw.flush();
        bw.close();
    }
}