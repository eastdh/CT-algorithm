import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int row = 0, col = 0;
        for (int r=1; r<=9; r++) {
            for (int c=1; c<=9; c++) {
                int num = sc.nextInt();
                if (num > max) {
                    max = num;
                    row = r;
                    col = c;
                }
            }
        }
        System.out.println(max);
        System.out.println(row + " " + col);
    }
}