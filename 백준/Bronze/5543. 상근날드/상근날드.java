import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] burgers = new int[3];
        int[] beverages = new int[2];
        
        burgers[0] = sc.nextInt();
        burgers[1] = sc.nextInt();
        burgers[2] = sc.nextInt();
        beverages[0] = sc.nextInt();
        beverages[1] = sc.nextInt();
        
        int minSet = Integer.MAX_VALUE;
        for (int burger : burgers) {
            for (int beverage : beverages) {
                minSet = Math.min(minSet, burger+beverage-50);
            }
        }
        
        System.out.println(minSet);
    }
}