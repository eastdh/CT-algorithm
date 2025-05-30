import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dices = sc.nextLine().split(" ");
        ArrayList<Integer> diceCount = new ArrayList<>();
        for (int i=0; i<7; i++)
            diceCount.add(0);

        int maxCount = Integer.MIN_VALUE;
        for (String dice : dices) {
            int diceValue = Integer.parseInt(dice);
            diceCount.set(diceValue, diceCount.get(diceValue) + 1);
            maxCount = maxCount > diceCount.get(diceValue) ? maxCount : diceCount.get(diceValue);
        }

        int price = 0;
        switch (maxCount) {
            case 1:
                price = diceCount.lastIndexOf(1) * 100;
                break;
            case 2:
                price = 1000 + diceCount.indexOf(2) * 100;
                break;
            case 3:
                price = 10000 + diceCount.indexOf(3) * 1000;
        }

        System.out.print(price);

    }
}