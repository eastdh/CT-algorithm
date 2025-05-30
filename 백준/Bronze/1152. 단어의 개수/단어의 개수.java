import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().strip().split(" ");

        if (s[0].isEmpty()) {
            System.out.print(0);
            return;
        }
        System.out.print(s.length);
    }
}