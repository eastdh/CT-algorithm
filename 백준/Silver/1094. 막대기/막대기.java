import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        System.out.println(Integer.toBinaryString(target).replaceAll("0", "").length());
    }
}