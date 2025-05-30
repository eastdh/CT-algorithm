import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int lines = Integer.parseInt(br.readLine());
        for (int i=1; i<=lines; i++) {
            String[] AB = br.readLine().split(" ");
            bw.write(Integer.parseInt(AB[0]) + Integer.parseInt(AB[1]) + "\n");
            //bw.flush();
        }
        bw.close();
    }
}