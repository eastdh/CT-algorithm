import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i=1; i<=3; i++) {
            char yut = 'A';
            switch (sc.nextLine().replaceAll("[1 ]", "").length()) {
                case 0:
                    yut = 'E';
                    break;
                case 1:
                    yut = 'A';
                    break;
                case 2:
                    yut = 'B';
                    break;
                case 3:
                    yut = 'C';
                    break;
                case 4:
                    yut = 'D';
                    break;
            }
            System.out.println(yut);
        }
    }
}