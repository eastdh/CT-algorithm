import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int row=1; row<=n; row++) {
            for (int star=1; star<=row; star++) {
                System.out.print("*");
            }
            for (int space=1; space<=2*(n-row); space++) {
                System.out.print(" ");
            }
            for (int star=1; star<=row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row=n-1; row>0; row--) {
            for (int star=1; star<=row; star++) {
                System.out.print("*");
            }
            for (int space=1; space<=2*(n-row); space++) {
                System.out.print(" ");
            }
            for (int star=1; star<=row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}