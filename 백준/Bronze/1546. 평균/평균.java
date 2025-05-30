import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfSubject = Integer.parseInt(br.readLine());
        String[] scores = br.readLine().split(" ");

        double[] newScoreOfSubjects = new double[scores.length];
        double maxScore = Double.MIN_VALUE;
        for (int i=0; i<scores.length; i++) {
            double newScore = Double.parseDouble(scores[i]);
            newScoreOfSubjects[i] = newScore;
            maxScore = Math.max(newScore, maxScore);
        }

        double newSum = 0;
        for (int i=0; i<newScoreOfSubjects.length; i++) {
            newScoreOfSubjects[i] *= 100/maxScore;
            newSum += newScoreOfSubjects[i];
        }

        System.out.print(newSum/numOfSubject);
    }
}