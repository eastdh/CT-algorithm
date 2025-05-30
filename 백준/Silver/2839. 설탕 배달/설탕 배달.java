import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sugarWeight = sc.nextInt();
        for (int fiveKG = sugarWeight/5; fiveKG>=0; fiveKG--) {
            int remainingSugar = sugarWeight - fiveKG*5;
            if (remainingSugar % 3 == 0) {
                System.out.println(fiveKG + remainingSugar/3);
                return;
            }
        }
        System.out.println(-1);
    }
}