import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfCase = Integer.parseInt(br.readLine());
        for (int i=0; i<numOfCase; i++) {
            int change = Integer.parseInt(br.readLine());
            int q = change/25;
            int d = change%25/10;
            int n = change%25%10/5;
            int p = change%25%10%5;
            bw.write(q + " " + d + " " + n + " " + p + "\n");
        }
        bw.flush();
        bw.close();
    }
}