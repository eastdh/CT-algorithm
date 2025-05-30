import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfPaper = sc.nextInt();
        boolean[][] whitePaper = new boolean[100][100];
        int coloredArea = 0;

        for (int i=1; i<=numOfPaper; i++) {
            int left = sc.nextInt();
            int bottom = sc.nextInt();
            for (int l=left; l<left+10; l++) {
                for (int b=bottom; b<bottom+10; b++) {
                    if (!whitePaper[b][l]) {
                        whitePaper[b][l] = true;
                        coloredArea++;
                    }
                }
            }
        }

        System.out.println(coloredArea);
    }
}