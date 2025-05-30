import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double timeSum = 0;
        double scoreSum = 0;
        for (int i=0; i<20; i++) {
            String[] line = br.readLine().split(" ");
            if (line[2].equals("P"))
                continue;
            double time = Double.parseDouble(line[1]);
            double score = 0;
            switch (line[2]) {
                case "A+":
                    score += 0.5;
                case "A0":
                    score += 0.5;
                case "B+":
                    score += 0.5;
                case "B0":
                    score += 0.5;
                case "C+":
                    score += 0.5;
                case "C0":
                    score += 0.5;
                case "D+":
                    score += 0.5;
                case "D0":
                    score += 1.0;
                case "F":
                    break;

            }

            scoreSum += score * time;
            timeSum += time;
        }

        System.out.print(scoreSum / timeSum);
    }
}