import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int row=1; row<=n-1; row++) {
            for (int space=n-row; space>=1; space--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int space=1; space<=2*(row-1)-1; space++) {
                System.out.print(" ");
            }
            if (row>=2) {
                System.out.print("*");
            }
            System.out.println();
        }

        // last line
        for (int star=1; star<=2*n-1; star++) {
            System.out.print("*");
        }
    }
}