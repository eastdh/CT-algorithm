import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] ABV = sc.nextLine().split(" ");

        int up = Integer.parseInt(ABV[0]);
        int down = Integer.parseInt(ABV[1]);
        int height = Integer.parseInt(ABV[2]);

        int day = (height-up) / (up-down);
        if ((height-up) % (up-down) == 0) {
            System.out.print(day + 1);
        } else {
            System.out.print(day + 2);
        }
    }
}