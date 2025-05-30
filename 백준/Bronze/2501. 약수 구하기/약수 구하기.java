import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> yaksoo = new ArrayList<>();
        for (int i=1; i<=Math.sqrt(num); i++) {
            if (num%i == 0) {
                yaksoo.add(i);
                if (i != num/i) {
                    yaksoo.add(num / i);
                }
            }
        }
        yaksoo.sort(Comparator.naturalOrder());
//        System.out.println(yaksoo);
        if (yaksoo.size() < k) {
            System.out.println(0);
        } else {
            System.out.println(yaksoo.get(k-1));
        }
    }
}