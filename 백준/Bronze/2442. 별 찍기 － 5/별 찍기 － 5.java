import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int row=1; row<=n; row++) {
            for (int space=1; space<=n-row; space++) {
                System.out.print(" ");
            }
            for (int star=1; star<=2*row-1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}